<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                <h1>About Us</h1>
            </div>
            <div class="span6">
                <ul class="breadcrumb pull-right">
                    <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                    <li class="active">About Us</li>
                </ul>
            </div>
        </div>
    </div>
</section>
<!-- / .title -->

<div id="about-us" class="container">

    <h1 class="center">${recipe.title}</h1>

    <hr>

    <div>
        <i class="fa fa-cutlery"></i> ${recipe.foodType.title} &nbsp;&nbsp;
        <i class="fa fa-tachometer"></i> ${recipe.skillLevel} &nbsp;&nbsp;
        <i class="fa fa-clock-o"></i> ${recipe.makingTime} min &nbsp;&nbsp;

        <div style="float: right;">
            <i class="fa fa-calendar"></i>
            <fmt:formatDate value="${recipe.uploadDate}" pattern="dd.MM.yyyy"/> &nbsp;&nbsp;

            <i class="fa fa-user-o"></i> <b>${recipe.user.username}</b> &nbsp;&nbsp;

            <i class="fa fa-eye"></i> ${recipe.readCount}
        </div>
    </div>

    <hr>

    <div class=frame-read-recipe>
        <span class="helper"></span>

        <c:if test="${recipe.imageBase64 != null}">
            <img class="read-recipe-image" src="data:image/*;base64,${recipe.imageBase64}"/>
        </c:if>

        <c:if test="${recipe.imageBase64 == null}">
            <img class="read-recipe-image" src="${pageContext.request.contextPath}/resources/images/pizza.jpg"/>
        </c:if>

    </div>

    <hr>

    <div class="row-fluid">

        <div class="span4" style="">
            <h2 style="margin-bottom: 15px;">Ingredients</h2>

            <c:forEach items="${recipe.ingredients}" var="ingredient">

                <p style="font-size: 16px;">${ingredient.amount} g ${ingredient.title}</p>

            </c:forEach>

        </div>

        <div class="span8">
            <h2 style="margin-bottom: 15px;">Preparation</h2>

            <% int i = 1; %>

            <c:forEach items="${recipe.stages}" var="stage">

                <p style="font-size: 16px;">
                    <% out.print(i + ". ");
                        i++; %>
                        ${stage.stage}
                </p>

                <hr>

            </c:forEach>

        </div>

    </div>

    <hr>

</div>

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
</script>

</body>
</html>
