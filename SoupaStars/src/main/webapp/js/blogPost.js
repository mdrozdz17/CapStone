/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    loadPosts();
});
function loadPosts() {
    //Get our JSON objects from the controller
    $.ajax({
        url: 'post'
    }).success(function (data, status) {
        fillPostTable(data, status);
        fillAuthorTable(data, status);
        fillCategoryTable(data, status);
        fillTagTable(data, status);
    });
}

function fillPostTable(postList, status) {
    clearPostTable();
    var postTable = $('#postRows');
    $.each(postList, function (arrayPosition, post) {
        postTable.append($('<tr>')
                .append($('<td>')
                        .append($('<h2>' + post.title + '</h2>\n\
        <p><span class="glyphicon glyphicon-user"></span><a href="#"> ' + post.author + '</a>&nbsp;\n\
        <span class="glyphicon glyphicon-time"></span> Posted on ' + post.month + ' ' + post.day + ', ' + post.year + '&nbsp;\n\
        <span class="glyphicon glyphicon-duplicate"></span><a href="#"> ' + post.category + ' </a>&nbsp;\n\
        <span class="glyphicon glyphicon-comment"></span><a href="#"> # Comments </a>&nbsp;\n\
        <p>' + post.body + '</p>'

                                ))));
        var tags = "";
        for (var i = 0; i < post.tagList.length; i++) {
            tags = tags + "#" + post.tagList[i] + " ";
        }
        postTable.append($('<p>' + tags + '</p><a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>'));
    });
}
function fillAuthorTable(postList, status) {
    var authorTable = $('#authorRows');
    authorTable.empty();
    var authorList = [];
    $.each(postList, function (arrayPosition, post) {
        if(!contains(authorList, post.author)){
            authorTable.append($('<tr><td><a href="#">' + post.author + '</a></td></tr>'));
            authorList.push(post.author);
        }
    }
    );
}
function contains(a, obj){
    for (var i=0; i < a.length; i++){
        if(a[i] === obj) {
            return true;
        }
    }
    return false;
}

function fillCategoryTable(postList, status) {
    var categoryTable = $('#categoryRows');
    categoryTable.empty();
    $.each(postList, function (arrayPosition, post) {
        categoryTable.append($('<tr><td><a href="#">' + post.category + '</a></td></tr>'));
    });
}

function fillTagTable(postList, status) {
    var tagTable = $('#tagRows');
    tagTable.empty();
    $.each(postList, function (arrayPosition, post) {

        for (var i = 0; i < post.tagList.length; i++) {
            tagTable.append($('<a href="#">#' + post.tagList[i] + ' </a></'));
        }
    });
}
function clearPostTable() {
    $('#postRows').empty();
}
