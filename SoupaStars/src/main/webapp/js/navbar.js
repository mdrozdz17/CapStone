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
    var currentDate = new Date();
    var thisDay = currentDate.getDate();
    var thisMonth = currentDate.getMonth() + 1;
    var thisYear = currentDate.getFullYear();
    
    $.each(pageList, function (arrayPosition, page) {
        try{
            var dateArray = page.expirationDate.split("/");
            var expDay = dateArray[1];
            var expMonth = dateArray[0];
            var expYear = dateArray[2];
            if((page.expirationDate === "N/A")
                    || expYear > thisYear
                    || (expYear === thisYear && expMonth > thisMonth)
                    || (expYear === thisYear && expMonth === thisMonth && expDay>thisDay)){
                navTabs.append($('<li role="presentation">' +
                '<a href="displayStaticPage' + page.pageId +
                '">' + page.title + '</a>' +
                '</li>'));
            }
        }
        catch(err){
            navTabs.append($('<li role="presentation">' +
                '<a href="displayStaticPage' + page.pageId +
                '">' + page.title + '</a>' +
                '</li>'));
        }
        
    });
}