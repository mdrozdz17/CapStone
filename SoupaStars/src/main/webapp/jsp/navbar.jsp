<%-- 
    Document   : navbar
    Created on : Dec 6, 2016, 10:30:26 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class ="navbar-inverse">
            <ul class ="nav nav-tabs">
                <li role="presentation" >
                    <a href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li role="presentation">
                    <a href="${pageContext.request.contextPath}/displayBlogPostForm">Write a Post</a>
                </li>
                <li role="presentation">
                    <a href="${pageContext.request.contextPath}/userPage">User Page</a>
                </li>

                <div class="row">
                    <div class="col-md-4 col-md-offset-2">
                        <form action="search" class="search-form" method="post">
                            <div class="form-group has-feedback">
                                <label for="search" class="sr-only">Search</label>
                                <input type="text" class="form-control" name="searchTerm" id="searchTerm" placeholder="search">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </form>
                    </div>

                    <li role ="presentation">
                        <a href="${pageContext.request.contextPath}/login"><button type="submit" class="btn btn-success">Log In</button></a>
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout"><button type ="submit" class="btn btn-danger">Log Out</button></a>

                    <li>


                </div>  

            </ul> 

        </div>
    </body>
</html>