/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//$(function () {
//
//    $("#searchTerm").autocomplete({
//        source: function (request, response) {
//            $.ajax({
//                url: "SearchController/search/" + $("#searchTerm").val(),
//                type: "POST",
//                dataType: "json",
//                success: function (data) {
//                    if (typeof Array.prototype.forEach !== 'function') {
//                        Array.prototype.forEach = function (callback) {
//                            for (var i = 0; i < this.length; i++) {
//                                callback.apply(this, [this[i], i, this]);
//
//                            }
//                        };
//
//                    }
//
//                    var values = data;
//                    var newArray = new Array(values.length);
//                    var i = 0;
//                    values.forEach(function (entry) {
//                        var newObject = {
//                            label: entry.title
//                        };
//                    newArray[i] = newObject;
//                        i++;
//                    });
//                    response(newArray);
//                    
//                }
//                
//            });
//            
//        },
//        minLength: 0
//    });
//
//});

$(function () {

    $("#searchTerm").autocomplete({
        source: function (request, response) {
            $.ajax({
                url: "SearchController/search/" + $("#searchTerm").val(),
                type: "POST",
                dataType: "json",
                success: function (data) {
                    if (typeof Array.prototype.forEach !== 'function') {
                        Array.prototype.forEach = function (callback) {
                            for (var i = 0; i < this.length; i++) {
                                callback.apply(this, [this[i], i, this]);

                            }
                        };

                    }

                    var values = data;
                    var newArray = new Array(values.length);
                    var i = 0;
                    values.forEach(function (entry) {
                        var newObject = {
                            label: entry.title
                        };
                    newArray[i] = newObject;
                        i++;
                    });
                    response(newArray);
                    
                }
                
            });
            
        },
        minLength: 0
    });

});

//function loadPosts() {
//    //Get our JSON objects from the controller
//    ({
//        url: "SearchController/searchPost/" + $("#searchTerm").val(),
//        contentType: 'application/json',
//        dataType: 'json'
//    }).success(function (data, status) {
//        fillPostTable(data, status);
//        fillAuthorTable(data, status);
//        fillCategoryTable(data, status);
//        fillTagTable(data, status);
//    });
//}
//
//function fillPostTable(postList, status) {
//    clearPostTable();
//    var postTable = $('#postRows');
//    var sortedPosts = postList.sort(function (a, b) {
//        return b.postId - a.postId;
//    });
//    $.each(sortedPosts, function (arrayPosition, post) {
//        postTable.append($('<tr>')
//                .append($(' <td> ')
//                        .append($('<h2>' + post.title + '</h2>\n\
//        <p><span class="glyphicon glyphicon-user"></span><a href="#"> ' + post.author + '</a>&nbsp;\n\
//        <span class="glyphicon glyphicon-time"></span> Posted on ' + post.month + ' ' + post.day + ', ' + post.year + '&nbsp;\n\
//        <span class="glyphicon glyphicon-duplicate"></span><a href="#"> ' + post.category + ' </a>&nbsp;\n\
//        <span class="glyphicon glyphicon-comment"></span><a href="#"> ' + post.commentList.length + " Comments</a>"
//                                + '<p>' + post.body + '</p>'
//                                ))));
//
//        var tags = "";
//        for (var i = 0; i < post.tagList.length; i++) {
//            tags = tags + "#" + post.tagList[i] + " ";
//
//        }
//
//
//        postTable.append($('<p>' + tags + '</p><a class="btn btn-primary" href="displayPost' + post.postId + '">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>'));
//        postTable.append($('<span>&nbsp</span><a class="btn btn-primary" href="editBlogPostForm' + post.postId + '">Edit <span class="glyphicon glyphicon"></span></a>'));
//        postTable.append($('<span>&nbsp</span><a class="btn btn-primary" href="deleteBlogPost' + post.postId + '">Delete <span class="glyphicon glyphicon"></span></a>'));
//
//    });
//}
//function fillAuthorTable(postList, status) {
//    var authorTable = $('#authorRows');
//    authorTable.empty();
//    var authorList = [];
//    var authorString = "";
//    $.each(postList, function (arrayPosition, post) {
//        authorString += post.author;
//    });
//    $.each(postList, function (arrayPosition, post) {
//        if (!contains(authorList, post.author)) {
//            authorTable.append($('<tr><td><a href="#">' + post.author +
//                    ' (' + countInstances(authorString, post.author) + ')</a></td></tr>'));
//            authorList.push(post.author);
//        }
//    }
//    );
//}
//function contains(a, obj) {
//    for (var i = 0; i < a.length; i++) {
//        if (a[i] === obj) {
//            return true;
//        }
//    }
//    return false;
//}
//
//function countInstances(string, word) {
//    var substrings = string.split(word);
//    return substrings.length - 1;
//}
//
//function fillCategoryTable(postList, status) {
//    var categoryTable = $('#categoryRows');
//    categoryTable.empty();
//    var categoryList = [];
//    var categoryString = "";
//    $.each(postList, function (arrayPosition, post) {
//
//        categoryString = categoryString + post.category;
//
//        categoryString += post.category;
//
//    });
//    $.each(postList, function (arrayPosition, post) {
//        if (!contains(categoryList, post.category)) {
//            categoryTable.append($('<tr><td><a href="#">' + post.category + ' ('
//                    + countInstances(categoryString, post.category) + ')</a></td></tr>'));
//            categoryList.push(post.category);
//        }
//    });
//}
//
//function fillTagTable(postList, status) {
//    var tagTable = $('#tagRows');
//    tagTable.empty();
//    var tagList = [];
//    $.each(postList, function (arrayPosition, post) {
//        for (var i = 0; i < post.tagList.length; i++) {
//            if (!contains(tagList, post.tagList[i])) {
//                tagTable.append($('<a href="#">#' + post.tagList[i] + ' </a></'));
//                tagList.push(post.tagList[i]);
//            }
//        }
//    });
//}

        
    