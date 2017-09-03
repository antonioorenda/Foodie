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

<section id="about-us" class="container" style="padding-bottom: 0px;">

    <h1 class="center">Admin Statistics</h1>

    <hr>

    <form class="form-inline" action="${pageContext.request.contextPath}/search">
        <input type="text" name="title" placeholder="Title"/>

        <select class="form-control" name="skillLevel" id="skillLevel">
            <option selected="selected" disabled="disabled" style="display: none;">Skill Level</option>
            <option value="Easy">Easy</option>
            <option value="Intermediate">Intermediate</option>
            <option value="Advanced">Advanced</option>
        </select>

        <select class="form-control" id="foodType" name="foodType">
            <option selected="selected" disabled="disabled" style="display: none;">Food Type</option>

            <c:forEach items="${foodTypes}" var="foodType">
                <option value="${foodType.id}">${foodType.title}</option>
            </c:forEach>
        </select>

        <input id="dateFrom" class="datetimepicker" name="dateFrom" type="text" placeholder="Uploaded from"/>

        <input id="dateTo" class="datetimepicker" type="text" name="dateTo" placeholder="Uploaded to"/>

        <button type="submit" class="btn btn-primary btn-large" style="border-radius: 20px">Search</button>
    </form>

    <div class="row">

        <div class="form-group">

            <label for="title" class="col-xs-2 col-md-2 col-lg-2 control-label">Number of users</label>
            <div class="col-md-10 col-lg-10 col-xs-10">
                <p>${numberOfUsers}</p>
            </div>

        </div>

        <div class="form-group">

            <label for="title" class="col-xs-2 col-md-2 col-lg-2 control-label">Number of recipes</label>
            <div class="col-md-10 col-lg-10 col-xs-10">
                <p>${numberOfRecipes}</p>
            </div>

        </div>

        <div class="form-group">

            <label for="title" class="col-xs-2 col-md-2 col-lg-2 control-label">Top 5 recipes</label>
            <div class="col-md-10 col-lg-10 col-xs-10" id="topRecipes">
                <p>
                    <c:forEach items="${topRecipes}" var="recipe">
                        <a href="readRecipe/${recipe.id}">${recipe.title}, </a>
                    </c:forEach>
                </p>
            </div>

        </div>

        <div class="form-group">

            <label for="title" class="col-xs-2 col-md-2 col-lg-2 control-label">Top 5 ingredients</label>
            <div class="col-md-10 col-lg-10 col-xs-10">
                <p>${topIngredients}</p>
            </div>

        </div>

        <div class="form-group">

            <label for="title" class="col-xs-2 col-md-2 col-lg-2 control-label">Top 5 allergens</label>
            <div class="col-md-10 col-lg-10 col-xs-10">
                <p>${topAllergens}</p>
            </div>

        </div>
    </div>
</section>

<section id="clients" style="padding-top: 0px;">
    <div class="container">

        <% int i = 0; %>
        <c:forEach items="${recipes}" var="recipe" begin="0" end="11">

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
                            <img class="recipe-image" src="data:image/*;base64,${recipe.imageBase64}"/>
                        </c:if>

                        <c:if test="${recipe.imageBase64 == null}">
                            <img class="recipe-image"
                                 src="${pageContext.request.contextPath}/resources/images/pizza.jpg"/>
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

        <c:if test="${recipes.size() == 0}">
            <div class="status alert alert-error" id="displayError">No recipe matches your criteria!</div>
        </c:if>

    </div>
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
    $($(".nav").find('li')[size - 3]).addClass("active");

    var lastComma = $("#topRecipes a").last().text();
    lastComma = lastComma.slice(0, -3);
    $("#topRecipes a").last().text(lastComma);
</script>

<script>
    jQuery('.datetimepicker').datetimepicker({
        timepicker: false,
        format: 'd.m.Y'
    });
</script>

</body>
</html>