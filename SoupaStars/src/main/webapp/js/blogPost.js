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
    });
}

function fillPostTable(postList, status) {
    clearPostTable();
    var postTable = $('#postRows');

    $.each(postList, function (arrayPosition, post) {
        postTable.append($('<tr>')
                .append($('<td>')
                        .append($('<h2>' + post.title + '</h2>\n\
        <p><span class="glyphicon glyphicon-user"></span><a href="#"> ' + post.author +'</a>&nbsp;\n\
        <span class="glyphicon glyphicon-time"></span> Posted on ' + post.month +' ' + post.day + ', ' + post.year +'&nbsp;\n\
        <span class="glyphicon glyphicon-duplicate"></span><a href="#"> ' + post.category +' </a>&nbsp;\n\
        <span class="glyphicon glyphicon-comment"></span><a href="#"> # Comments </a>&nbsp;\n\
        <p>' + post.body + '</p>\n\
        <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a><hr>'))
                        ));

    });
}

function clearPostTable() {
    $('#postRows').empty();
}