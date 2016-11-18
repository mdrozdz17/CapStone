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
                        .append($('<h2>Testing</h2>'))
                        ));

    });
}

function clearPostTable() {
    $('#postRows').empty();
}