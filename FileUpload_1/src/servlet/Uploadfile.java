package servlet;

import Db.DBconnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Collection;

@WebServlet(name = "Uploadfile",value = "/upload")
@MultipartConfig()
public class Uploadfile extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException, ServletException {
        //接受数据的编码和返回数据的格式及编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //文件存储路径
        String savepath1=request.getServletContext().getRealPath("WEB-INF/第一篇心得"),savepath2=request.getServletContext().getRealPath("WEB-INF/第二篇心得");
        File file1=new File(savepath1),file2=new File(savepath2);
        if(!file1.exists()&&!file1.isDirectory()){
            file1.mkdir();
        }
        if(!file2.exists()&&!file2.isDirectory()){
            file2.mkdir();
        }

        //逐个处理得到的多部文件
        Collection<Part> parts = request.getParts();
        int i=0;
        String[] res=new String[3];
        for (Part part:parts){
            String filename=part.getSubmittedFileName();
            //如果得到的是姓名数据，filename就是null
            if(filename!=null){
                part.write((i==0?savepath1:savepath2)+File.separator+filename);
                File temp=new File((i==0?savepath1:savepath2)+File.separator+filename);
                if(temp.exists()){
                    res[i]="心得"+(i+1)+"上传成功！文件名："+filename;
                }else{
                    res[i]="心得"+(i+1)+"上传失败,不要使用微信内置浏览器哦";
                }
                i++;
                part.delete();
            }else {
                String name=part.getName();  //name = "username"
                String parameter =request.getParameter(name);  //根据name标签（也就是username）取出对应的内容

                DBconnection db=new DBconnection();
                Connection conn=db.getConn();
                String sql="update 提交状态 set 状态=? where 姓名=?";
                PreparedStatement pstmt = null;
                try {
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1,1);
                    pstmt.setString(2,parameter);
                    pstmt.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                String check="select * from 提交状态 where 姓名='"+parameter+"'";
                try {
                    Statement st=(Statement)conn.createStatement();
                    ResultSet rs=(ResultSet)st.executeQuery(check);

                    if(rs.next()){
                        if(rs.getInt("状态")==1){
                            res[2]=parameter+" 提交成功";
                        }else{
                            res[2]=parameter+" 提交状态修改失败";
                        }
                    }else{
                        res[2]=parameter+" 查无此人";
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("result1",res[0]);
        request.setAttribute("result2",res[1]);
        request.setAttribute("result3",res[2]);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}

































