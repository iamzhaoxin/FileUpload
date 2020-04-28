#  upload

因为收班级心得体会的时候，QQ上一个个另存为，最后还要对名单，嗯，搞事情吧

使用**jsp+servlet**，感谢 [YouTube上的一个教程](https://www.youtube.com/watch?v=LeFCQR516_U&list=WL&index=2&t=1313s)和各位大佬的博客（比如[java web 学习总结](https://www.cnblogs.com/xdp-gacl/p/3729033.html) ，etc）

原理非常简单，会的一看就懂，不会的也解释不清:no_mouth:，可以去看一看上面那个视频~

+  注意配置ecs上的java环境和IDEA一致

#  FileUpload_1

增加了**验证是否上传成功**的功能，学习了用response将数据返回给jsp

感谢**黄小凤大佬**的推荐，使用了`bootstrap`做前端页面（虽然不太会用，还是很丑:cry:)

#  FileUpload_2

学了些`css`，但没学会`JavaScript`,优化了一下UI,因为遇到了各种bug,所以也增加了一些错误代码



+ ecs上tomcat的lib目录里缺少包-->本地运行正常,线上异常
+ 数据库连接失败-->增加了对数据库连接状态的判断
+ Java对数据库的操作方式-->关键字用`''`
+ 添加SSL证书后,80端口可正常使用,443端口上传文件成功概率 $\cfrac{1}{8}$ ,emmm，不会破

#  FileUpload_3

GG

