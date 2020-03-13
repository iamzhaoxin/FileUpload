import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "Upload2",value = "/upload2")
@MultipartConfig(maxFileSize = 1024*1024*100,maxRequestSize = 1024*1024*200)
public class Upload2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        //2.获得文件上传路径
        String realPath = request.getServletContext().getRealPath("/WEB-INF/upload2");
        File file= new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }

        //文件上传
        //1.通过请求获得多分部的集合
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            //2.在part获得当前上传的是文件还是普通表单
            String filename = part.getSubmittedFileName();
            if(filename!=null){
                //是文件--->上传（路径+文件名）
                part.write(realPath+File.separator+filename);  //windows用\\，Linux用/,用File.separator自动解析分隔符
                part.delete();
            }else{
                //...打印或上传至数据库  调用service
                String name = part.getName();
                String parameter = request.getParameter(name);


                DBconnection db=new DBconnection();
                Connection conn=db.getConn();

                String sql="update work2 set judge=? where number=?";
                PreparedStatement pstmt = null;
                try {
                    pstmt = conn.prepareStatement(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    pstmt.setInt(1,1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    pstmt.setString(2,parameter);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    pstmt.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        response.sendRedirect("successful.html");
    }
}
