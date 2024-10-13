<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous">
</script>
</head>
<body>
<a href = "${pageContext.request.contextPath}/admin/category/add"> add category </a>
	<table border="1" width="100%" class="table">
		<thead>
			<tr>
				<th scope="col">stt</th>
				<th scope="col">image</th>
				<th scope="col">categoryId</th>
				<th scope="col">categoryName</th>
				<th scope="col">status</th>
				<th scope="col">action</th>
			</tr>
		</thead>
		<c:forEach items="${listcase}" var="cate" varStatus="STT">
			<tr>
				<td>${STT.index+1}</td>
				<td>
					<c:if test="${cate.images.substring(0,5) != 'https'}">
						<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
					</c:if>
					<c:if test="${cate.images.substring(0,5) == 'https'}">
						<c:url value = "${cate.images}" var ="imgUrl">
						</c:url>
					</c:if>
					<img height="150" width="200" src="${imgUrl}" />
				</td>
				<td>${cate.categoryId}</td>
				<td>${cate.categoryName }</td>

				<td><c:if test="${cate.status  == 1}">
						<span> hoat dong </span>
					</c:if> <c:if test="${cate.status  != 1}">
						<span> khong hoat dong </span>
					</c:if></td>
				<td><a
					href="<c:url value='/admin/category/edit?id=${cate.categoryId }'/>">Sửa</a>
					| <a
					href="<c:url value='/admin/category/delete?id=${cate.categoryId }'/>">Xóa</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>