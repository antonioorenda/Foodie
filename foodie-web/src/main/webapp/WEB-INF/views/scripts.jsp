<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/vendor/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<!-- Required javascript files for Slider -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.ba-cond.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.slitslider.js"></script>
<!-- /Required javascript files for Slider -->

<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>

<!-- SL Slider -->
<script type="text/javascript"> 
$(function() {
    var Page = (function() {

        var $navArrows = $( '#nav-arrows' ),
        slitslider = $( '#slider' ).slitslider( {
            autoplay : true
        } ),

        init = function() {
            initEvents();
        },
        initEvents = function() {
            $navArrows.children( ':last' ).on( 'click', function() {
                slitslider.next();
                return false;
            });

            $navArrows.children( ':first' ).on( 'click', function() {
                slitslider.previous();
                return false;
            });
        };

        return { init : init };

    })();

    Page.init();
});
</script>
<!-- /SL Slider -->

<c:if test="${loginError}">
    <script type="text/javascript">
        $(document).ready(function(){ $("#toggleLoginForm").click(); })
    </script>
</c:if>