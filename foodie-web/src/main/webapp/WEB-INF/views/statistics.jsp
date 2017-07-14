<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<!--Head-->
    <jsp:include page="head.jsp" />
<!-- /head -->

<body>

    <!--Header-->
		<jsp:include page="header.jsp" />    	
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

    <section id="about-us" class="container main">

        <!-- Meet the team -->
        <h1 class="center">Admin Statistics</h1>
        
        <hr>
        
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

<!--Footer-->
	<jsp:include page="footer.jsp" />
<!--/Footer-->

<!--  Login form -->
	<jsp:include page="login.jsp" />
<!--  /Login form -->

<!--  Scripts -->
	<jsp:include page="scripts.jsp" />
<!--  Scripts -->

<script>
	$(".nav").find('li').removeClass('active');
	var size = $(".nav").find('li').size();
	$($(".nav").find('li')[size-3]).addClass("active");
	
	var lastComma = $("#topRecipes a").last().text();
	lastComma = lastComma.slice(0, -3);
	$("#topRecipes a").last().text(lastComma);
</script>

</body>
</html>