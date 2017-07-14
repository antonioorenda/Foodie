<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
  <!-- / .title -->       


  <section id="registration-page" class="container">
    <form class="center" action="registration" method="POST">
      <fieldset class="registration-form">
        <div class="control-group">
          <!-- Username -->
          <div class="controls">
            <input type="text" id="username" name="username" placeholder="Username" class="input-xlarge">
          </div>
        </div>

        <div class="control-group">
          <!-- E-mail -->
          <div class="controls">
            <input type="text" id="email" name="email" placeholder="E-mail" class="input-xlarge">
          </div>
        </div>

        <div class="control-group">
          <!-- Password-->
          <div class="controls">
            <input type="password" id="password" name="password" placeholder="Password" class="input-xlarge">
          </div>
        </div>
        
        <div class="control-group allergens">
          <!-- Allergens -->
          <div class="controls">
            <input type="text" style="float: left; width: 82%;" id="allergens" name="allergens" placeholder="Allergen 1" class="input-xlarge">
          </div>
          
          <div>
		     <img class="" id="add_allergens" style="cursor: pointer;" alt="Add more allergens" src="${pageContext.request.contextPath}/resources/images/add.png">
		   </div>
          
        </div>
        
<%-- 		<div class="form-group ingredients">
	 
		   <label for="ingredients" class="col-xs-12 col-md-2 col-lg-2 control-label label1">Ingredients</label>
		   <div class="col-xs-12 col-md-4 col-lg-4">
		     <input type="text" class="form-control input1" name="ingredients" id="ingredients" placeholder="Ingredient 1">
		   </div>

		   <div class="col-xs-12 col-md-2 col-lg-2">
		     <img class="img-responsive" id="add_ingredients" style="cursor: pointer;" alt="Add more ingredients" src="${pageContext.request.contextPath}/resources/images/add.png">
		   </div>
	   
		</div>  --%>

<!--         <div class="control-group">
          Password
          <div class="controls">
            <input type="password" id="password_confirm" name="password_confirm" placeholder="Password (Confirm)" class="input-xlarge">
          </div>
        </div> -->

        <div class="control-group">
          <!-- Button -->
          <div class="controls">
            <button type="submit" class="btn btn-success btn-large btn-block">Register</button>
          </div>
        </div>
      </fieldset>
    </form>
  </section>
  <!-- /#registration-page -->

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
	$($(".nav").find('li')[size-1]).addClass("active");
</script>

</body>
</html>
