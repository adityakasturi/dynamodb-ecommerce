<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><div style="text-align: center;">
		<div style="box-sizing: border-box; display: inline-block; width: 800px; max-width: 800px;height:800px; background-color: white; border: 2px; box-shadow: 0px 0px 8px red; margin: 50px auto">
		<div style="background: Orange ; border-radius: 5px 5px; padding: 15px;"><span style="font-family:Times New Roman,arial; color: Grey; font-size: 3.00em; font-weight:bold;">Free and For Sale Application Items</span></div>
		<div style="padding: 15px">
		<style type="text/css">
			table.center{margin-left:auto; margin-right:auto; border: 4px solid blue;}
			td, th { padding: .3em; border: 1px #ccc solid; }
			thead { background: #fc9; }
		</style>
		
<%!
public String id = "";
%>
<h2>Details</h2> 

<table border="1" width ="700px" align="center">
		<c:set var="i" value="${details}" scope="application"/>
		
		<c:set var="test" value="${i.id}"/>
		
		<% 
		if(id==""){
			id=id+(String)pageContext.getAttribute("test");
		}
		%>
				<tr>
				<td>Id</td>
				<td>${i.id}</td> 
				</tr>
				
				<tr>
				<td>Name</td>
				<td>${i.name}</td> 
				</tr>
				
				<tr>
				<td>Price</td>
				<td>${i.price}</td> 
				</tr>
				
				<c:forEach items="${i.desc}" var="list" varStatus="loop">
				
				<tr>
				<td>Description ${loop.index+1}</td>
				<td>${list}</td>
				</tr>
				
				</c:forEach>
				
</table>
<br>
<br>
  
<form method="post" action=UpdateItem>
<input type="submit" value="update" name="ghj"/>
Attribute:<input type="text" name="Attribute"><br>  
Value:<input type="text" name="Value"><br>
<input type="hidden"  name="up" value="<%=id%>">
</form>
<form method="post" action=DeleteItem >
<input type="submit" value="delete" name="${id}"/>
<input type="hidden"  name="dl" value="<%=id%>">
<% id = ""; %>
</form>
</body>
</html>