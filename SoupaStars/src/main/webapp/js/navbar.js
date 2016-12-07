/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    loadTabs();

});

function loadTabs() {
    //Get our JSON objects from the controller
    $.ajax({
        url: 'staticPages',
        contentType: 'application/json',
        dataType: 'json'
    }).success(function (data, status) {
        fillTabs(data, status);
    });
}
function fillTabs(pageList, status) {
    var navTabs = $("#static-page-tabs");
    navTabs.empty();
    $.each(pageList, function (arrayPosition, page) {
        navTabs.append($('<li role="presentation">' +
                '<a href="displayStaticPage' + page.pageId +
                '">' + page.title + '</a>' +
                '</li>'));
    });
}