/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    loadStaticPageList();

});

function loadStaticPageList() {
    $.ajax({
        url: 'staticPages',
        contentType: 'appliction/json',
        dataType: 'json'
    }).success(function (data, status) {
        fillStaticPageTable(data, status);
    });
}

function fillStaticPageTable(pageList, status) {
    var pageTable = $('#static-page-table');
    pageTable.empty();

    $.each(pageList, function (arrayPosition, page) {
        pageTable.append($('<tr><td><h4><a href="displayStaticPage' + page.pageId +
                '">' + page.title + '</a></h4></td>'
                + '<td>' + page.expirationDate + '</td>'
                + '<td><a class="btn btn-primary" href="#" >Edit Page</a></td>'
                + '<td><a class="btn btn-primary "href="deleteStaticPage' + page.pageId +'">Delete Page</a></td>'
                +'</tr>'));
    });
}