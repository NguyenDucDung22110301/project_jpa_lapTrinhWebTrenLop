<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

     <form action="login" method="post">
            <div class="row">
                <p class="myDivP">Đăng Nhập Vào Hệ Thống</p>
                <c:if test="${alert != null}">
				    <h3 class="alert " style="text-align: justify; font-size: 12px;">
				        ${alert}
				    </h3>
				</c:if>
                <div class="form-group">
                    <input type="text" id="username" name="username" class="form-control" placeholder="Tài khoản" required="required">
                </div>
                <div class="form-group">
                    <input type="password" id="password" name="password" class="form-control" placeholder="Mật Khẩu" required="required">
                </div>
                <div class="row" style="display: flex; align-items: center;">
                    <div class="col-lg-3">
                        <div class="checkbox-inline">
                            <input type="checkbox" id="remember" name="remember" /> <label for="remember1">Nhớ tôi</label>
                        </div>
                    </div>
                    <div class="col-lg-5" style="margin-left: auto;">
                        <a href="forgetPass.jsp" class="myDivA">Quên mật khẩu?</a>
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn login-register-container">Đăng Nhập</button>
                </div>
            </div>
        </form>
        <div>
            <p align="center">Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a href="register.jsp" style="color: #6756FA">Đăng ký</a></p>
        </div>
