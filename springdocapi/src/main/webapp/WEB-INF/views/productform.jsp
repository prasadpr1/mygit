<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="header.productform" /></title>
</head>
<body>
	<c:if test="${iserror}">
		<p style="color: red">
			<c:out value="One more mandatroy fields missing" />
		<p>
	</c:if>
	<h2>Add Product</h2>
	<form:form modelAttribute="product" action="/product/save"
		method="POST">
		<table>
			<tr>
				<td>Product Id*</td>
				<td><form:input path="productId" /></td>
			</tr>
			<tr>
				<td>Product Name*</td>
				<td><form:input path="productName" /></td>
			</tr>
			<tr>
				<td>Product Price*</td>
				<td><form:input path="productPrice" /></td>
			</tr>
			<tr>
				<td>Product Qty*</td>
				<td><form:input path="productQty" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
	<button onclick="window.location='/';" value="Home">Home</button>
</body>
<style>
tr, td {
	padding: 20px;
}

td {
	margin: 2px;
}

h3 {
	padding-left: 20px;
	text-decoration: underline;
}

a {
	text-decoration: none;
}

input[type="submit"]:hover, button:hover {
	background-color: #4CAF50;
	color: white;
	cursor: pointer;
}

button {
	margin-left: 20px;
	display: inline;
}
</style>
</html>