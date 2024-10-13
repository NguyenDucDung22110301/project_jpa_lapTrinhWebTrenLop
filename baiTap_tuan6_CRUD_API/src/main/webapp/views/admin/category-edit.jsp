<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/category/update" method="post">
		<div class="mb-3">
			<input type="text"
				class="form-control" id="exampleInputEmail1" name="categoryId"
				aria-describedby="emailHelp" value = "${cate.categoryId}" hidden="hidden">
		</div>
		<div class="mb-3">
			<label class="form-label">categoryName: </label> <input type="text"
				class="form-control" id="exampleInputEmail1" name="categoryName"
				aria-describedby="emailHelp" value = "${cate.categoryName}">
		</div>
		<div class="mb-3">
			<label class="form-label">images: </label> 
			<c:if test="${cate.images.substring(0,5) != 'https'}">
				<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
			</c:if>
			<c:if test="${cate.images.substring(0,5) == 'https'}">
				<c:url value = "${cate.images}" var ="imgUrl">
				</c:url>
			</c:if>
			<img height="150" width = "200" src = "${imgUrl}">
		<input type="file"
				class="form-control" id="exampleInputEmail1" name="categoryId"
				aria-describedby="emailHelp">
		</div>
		<div class="mb-3">
			<label class="form-label">status: </label> 
			<input type="text"
				class="form-control" id="exampleInputEmail1" name="status"
				aria-describedby="emailHelp" value = "${cate.status}">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>