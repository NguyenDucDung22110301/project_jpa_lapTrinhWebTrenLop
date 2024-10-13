<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> thay đổi mật khẩu </title>
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
<style>

.bg-gray-100 {
    background-color: #f4f4f4;
}

.flex {
    display: flex;
}

.items-center {
    align-items: center;
}

.justify-center {
    justify-content: center;
}

.h-screen {
    height: 100vh;
}

.bg-white {
    background-color: white;
}

.p-10 {
    padding: 2.5rem;
}

.rounded-lg {
    border-radius: 0.5rem;
}

.shadow-lg {
    box-shadow: 0 10px 15px rgba(0, 0, 0, 0.1);
}

.max-w-md {
    max-width: 28rem;
}

.w-full {
    width: 100%;
}

.mb-6 {
    margin-bottom: 1.5rem;
}

.text-xl {
    font-size: 1.25rem;
}

.font-semibold {
    font-weight: 600;
}

.text-sm {
    font-size: 0.875rem;
}

.text-gray-600 {
    color: #718096;
}

.space-y-6 > * + * {
    margin-top: 1.5rem;
}

.form-input {
    padding: 0.5rem;
    border: 1px solid #e2e8f0;
    border-radius: 0.375rem;
    box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
}

.form-input:focus {
    border-color: #3182ce;
    box-shadow: 0 0 0 1px #3182ce;
}

.text-blue-600 {
    color: #3182ce;
}

.hover\:underline:hover {
    text-decoration: underline;
}

.text-red-500 {
    color: #f56565;
}

.list-disc {
    list-style-type: disc;
}

.pl-5 {
    padding-left: 1.25rem;
}

.space-y-1 > * + * {
    margin-top: 0.25rem;
}

.px-4 {
    padding-left: 1rem;
    padding-right: 1rem;
}

.py-2 {
    padding-top: 0.5rem;
    padding-bottom: 0.5rem;
}

.bg-gray-200 {
    background-color: #edf2f7;
}

.hover\:bg-gray-300:hover {
    background-color: #e2e8f0;
}

.focus\:outline-none:focus {
    outline: 2px solid transparent;
    outline-offset: 2px;
}

.focus\:ring:focus {
    box-shadow: 0 0 0 3px rgba(66, 153, 225, 0.5);
}

.focus\:border-blue-300:focus {
    border-color: #63b3ed;
}

.bg-blue-600 {
    background-color: #3182ce;
}

.hover\:bg-blue-700:hover {
    background-color: #2b6cb0;
}

.text-white {
    color: white;
}

.rounded-md {
    border-radius: 0.375rem;
}

</style>
</head>
<body>
	<div class="bg-gray-100 flex items-center justify-center h-screen">
    <div class="bg-white p-10 rounded-lg shadow-lg max-w-md w-full">
        <div class="flex items-center space-x-2 mb-6">
            <img src="https://unsplash.it/40/40?image=883" alt="Lock Icon" class="rounded-full">
            <h1 class="text-xl font-semibold">  Thay đổi mật khẩu </h1> 
        </div>
        <p class="text-sm text-gray-600 mb-6"> cập nhật hoặc nâng cao bảo mật cho mật khẩu. </p>
        <form id="changePasswordForm" class="space-y-6" action = "changePass" method = "post">
            <c:if test="${alert != null}">
				    <h3 class="alert" style="text-align: justify; font-size: 12px;">
				        ${alert}
				    </h3>
			</c:if>
            <div>
                <label for="currentPassword" class="text-sm font-medium text-gray-700 block mb-2"> Mật khẩu hiện tại *</label>
                <input type="password" id="currentPassword" name = "oldpassword" class="password-input form-input block w-full border border-gray-300 rounded-md shadow-sm" required>
            </div>
            <div>
                <label for="newPassword" class="text-sm font-medium text-gray-700 block mb-2"> Mật khẩu mới *</label>
                <input type="password" id="newPassword" name = "repassword" class="password-input form-input block w-full border border-gray-300 rounded-md shadow-sm" required>
            </div>
            <div>
                <label for="confirmPassword" class="text-sm font-medium text-gray-700 block mb-2"> Xác nhận mật khẩu *</label>
                <input type="password" id="confirmPassword" name = "newrepassword" class="password-input form-input block border w-full border-gray-300 rounded-md shadow-sm" required>
            </div>
            <div class="flex justify-between">
                <button type="submit" class="px-4 py-2 text-sm font-medium text-white bg-blue-600 rounded-md hover:bg-blue-700 focus:outline-none focus:ring focus:border-blue-300">Apply Changes</button>
            </div>
        </form>
        <p align="center"> Quay lại trang chủ <a href="../index.jsp" style="color: #6756FA"> home </a></p>
    </div>
</div>
	
</body>
</html>