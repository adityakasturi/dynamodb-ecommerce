<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center;">
		<div style="box-sizing: border-box; display: inline-block; width: 800px; max-width: 800px;height:800px; background-color: white; border: 2px; box-shadow: 0px 0px 8px red; margin: 50px auto">
		<div style="background: Orange ; border-radius: 5px 5px; padding: 15px;"><span style="font-family:Times New Roman,arial; color: Grey; font-size: 3.00em; font-weight:bold;">Free and For Sale Application Items</span></div>
		<div style="padding: 15px">
		<style type="text/css">
			table.center{margin-left:auto; margin-right:auto; border: 4px solid blue;}
			td, th { padding: .3em; border: 1px #ccc solid; }
			thead { background: #fc9; }
		</style>
<h1>The Info</h1>
<form method="post" action="http://localhost:8080/AWS_Demo/ItemInformation">
<table border="1" width ="700px" align="center">
				<tr><th>ID</th><th>Name</th><th>Price</th></tr>
<c:forEach items="${info}" var="i">
				<tr>
				<td><input type="submit" name="data" value ="${i.item}"></td>  
				<td>${i.quantity}</td> 
				<td>${i.desc}</td>
				</tr>
				
</c:forEach>
</table>
</form>

<br>
<br>
<form method="post" action="CreateNewRecord">
Create New Record:<input type="text" name="record"><br>
<input type="submit" value="Create" name="createbutton">
</form>

</body>
</html>