<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<Resource
    	name = "jdbc/to_do_list"
    	auth = "Container"
    	type = "javax.sql.DataSource"
    	maxTotal = "8"
    	maxIdle = "30"
    	maxWaitMillis = "-1"
    	username = "root"
    	password = "qwer1234"
    	driverClassName = "com.mysql.cj.jdbc.Driver"
    	url = "jdbc:mysql://192.168.150.229:3306/to_do_list?serverTimezone=Asia/Seoul&amp;characterEncoding=utf8&amp;useSSL=false"
   />


</body>
</html>