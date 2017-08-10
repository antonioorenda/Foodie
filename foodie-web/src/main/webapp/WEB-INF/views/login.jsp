<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal hide fade in" id="loginForm" aria-hidden="false">
    <div class="modal-header">
        <i class="icon-remove" id="dismissLogin" data-dismiss="modal" aria-hidden="true"></i>
        <h4>User Login</h4>
    </div>
    <!--Modal Body-->
    <div class="modal-body">
        <c:if test="${loginError}">
            <div class="status alert alert-error" id="displayError">Wrong username or password!</div>
        </c:if>

        <form class="form-inline" action="login" method="POST" modelAttribute="User" id="form-login">
            <input type="text" required class="input-small" name="username" placeholder="Username">
            <input type="password" required class="input-small" name="password" placeholder="Password">
            <button type="submit" class="btn btn-primary">Sign in</button>
            &nbsp;&nbsp;&nbsp;&nbsp; or &nbsp;&nbsp;&nbsp;&nbsp;
            <a class="btn btn-social" href="${pageContext.request.contextPath}/registration" style="background: #2dcc70;">Register</a>
        </form>
    </div>
    <!--/Modal Body-->
</div>