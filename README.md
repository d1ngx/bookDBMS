# bookDBMS
这是一个小项目，基于JSP+Servlet+JavaBean+JDBC+DAO的web架构设计,数据库用的是MySQL。其中注册账号部分用到了Ajax异步检验和正则表达式验证，项目中设计了3个javabean，对应mysql数据库中的3个表，包括图书表(图书号，图书名，作者，出版社，价格)，用户表(用户名和密码)，借书表(借书号，图书号，借书用户名)。具体实现功能如下:</br>
（1）用户分为2类，系统管理员和用户。</br>
（2）提供用户注册和登录验证功能。注册用户名为字母开头，后跟字母或数字并大于6位，密码为6~10位数字。其中注册时利用Ajax技术实现异步验证用户名密码格式是否符合要求。</br>
(3)管理员可以实现对注册用户的管理，并实现对图书的创建，查询，修改和删除等有关操作。</br>
(4)一般用户只能查询图书，并进行借书还书操作，每个用户最多借阅8本，只有还书后才能继续借。</br>

![image](https://github.com/ericdoomed/bookDBMS/blob/master/bookDBMS/WebRoot/pic/bookDBMS.PNG)
![image](https://github.com/ericdoomed/bookDBMS/blob/master/bookDBMS/WebRoot/pic/%E6%8D%95%E8%8E%B7.PNG)
