<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Book Show Page</title>
	</head>
	<body>
		<main>
			<h1>All Books</h1>
			<table>
			    <thead>
			        <tr>
			            <th>Title</th>
			            <th>Description</th>
			            <th>Language</th>
			            <th>Number of Pages</th>
			            <th>Actions</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach var="book" items="${books}">
			        <tr>
			            <td><c:out value="${book.title}"/></td>
			            <td><c:out value="${book.description}"/></td>
			            <td><c:out value="${book.language}"/></td>
			            <td><c:out value="${book.numberOfPages}"/></td>
			            <td><a href="/books/${book.id}">Show</a></td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
			<button>
				<a href="/books/new">New Book</a>
			</button>
		</main>
	</body>
</html>