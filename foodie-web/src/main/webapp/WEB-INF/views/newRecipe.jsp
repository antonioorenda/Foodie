<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                <h1>Add New Recipe</h1>
            </div>
            <div class="span6">
                <ul class="breadcrumb pull-right">
                    <li><a href="home.jsp">Home</a> <span class="divider">/</span></li>
                    <li class="active">New Recipe</li>
                </ul>
            </div>
        </div>
    </div>
</section>
<!-- / .title -->

<section id="contact-page" class="container main">

    <h1 class="center">Add New Recipe</h1>

    <hr>

    <div class="row">

        <c:if test="${not empty recipeAddedSuccessfully}">
            <div class="status alert alert-success" id="displaySuccess">Uploading new recipe successful!</div>
        </c:if>

        <c:if test="${not empty recipeHasErrors}">
            <div class="status alert alert-error" id="displayError">Fill out all fields!</div>
        </c:if>

        <form:form class="form-horizontal" action="saveNewRecipe" method="POST" modelAttribute="recipe"
                   id="saveRecipeForm" enctype="multipart/form-data">

            <div class="form-group">

                <label for="title" class="col-xs-12 col-md-2 col-lg-2 control-label">Title</label>
                <div class="col-md-4 col-lg-4 col-xs-12">
                    <input type="text" name="title" class="form-control" id="title" placeholder="Title" required>
                </div>

                <label for="foodType" class="col-xs-12 col-md-2 col-lg-2 control-label">Food Type</label>
                <div class="col-xs-12 col-md-4 col-lg-4">
                    <select class="form-control" id="foodType" name="foodType" path="foodType.id" required>
                        <option selected="selected" disabled="disabled" style="display: none;" value="">Choose Food
                            Type
                        </option>

                        <c:forEach items="${foodTypes}" var="foodType">
                            <option value="${foodType.id}">${foodType.title}</option>
                        </c:forEach>

                    </select>
                </div>

            </div>

            <div class="form-group">

                <label for="makingTime" class="col-xs-12 col-md-2 col-lg-2 control-label">Making Time (min)</label>
                <div class="col-xs-12 col-md-4 col-lg-4">
                    <input type="number" class="form-control" name="makingTime" id="makingTime"
                           placeholder="Making Time (min)" required>
                </div>

                <label for="skillLevel" class="col-xs-12 col-md-2 col-lg-2 control-label">Skill Level</label>
                <div class="col-xs-12 col-sm-4 col-lg-4">
                    <select class="form-control" name="skillLevel" id="skillLevel" required>
                        <option selected="selected" disabled="disabled" style="display: none;" value="">Choose Skill
                            Level
                        </option>
                        <option value="Easy">Easy</option>
                        <option value="Intermediate">Intermediate</option>
                        <option value="Advanced">Advanced</option>
                    </select>
                </div>

            </div>

            <div class="form-group">

                <label for="description" class="col-xs-12 col-md-2 col-lg-2 control-label">Description</label>
                <div class="col-xs-12 col-md-10 col-lg-10">
                    <textarea style="width: 96%;" class="form-control" name="description" id="description" rows="1"
                              cols="" placeholder="Description" required></textarea>
                </div>

            </div>

            <div class="form-group ingredients">

                <label for="ingredients" class="col-xs-12 col-md-2 col-lg-2 control-label label1">Ingredients</label>
                <div class="col-xs-12 col-md-4 col-lg-4">
                    <input type="text" class="form-control input1" name="ingredients" id="ingredients"
                           placeholder="Ingredient 1" required>
                </div>
                <label for="amount" class="col-xs-12 col-md-2 col-lg-2 control-label"></label>
                <div class="col-xs-12 col-md-2 col-lg-2">
                    <input type="number" class="form-control" name="amount" id="amount" placeholder="Amount (g)"
                           required>
                </div>
                <div class="col-xs-12 col-md-2 col-lg-2" style="display: inline-flex;">
                    <img class="img-responsive" id="add_ingredients" style="cursor: pointer;" alt="Add more ingredients"
                         src="${pageContext.request.contextPath}/resources/images/add.png">
                    <img class="img-responsive display-none subtract_ingredient" style="cursor: pointer;"
                         alt="Remove ingredient" src="${pageContext.request.contextPath}/resources/images/minus.png">
                </div>

            </div>

            <div class="form-group stages">

                <label for="stages" class="col-xs-12 col-md-2 col-lg-2 control-label label2">Stages</label>
                <div class="col-xs-12 col-md-4 col-lg-4">
                    <textarea class="form-control" name="stages" id="stages" rows="3" cols=""
                              placeholder="Stage 1. description" required></textarea>
                </div>
                <div class="col-xs-12 col-md-2 col-lg-2" style="display: inline-flex;">
                    <img class="img-responsive" id="add_stages" style="cursor: pointer;" alt="Add more stages"
                         src="${pageContext.request.contextPath}/resources/images/add.png">
                    <img class="img-responsive display-none subtract_stage" style="cursor: pointer;" alt="Remove stage"
                         src="${pageContext.request.contextPath}/resources/images/minus.png">
                </div>

            </div>

            <div class="form-group">

                <label for="file" class="col-xs-12 col-md-2 col-lg-2 control-label label3">Upload image</label>
                <div class="col-xs-12 col-md-2 col-lg-2">
                    <input type="file" name="file" id="file" accept="image/*" required>
                </div>

            </div>

            <div class="form-group ">
                <br/>
                <!-- <button type="button" class="btn btn-success btn-lg col-lg-offset-1">Preview</button> -->
                <button type="submit" class="btn btn-success btn-block" id="saveButton">Save</button>

            </div>

        </form:form>

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
    $($(".nav").find('li')[3]).addClass("active");

    var loggedIn = <%= (Boolean)session.getAttribute("adminUser") %>;
    var loginError = "${loginError}";

    console.log(loginError);

    if (!loggedIn && !loginError) {
        $(".nav").find('li').find('a[href="#loginForm"]').click();
    }
</script>

</body>
</html>
