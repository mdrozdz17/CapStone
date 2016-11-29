<%-- 
    Document   : disclaimer
    Created on : Nov 15, 2016, 1:48:00 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Soupa-Stars | Static-Pages</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/searchForm.css"rel="stylesheet">
        <!-- SOUPA-STARS ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/soup.jpg">
    </head>
    <body style ="background-color:powderblue;">
        <div class="container">
            <div class ="navbar-inverse">
                <ul class ="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <div class="row">
                        <div class="col-md-4 col-md-offset-6">
                            <form action="" class="search-form">
                                <div class="form-group has-feedback">
                                    <label for="search" class="sr-only">Search</label>
                                    <input type="text" class="form-control" name="search" id="search" placeholder="search">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </form>
                        </div>
                    </div>
                </ul>   
            </div>
                                    <h3>Add New Static Page</h3>
                <sf:form>
                    <table width="100%">
                        <tr>
                            <td>Page Name:  </td><td><input class="form-control" type="text" path="title" id="titleCreate" placeholder="Title" /><div id="add-title-validation-errors"></div><br/></td>
                        </tr>
                        <tr>
                            <td valign="top">Page Content: </td><td><textarea class="form-control" path="pageContent" id="pageContentCreate" name="pageContent" cols="50" rows="15" ></textarea><div id="add-pageContent-validation-errors"></div><br/></td>
                        </tr>
                        <tr>
                            <td>Please choose category/categories</td>
                            <td><select class="form-control selectpicker" multiple id="categorySelect">
                                    <c:forEach items="${allCategories}" var="category">
                                        <option value="${category.id}">${category.categoryName}</option>
                                    </c:forEach>
                                </select></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <div class="col-sm-7"><input type="text" class="form-control" id="newCategory" placeholder="New Category"></input></div>
                                <div class="col-sm-2"><button class="btn btn-default" id="addCategoryButton">Add</button></div>
                                <div class="col-sm-3"><button class="btn" id="deleteCategoryModalButton" data-toggle="modal" data-target="#deleteCategoryModal">Delete Selected</button></div>
                            </td>
                        </tr>
                        <tr>
                            <td>Please choose post date: </td><td><input class="form-control" type="date" path="startDate" id="startDateCreate" placeholder="mm-dd-yyyy" /><div id="add-startDate-validation-errors"></div><br/></td>
                        </tr>
                        <tr>
                            <td>Please choose expiry date (optional): </td><td><input class="form-control" type="date" path="endDate" id="endDateCreate" placeholder="mm-dd-yyyy" /><div id="add-endDate-validation-errors"></div><br/></td>
                        </tr>
                        <tr>
                            <td><input id="addPageButton" type="button" value="Save" /></td><td align="right"><input id="cancelPageButton" type="button" value="Cancel" /></td>
                        </tr>
                    </table>
                </sf:form>
                </br>
                </br>
                <div class="modal fade" id="deleteCategoryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel2">Delete Categories</h4>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" id="deleteBlogId"/>
                                <p>Are you sure you want to delete the currently selected category/categories? This will remove them from all currently associated blogs.</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal" id="deleteCategoryButton">Delete Categories</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
