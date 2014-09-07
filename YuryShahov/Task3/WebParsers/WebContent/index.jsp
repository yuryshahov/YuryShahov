<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Home</title>
		<style type="text/css">
			.firstwidth{
				width : 200px;
				margin-left: 5px;
				margin-top: 5px;
			}
			.homecontainer {
				border: solid 1px black;
				width: 300px;
				height: 60px;
			}
		</style>
	</head>
	<body>
		<div>
			<h1>Input dom, sax or stax to follow field</h1>
		</div>
		<div class="homecontainer">
			<form action="parser" method="post">
				<div>
					<input class="firstwidth" name="parsertype" type="text" value=""/>
					<font color="FF0000">${ errorMessage }</font>
				</div>
				<div>
					<input class="firstwidth" type="submit" value="Parse"/>
				</div>
			</form>
		</div>
	</body>
</html>