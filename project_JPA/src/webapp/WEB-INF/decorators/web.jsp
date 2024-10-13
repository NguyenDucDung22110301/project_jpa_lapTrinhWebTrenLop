<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
   	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="format-detection" content="telephone=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="author" content="">
	<meta name="keywords" content="">
	<meta name="description" content="">
	<style>
        .myDivP {
            font-family: uniset;
            text-align: center;
            color: #A5A3A3;
            font-size: 30px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }

        .form-group input {
            width: 95%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }

        .form-group button:hover {
            background-color: #0056b3;
        }

        .toggle-link {
            text-align: center;
            margin-top: 20px;
            color: #007bff;
            cursor: pointer;
        }

        .toggle-link:hover {
            text-decoration: underline;
        }

        .myDivA {
            color: #929191;
        }
        body {
    display: flex;
    justify-content: center; /* Căn giữa theo chiều ngang */
    align-items: center;     /* Căn giữa theo chiều dọc */
    min-height: 100vh;       /* Chiều cao tối thiểu 100% chiều cao màn hình */
    margin: 0;
    background-color: #f8f9fa; /* Nền trang nhẹ */
}

/* Căn chỉnh form đăng nhập */
#content {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    padding: 20px;
}

.login-container {
    max-width: 400px;        /* Đặt chiều rộng tối đa cho form */
    background-color: #fff;  /* Nền trắng cho form */
    padding: 20px;
    border-radius: 10px;     /* Bo góc */
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); /* Hiệu ứng bóng đổ */
}
       </style>
       
	<link rel="stylesheet" type="text/css" href="/bootstrap-3.3.2-dist/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/bootstrap-3.3.2-dist/css/main.css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css"  href="../css/normalize.css">
	<link rel="stylesheet" type="text/css"  href="../css/normalize.css">
	<link rel="stylesheet" type="text/css"  href="../css/vendor.css">
	<link rel="stylesheet" type="text/css"  href="../css/style.css" />
	
</head>
<body>
	 <div id="container">
		<div>
			<%@ include file="/commons/web/header.jsp"%>
		</div>
		<div>
			<sitemesh:write property="body"/>
		</div>
		<div>
			<%@ include file="/commons/web/footer.jsp"%>
		</div>
		</div>
</body>
</html>
