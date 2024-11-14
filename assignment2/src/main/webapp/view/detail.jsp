<%@ include file="theme/navbar.jsp"%>
<div class="container mt-3">
    <div class="d-flex">
        <h3 style="flex:1">${video.title}</h3>
        <div>
            <c:if test="${not empty sessionScope.username}">
                <!-- User is logged in -->
                <c:choose>
                    <c:when test="${likedByUser}">
                        <!-- Video is liked by the user -->
                        <a class="btn btn-sm border-primary" href="unlike?id=${video.id}">Unlike</a>
                    </c:when>
                    <c:otherwise>
                        <!-- Video is not liked by the user -->
                        <a class="btn btn-sm border-primary" href="like?id=${video.id}">Like</a>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </div>
    </div>
    <iframe width="100%" height="600px" src="https://www.youtube.com/embed/${video.id}" allowfullscreen></iframe>
</div>
