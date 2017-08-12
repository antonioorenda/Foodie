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

    <h1 class="center">Edit Recipe</h1>

    <hr>

    <div class="row">

        <c:if test="${recipeUpdatedSuccessfully}">
            <div class="status alert alert-success" id="displaySuccess">Updating recipe successful!</div>
        </c:if>

        <form:form class="form-horizontal" action="/foodie/updateRecipe/${recipe.id}" method="POST"
                   modelAttribute="recipe"
                   id="saveRecipeForm" enctype="multipart/form-data">

            <div class="form-group">

                <label for="title" class="col-xs-12 col-md-2 col-lg-2 control-label">Title</label>
                <div class="col-md-4 col-lg-4 col-xs-12">
                    <form:input type="text" name="title" class="form-control" id="title" placeholder="Title"
                                path="title" required="required"/>
                </div>

                <label for="foodType" class="col-xs-12 col-md-2 col-lg-2 control-label">Food Type</label>
                <div class="col-xs-12 col-md-4 col-lg-4">
                    <form:select class="form-control" id="foodType" name="foodType" path="foodType" required="required">
                        <form:option selected="selected" disabled="disabled" style="display: none;" value="0"
                                     label="Choose Food Type"/>
                        <form:options items="${foodTypes}" itemValue="id" itemLabel="title"/>
                    </form:select>
                </div>

            </div>

            <div class="form-group">

                <label for="makingTime" class="col-xs-12 col-md-2 col-lg-2 control-label">Making Time (min)</label>
                <div class="col-xs-12 col-md-4 col-lg-4">
                    <form:input type="number" class="form-control" name="makingTime" id="makingTime" path="makingTime"
                                placeholder="Making Time (min)" required="required"/>
                </div>

                <label for="skillLevel" class="col-xs-12 col-md-2 col-lg-2 control-label">Skill Level</label>
                <div class="col-xs-12 col-sm-4 col-lg-4">
                    <form:select class="form-control" name="skillLevel" id="skillLevel" path="skillLevel"
                                 required="required">
                        <form:option selected="selected" disabled="disabled" style="display: none;" value="0"
                                     label="Choose Skill Level"/>
                        <form:option value="easy" label="Easy"/>
                        <form:option value="intermediate" label="Intermediate"/>
                        <form:option value="advanced" label="Advanced"/>
                    </form:select>
                </div>

            </div>

            <div class="form-group">

                <label for="description" class="col-xs-12 col-md-2 col-lg-2 control-label">Description</label>
                <div class="col-xs-12 col-md-10 col-lg-10">
                    <form:textarea style="width: 96%;" class="form-control" name="description" id="description" rows="1"
                                   cols="" placeholder="Description" path="description"
                                   required="required"></form:textarea>
                </div>

            </div>

            <c:forEach items="${recipe.ingredients}" var="ingredient" varStatus="i">

                <div class="form-group ingredients">


                    <c:if test="${i.index == 0}">
                        <label for="ingredients"
                               class="col-xs-12 col-md-2 col-lg-2 control-label label1">Ingredients</label>
                    </c:if>

                    <c:if test="${i.index != 0}">
                        <label for="ingredients"
                               class="col-xs-12 col-md-2 col-lg-2 control-label label1"></label>
                    </c:if>

                    <div class="col-xs-12 col-md-4 col-lg-4">

                        <form:input type="text" class="form-control input1" name="ingredients" id="ingredients"
                                    placeholder="Ingredient 1" path="ingredients[${i.index}].title"
                                    required="required"/>

                    </div>
                    <label for="amount" class="col-xs-12 col-md-2 col-lg-2 control-label"></label>
                    <div class="col-xs-12 col-md-2 col-lg-2">

                        <form:input type="number" class="form-control" name="amount" id="amount"
                                    placeholder="Amount (g)" path="ingredients[${i.index}].amount" required="required"/>

                    </div>
                    <div class="col-xs-12 col-md-2 col-lg-2" style="display: inline-flex;">

                        <c:if test="${i.index == (recipe.ingredients.size() - 1)}">
                            <img class="img-responsive" id="add_ingredients" style="cursor: pointer;"
                                 alt="Add more ingredients"
                                 src="${pageContext.request.contextPath}/resources/images/add.png">

                            <img class="img-responsive display-none subtract_ingredient" style="cursor: pointer;"
                                 alt="Remove ingredient"
                                 src="${pageContext.request.contextPath}/resources/images/minus.png">
                        </c:if>

                        <c:if test="${i.index != (recipe.ingredients.size() - 1)}">
                            <img class="img-responsive subtract_ingredient" style="cursor: pointer;"
                                 alt="Remove ingredient"
                                 src="${pageContext.request.contextPath}/resources/images/minus.png">
                        </c:if>

                    </div>

                </div>

            </c:forEach>

            <c:forEach items="${recipe.stages}" var="stage" varStatus="i">

                <div class="form-group stages">

                    <c:if test="${i.index == 0}">
                        <label for="stages" class="col-xs-12 col-md-2 col-lg-2 control-label label2">Stages</label>
                    </c:if>

                    <c:if test="${i.index != 0}">
                        <label for="stages" class="col-xs-12 col-md-2 col-lg-2 control-label label2"></label>
                    </c:if>

                    <div class="col-xs-12 col-md-4 col-lg-4">

                        <form:textarea class="form-control stage" name="stages" id="stages" rows="3"
                                       path="stages[${i.index}].stage"
                                       placeholder="Stage 1. description" title="${stage.stage}" required="required"/>

                    </div>
                    <div class="col-xs-12 col-md-2 col-lg-2" style="display: inline-flex;">

                        <c:if test="${i.index == (recipe.stages.size() - 1)}">
                            <img class="img-responsive" id="add_stages" style="cursor: pointer;" alt="Add more stages"
                                 src="${pageContext.request.contextPath}/resources/images/add.png">
                            <img class="img-responsive display-none subtract_stage" style="cursor: pointer;"
                                 alt="Remove stage"
                                 src="${pageContext.request.contextPath}/resources/images/minus.png">
                        </c:if>

                        <c:if test="${i.index != (recipe.stages.size() - 1)}">
                            <img class="img-responsive subtract_stage" style="cursor: pointer;" alt="Remove stage"
                                 src="${pageContext.request.contextPath}/resources/images/minus.png">
                        </c:if>

                    </div>

                </div>

            </c:forEach>

            <div class="form-group">

                <label for="file" class="col-xs-12 col-md-2 col-lg-2 control-label label3">Upload image</label>
                <div class="col-xs-12 col-md-2 col-lg-2">
                    <input type="file" name="file" id="file" accept="image/*">
                </div>

            </div>

            <div class="form-group ">
                <br/>
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

    var loggedIn = <%= (Boolean)session.getAttribute("adminUser") %>;

    if (!loggedIn) {
        $(".nav").find('li').find('a[href="#loginForm"]').click();
    }

</script>

</body>
</html>