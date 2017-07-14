<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<!--Head-->
<jsp:include page="head.jsp"/>
<!-- /head -->

<body>

<!--Header-->
<jsp:include page="header.jsp"/>
<!-- /header -->

<div class="header-home">
    <h1 class="vision">
        Do what <b>tastes</b> right
    </h1>
    <h1 class="vision-small">
        Do what <b>tastes</b> right
    </h1>
    <hr class="vision">
    <h4 class="vision">
        Relax, sit back, and let us do all the work.
    </h4>
</div>

<!--Services-->
<section id="clients">
    <div class="container">
        <!-- Meet the team -->
        <hr>

        <h1 class="center">Today's recommendations</h1>

        <% int i = 0; %>
        <c:forEach items="${allRecipes}" var="recipe" begin="0" end="11">

            <% if (i % 4 == 0 && i > 0) {
                out.print("</div>");
            } %>
            <% if (i % 4 == 0) {
                out.print("<hr><div class='row-fluid'>");
            } %>
            <div class="span3" onclick="location.href='readRecipe/${recipe.id}';" style="cursor:pointer;">
                <div class="box">
                    <div class=frame>
                        <span class="helper"></span>

                        <c:if test="${recipe.imageBase64 != null}">
                            <img class="recipe-image" src="data:image/*;base64,${recipe.imageBase64}" />
                        </c:if>

                        <c:if test="${recipe.imageBase64 == null}">
                            <img class="recipe-image" src="${pageContext.request.contextPath}/resources/images/pizza.jpg" />
                        </c:if>

                    </div>
                    <h5>${recipe.title}</h5>
                    <p>${recipe.description}</p>
                    <a class="btn btn-social btn-facebook" href="#"><i class="icon-facebook"></i></a>
                    <a class="btn btn-social btn-google-plus" href="#"><i class="icon-google-plus"></i></a>
                    <a class="btn btn-social btn-twitter" href="#"><i class="icon-twitter"></i></a>
                </div>
            </div>
            <% i++; %>

        </c:forEach>

    </div>
</section>
<!--/Services-->

<!--  Login form -->
<jsp:include page="login.jsp"/>
<!--  /Login form -->

<!--Footer-->
<jsp:include page="footer.jsp"/>
<!--/Footer-->

<!--  Scripts -->
<jsp:include page="scripts.jsp"/>
<!--  Scripts -->

<script>
    $(".nav").find('li').removeClass('active');
    $($(".nav").find('li')[0]).addClass("active");
</script>

</body>
</html>