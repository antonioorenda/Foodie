<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<!--Head-->
<jsp:include page="head.jsp"/>
<!-- /head -->

<body>

<!--Header-->
<jsp:include page="header.jsp"/>
<!-- /header -->

<section class="title">
    <div class="container">
        <div class="row-fluid">
            <div class="span6">
                <h1>Registration</h1>
            </div>
            <div class="span6">
                <ul class="breadcrumb pull-right">
                    <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                    <li><a href="#">Pages</a> <span class="divider">/</span></li>
                    <li class="active">Registration</li>
                </ul>
            </div>
        </div>
    </div>
</section>

<section id="registration-page" class="container">

    <c:if test="${registrationError}">
        <div class="status alert alert-error" id="displayError">Fill out all fields!</div>
    </c:if>

    <c:if test="${usernameExists}">
        <div class="status alert alert-error" id="displayError">User with that username already exists! Choose another
            username.
        </div>
    </c:if>

    <form class="center" action="registration" method="POST">
        <fieldset class="registration-form">
            <div class="control-group">
                <!-- Username -->
                <div class="controls">
                    <input type="text" id="username" required name="username" placeholder="Username"
                           class="input-xlarge">
                </div>
            </div>

            <div class="control-group">
                <!-- E-mail -->
                <div class="controls">
                    <input type="email" id="email" required name="email" placeholder="E-mail" class="input-xlarge">
                </div>
            </div>

            <div class="control-group">
                <!-- Password-->
                <div class="controls">
                    <input type="password" id="password" required name="password" placeholder="Password"
                           class="input-xlarge">
                </div>
            </div>

            <div class="control-group allergens">
                <!-- Allergens -->
                <div class="controls">
                    <input type="text" style="float: left; width: 82%;" id="allergens" name="allergens"
                           placeholder="Allergen 1" class="input-xlarge">
                </div>

                <div style="display: inline-flex;">
                    <img class="" id="add_allergens" style="cursor: pointer;" alt="Add more allergens"
                         src="${pageContext.request.contextPath}/resources/images/add.png">
                    <img class="img-responsive display-none subtract_allergen" style="cursor: pointer;"
                         alt="Remove allergen"
                         src="${pageContext.request.contextPath}/resources/images/minus.png">
                </div>

            </div>

            <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button type="submit" class="btn btn-success btn-large btn-block">Register</button>
                </div>
            </div>
        </fieldset>
    </form>
</section>

<!--Footer-->
<jsp:include page="footer.jsp"/>
<!--/Footer-->

<!--  Login form -->
<jsp:include page="login.jsp"/>
<!--  /Login form -->

<!--  Scripts -->
<jsp:include page="scripts.jsp"/>
<!--  Scripts -->

<script>
    $(".nav").find('li').removeClass('active');
    var size = $(".nav").find('li').size();
    $($(".nav").find('li')[size - 1]).addClass("active");
</script>

</body>
</html>
