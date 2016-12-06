<%-- 
    Document   : displayUserStaticPage
    Created on : Dec 5, 2016, 4:51:10 PM
    Author     : apprentice
--%>

<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Soupa-Stars | Home</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/searchForm.css"rel="stylesheet">
        
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/soup.jpg">
    </head>
        
    <body style ="background-color:buttonhighlight;">

        <div class="container">
            
          <jsp:include page="navbar.jsp" />
                    <h1>User Page</h1>

            
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>Date</th>
                                <th>Category</th
                                <th>&nbsp;</th>

                            </tr>
                        </thead>
                            
                    </table>
            <a class="btn btn-primary" href="editBlogPostForm' + post.postId + '">Edit <span class="glyphicon glyphicon"></span></a>
            <a class="btn btn-primary" href="editBlogPostForm' + post.postId + '">Delete <span class="glyphicon glyphicon"></span></a>
            <a class="btn btn-primary" href="editBlogPostForm' + post.postId + '">Create static Page<span class="glyphicon glyphicon"></span></a>
            
            
                    <tbody>
                        <c:forEach var="post" items="${SoupaStar}">
                            <s:url value="deleteBlogPostForm" var="deleteBlogPost_url">
                                <s:param name="postId" value="${post.postId}"/>   
                                
                            </s:url>
                            <s:url value="displayEditBlogPostForm" var="editBlogPost_url">
                                <s:param name="postId" value="${post.postId}"/>
                                
                            </s:url>
                            <tr>
                                <td>${post.title}</td>
                                <td>${post.localDate}</td>
                                <td${post.author}</td>
                                <td>${post.category}</td>
                                <td>
                                    <sec:authorize access="('ROLE_ADMIN', 'ROLE_VISITOR')">
                                        <a href="${deletePost_url}">Delete</a>
                                        <a href="${editPost_url}">Edit</a>
                                    </sec:authorize>
                                </td>
                                
                            </tr>
                        </c:forEach>
                            
                    </tbody>
                </table>
                </div>
            <hr>

              
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Soupa-Stars 2016</p>
                    </div>
                   
                </div>
                 
            </footer>

        </div>
        <script>
            var today = new Date;
            document.getElementById('date').innerHTML = today.toDateString();
        </script>

        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

        <script src="${pageContext.request.contextPath}/js/mainPage.js"></script>

    </body>
</html>
