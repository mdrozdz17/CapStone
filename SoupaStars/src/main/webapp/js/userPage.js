/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//$(function (){
//    loadPosts();
//    
//});
//
//$('#add-button').click(function (event){
//    event.preventDefault();
//    
//    $.ajax({
//        type: 'POST',
//        url: 'post',
//       data: JSON.stringify({
//           title: $('#add-title').val(),
//           date: $('#add-date').val(),
//           category: $('#add-category').val()
//       }),
//       contentType: 'application/json; charset=utf-8',
//       headers: {
//           'Accept': 'applicaiton/json',
//           'Content- Type': 'application/json'
//       },
//       dataType: 'json'
//    }).success(function (){
//        $('#add-title').val('');
//        $('#add-date').val('');
//        $('#add-category').val('');
//        
//        $('#validaitonErrors').empty();
//        loadPosts();
//       }).error(function (data, status){
//           $('#validationErrors').empty();
//           $.each(data.responseJSON.fieldErrors, function (index, validationError){
//               var errorDiv = $('#validationErrors');
//               errorDiv.append(validationError.message.append($('<br>'));
//           });
//       });
//      
//});
//
//$('#edit-button').click(function (event)){
//    event.preventDefault();
//    
//    $.ajax({
//        typ: 'PUT',
//        url: 'post'+ $('#edit-post-id').val(),
//        data: JSON.stringify({
//            postd: $('#edit-post-id').val(),
//            title: $('#edit-title').val(),
//            date: $('#edit- date').val(),
//            category: $('#edit- category').val()
//            
//        }),
//        headers:{
//            'Accept': 'appliction/json',
//            'Content- Type': 'application/json'
//        },
//        'dataType': 'json'
//    }).success(function () {
//        loadPosts();
//    });
//
//function loadPosts(){
//    $.ajax({
//        url: 'post',
//        contentType: 'appliction/json',
//        dataType: 'json'
//    }).success(function (data, status){
//        fillPostTable(data, status);
//        fillTitleTable(data, status);
//        fillDateTable(data, status);
//        fillCategoryTable(data,staus);
//    });
//}
//
//function fillPostTable(postList, status){
//    clearPostTable();
//    var postTable = $('#postRows');
//    var sortedPosts = postList.sort(funtion (a, b){
//        return b.postId - a.post.Id;
//    });
//    $.each(sortedPosts, function(arrayPosition, post){
//        postTable.append($('<tr>')
//                .append($('<h2>' + post.title + '</h2>\n\
//                <p><span class="glyphicon glyphicon-date"></span>Posted on ' + post.month + '' + post.day + ',' + post.year + '&nbsp;\n\
//                <span class="glyphicon glyphicon-duplicate"></span><a href="#"> ' + post.category + ' </a>&nbsp;\n\
//               ) ));
//                
//                
//    });
