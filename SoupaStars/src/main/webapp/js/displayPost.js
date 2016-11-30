/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    loadPost();    
});

function loadPost() {
    var url = window.location.pathname;
    var urlSplit = url.split("displayPost");
    var id = urlSplit[1];
    
    $.ajax({
        url: 'post/' +id
    }).success(function (data, status) {
        fillPostInfo(data, status);
    });
}

function fillPostInfo(post, status){
    //document.getElementById("postTitle").innerHTML
}

