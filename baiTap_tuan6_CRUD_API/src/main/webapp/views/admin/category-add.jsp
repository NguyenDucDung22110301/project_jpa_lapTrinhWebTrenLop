<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="${pageContext.request.contextPath}/admin/category/insert" method="post" enctype="multipart/form-data">
		<div class="mb-3">
			<label class="form-label">categoryName: </label> <input type="text"
				class="form-control" id="exampleInputEmail1" name="categoryName"
				aria-describedby="emailHelp">
		</div>
		<div class="mb-3">
			<label class="form-label">images: </label> <input type="file"
				class="form-control" id="exampleInputEmail1" name="images"
				aria-describedby="emailHelp">
		</div>
		<div class="mb-3">
			<label class="form-label">status: </label> <input type="text"
				class="form-control" id="exampleInputEmail1" name="status"
				aria-describedby="emailHelp">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>