<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a id="logo" class="pull-left" href="${pageContext.request.contextPath}/home"></a>
            <div class="nav-collapse collapse pull-right">
                <ul class="nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>

                    <% String username = (String)session.getAttribute("username"); %>
                    <% if(username != null){ %>
                         <li><a href="${pageContext.request.contextPath}/myMenu">My Menu</a></li>
                        <li><a href="${pageContext.request.contextPath}/myRecipes">My Recipes</a></li>
                    <% } %>

                    <li><a href="${pageContext.request.contextPath}/newRecipe">New Recipe</a></li>

                    <% Boolean isAdminUser = (Boolean)session.getAttribute("adminUser"); %>
                    <% if(isAdminUser != null && isAdminUser){ %>
                         <li><a href="statistics">Statistics</a></li>
                    <% } %>

                    <% username = (String)session.getAttribute("username"); %>
                    <% if(username == null){ %>

                        <li>
                            <a data-toggle="modal" href="#loginForm" id="toggleLoginForm">Login&nbsp;&nbsp;&nbsp;<i class="icon-lock"></i></a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/registration">Register&nbsp;&nbsp;&nbsp;<i class="icon-lock"></i></a>
                        </li>

                    <% }
                    else { %>
                        <li>
                            <a href="#" style=" pointer-events: none;">Welcome <%= username %>&nbsp;&nbsp;&nbsp;<i class="icon-lock"></i></a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/logout">Logout&nbsp;&nbsp;&nbsp;<i class="icon-lock"></i></a>
                        </li>
                    <% } %>
                </ul>
            </div>
        </div>
    </div>
</header>