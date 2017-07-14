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

        <h1 class="center">${recipe.title}</h1>

        <hr>

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
</script>

</body>
</html>
