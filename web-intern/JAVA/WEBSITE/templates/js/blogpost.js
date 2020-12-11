var stompClient = null;
$(document).ready(function(){
    getListBlogPostUser(1);
    updateSize();
    if(stompClient!==null)
        stompClient.disconnect();
    var socket = new SockJS('/comment_blog');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        stompClient.subscribe('/topic/comments', function (response) {
            var userName = $("#usernameID").html();
            var obj = JSON.parse(response.body);
            $('#binhluan'+obj.blog_id).append(
                "<div class='row comment' width='100%' style='margin: 15px !important'>"+
                    "<div class='other-cmt col-sm-1' style='border-radius: 50%; width:30px; height:30px;'>"+
                        "<img class='othersUserImg' style='border-radius: 50%;' width='30px' height='30px' src='"+obj.path_img+"'>"+
                    "</div>"+
                    "<div class='cmt col-sm-11'>"+
                        "<div class='md-form'>"+
                            "<small for='user10'>"+userName+"</small>"+
                            "<p id='user10'>"+obj.comment_content+"</p>"+
                        "</div>"+
                    "</div>"+
                "</div>"
            );
        });
    });
    getListBlogPost(1);
});
function xemthem(page){
    $("#xemthem").children().remove();
    getListBlogPost(page);
    $("#xemthem").append(
        "<button class='btn btn-primary mx-auto' onclick='xemthem("+(page+1)+")'>Xem thêm</button>"
    );
}
function updateSize() {
    var input = document.getElementById('inputGroupFile01');

    input.addEventListener( 'change', showFileName );

    function showFileName( event ) { 
      var input = event.srcElement;
      var fileName = null;
      if(fileName == undefined){
          fileName = input.files[0].name;
      }
      $("#fileName").html(fileName);
    }
}
function uploadFileAjax(){
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url : "/upload_img",
        processData: false,
        contentType: false,
        data : new FormData($("#fileUploadForm").get(0)),
        cache: false,
        timeout: 600000,
        success: function (result) {
            console.log(result);
        },
        error : function(){
            console.log("error");
        }
    });
}
function uploadBlogPost(){
    var td = new Date();
    var content = $("#form21").val();
    var fileName = $("#fileName").html();
    var date = td.getDate();
    if(content == ""){
        popupFail("Vui lòng nhập vào dữ liệu để có thể tiếp tục ~~ Meow Meow");
    }
    else{
        if(fileName == ""){
            
        }
        else{
            uploadFileAjax();
        }
        var datas = {
            "content" : content,
            "fileImage" : fileName
        };
        $.ajax({
            url : "/post_blog",
            data : datas,
            success : function(result){
                window.location = "/";
                $(document).click(clickActiveUnbox('news-feed'));
            },
            error : function(){
                console.log("error");
            }
        }).always(function(){
            clickActiveUnbox('news-feed');
        });
    }
}
function getListBlogPost(page){
    var datas = {
        "page" : page
    };
    var path_img_avatar = $(".avatarprofile").attr("src");
    $.ajax({
       url : "/getListBlog",
       data : datas,
       success : function(result){
           var lst = result.listPost;
           var nameuser = result.user.username;
           if(result.user.username == null){
               nameuser = result.user.last_name;
           }
           for(let i=0; i<lst.length;i++){
            var obj = lst[i];
            var arr = obj.avatar_user.split("/");
            var path_ig = "";
            if(arr.length > 1)
                path_ig = obj.avatar_user;
            else 
                path_ig = result.path_img+obj.avatar_user;
            $("#local-newsfeed").append(
             "<div class='card' style='width: 100%;margin-top: 30px;'>"+
                     "<div class='card-title'>"+
                         "<ul class='title-news-feed row' style='margin-left:0px; margin-right:0px;'>"+
                             "<li class='avartar-user'>"+
                                 "<a href='/profile?id="+obj.post_by+"'>"+
                                     "<img src='"+path_ig+"' alt=''>"+
                                 "</a>"+
                             "</li>"+
                             "<li style='width:200px; margin-top:18px; padding-left: 15px;'>"+
                                "<span style='font-size:12px'>"+obj.username+"</span>"+
                             "</li>"+
                         "</ul>"+
                     "</div>"+
                        "<div class='card-body'>"+
                            "<p class='card-text'>"+obj.description+"</p>"+
                            "<hr>"+
                        "</div>"+
                        "<div class='view overlay'>"+
                            "<img class='card-img-top' src='"+result.path_img+obj.img+"' alt='img/img(67).png'>"+
                            "<a href='#'>"+
                                "<div class='mask rgba-white-slight'></div>"+
                            "</a>"+
                        "</div>"+
                        "<div class='rounded-bottom mdb-color lighten-3 text-center pt-3'>"+
                             "<ul class='list-unstyled list-inline font-small'>"+
                                 "<li class='list-inline-item pr-2 white-text'><i class='far fa-clock pr-1'></i>"+formatDate(obj.create_date)+"</li>"+
                                 "<li class='list-inline-item pr-2'><a data-toggle='collapse' aria-expanded='false' aria-controls='binhluan"+obj.id+"' class='white-text' onclick='getCollapse("+obj.id+","+result.user.id_user+")'><i class='far fa-comments pr-1'></i></a></li>"+
                                 "<li class='list-inline-item pr-2'><a href='#' class='white-text'><div class='fb-share-button' data-href='https://developers.facebook.com/docs/plugins/' data-layout='button' data-size='small'><a style='color:white;' target='_blank' href='https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp;src=sdkpreparse' class='fb-xfbml-parse-ignore'><i class='fab fa-facebook-f pr-1'> </i></a></div></a></li>"+
                             "</ul>"+
                         "</div>"+
                         "<div class='collapse' id='binhluan"+obj.id+"'>"+
                             "<div class='row comment' width='100%' style='margin: 15px !important'>"+
                                 "<div class='other-cmt col-sm-1' style='border-radius: 50%; width:30px; height:30px;'>"+
                                     "<img class='othersUserImg' style='border-radius:50%' width='30px' height='30px' src='"+path_img_avatar+"'>"+
                                 "</div>"+
                                 "<div class='cmt col-sm-11'>"+
                                     "<div class='md-form'>"+
                                         "<ul class='text-comment'>"+
                                            "<li style='width:90%; float:left;'>"+
                                                 "<input type='text' id='form"+obj.id+"' class='form-control'>"+
                                                 "<label for='form"+obj.id+"'>Me</label>"+
                                             "</li>"+
                                             "<li style='width:10%; float:left; margin-top:10px;'>"+
                                                 "<a href='#' onclick='comment("+obj.id+","+obj.id+","+result.user.id_user+")'>"+
                                                     "<i class='fas fa-angle-right fa-2x'></i>"+
                                                 "</a>"+
                                             "</li>"+
                                         "</ul>"+
                                     "</div>"+
                                 "</div>"+
                             "</div>"+
                         "</div>"+
                 "</div>"
            );
        }
       },
       error : function(){
           console.log("Error");
       }
    });
}
function getListBlogPostUser(page){
    var datas = {
        "page" : page
    };
    var hre = window.location.href +"";
    var arr = hre.split("?");
    if(arr.length > 1){
        var id = arr[1].split("=");
        datas = {
            "page" : page,
            "id" : id[1]
        };
    }
    var path_img_avatar = $(".avatarprofile").attr("src");
    $.ajax({
       url : "/getListBlogUser",
       data : datas,
       success : function(result){
           var lst = result.listPost;
           for(let i=0; i<lst.length;i++){
            var obj = lst[i];
            var path_ig = "";
            if(obj.avatar_user != null){
                var arr = obj.avatar_user.split("/");
                if(arr.length > 1)
                    path_ig = obj.avatar_user;
                else 
                    path_ig = result.path_img+obj.avatar_user;
            }else{
                path_ig = obj.avatar_user;
            }
            $("#local-newsfeed2").append(
             "<div class='card' style='width: 100%;margin-top: 30px;'>"+
                     "<div class='card-title'>"+
                         "<ul class='title-news-feed row' style='margin-left:0px; margin-right:0px;'>"+
                             "<li class='avartar-user'>"+
                                 "<a href='/profile?id="+obj.post_by+"'>"+
                                     "<img src='"+path_ig+"' alt=''>"+
                                 "</a>"+
                             "</li>"+
                             "<li style='width:200px; margin-top:18px; padding-left: 15px;'>"+
                                "<span style='font-size:12px'>"+obj.username+"</span>"+
                             "</li>"+
                         "</ul>"+
                     "</div>"+
                        "<div class='card-body'>"+
                            "<p class='card-text'>"+obj.description+"</p>"+
                            "<hr>"+
                        "</div>"+
                        "<div class='view overlay'>"+
                            "<img class='card-img-top' src='"+result.path_img+obj.img+"' alt='img/img(67).png'>"+
                            "<a href='#'>"+
                                "<div class='mask rgba-white-slight'></div>"+
                            "</a>"+
                        "</div>"+
                        "<div class='rounded-bottom mdb-color lighten-3 text-center pt-3'>"+
                             "<ul class='list-unstyled list-inline font-small'>"+
                                 "<li class='list-inline-item pr-2 white-text'><i class='far fa-clock pr-1'></i>"+formatDate(obj.create_date)+"</li>"+
                                 "<li class='list-inline-item pr-2'><a data-toggle='collapse' aria-expanded='false' aria-controls='binhluan"+obj.id+"' class='white-text' onclick='getCollapse("+obj.id+","+result.user.id_user+")'><i class='far fa-comments pr-1'></i></a></li>"+
                                 "<li class='list-inline-item pr-2'><a href='#' class='white-text'><div class='fb-share-button' data-href='https://developers.facebook.com/docs/plugins/' data-layout='button' data-size='small'><a style='color:white;' target='_blank' href='https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp;src=sdkpreparse' class='fb-xfbml-parse-ignore'><i class='fab fa-facebook-f pr-1'> </i></a></div></a></li>"+
                             "</ul>"+
                         "</div>"+
                         "<div class='collapse' id='binhluan"+obj.id+"'>"+
                             "<div class='row comment' width='100%' style='margin: 15px !important'>"+
                                 "<div class='other-cmt col-sm-1' style='border-radius: 50%; width:30px; height:30px;'>"+
                                     "<img class='othersUserImg' style='border-radius:50%' width='30px' height='30px' src='"+path_img_avatar+"'>"+
                                 "</div>"+
                                 "<div class='cmt col-sm-11'>"+
                                     "<div class='md-form'>"+
                                         "<ul class='text-comment'>"+
                                            "<li style='width:90%; float:left;'>"+
                                                 "<input type='text' id='form"+obj.id+"' class='form-control'>"+
                                                 "<label for='form"+obj.id+"'>Me</label>"+
                                             "</li>"+
                                             "<li style='width:10%; float:left; margin-top:10px;'>"+
                                                 "<a href='#' onclick='comment("+obj.id+","+obj.id+","+result.user.id_user+")'>"+
                                                     "<i class='fas fa-angle-right fa-2x'></i>"+
                                                 "</a>"+
                                             "</li>"+
                                         "</ul>"+
                                     "</div>"+
                                 "</div>"+
                             "</div>"+
                         "</div>"+
                 "</div>"
            );
        }
       },
       error : function(){
           console.log("Error");
       }
    });
}
$(document).keypress(function(event){ 
    var keyCode = (event.keyCode ? event.keyCode : event.which);   
    if (keyCode == 13) {
        $('.commentsKey').trigger('click');
    }
});
function comment(id, idPost, user_id){
    sendSockett(id, user_id, idPost);
    $("#form"+id).val("");
}
function getListComment(id, page){
    var datas = {
        "page" : page,
        "idPost" : id
    };
    $.ajax({
        url : "/getListComment",
        data : datas,
        success : function(result){
            var lst = result.listComment;
            for(let i=0; i<lst.length;i++){
                var obj = lst[i];
                var arr= obj.avatar_img.split("/");
                var path_img = "";
                if(arr.length > 1){
                    path_img = obj.avatar_img;
                }else{
                    path_img = result.path_img+obj.avatar_img;
                }
                $("#binhluan"+id).append(
                    "<div class='row comment' width='100%' style='margin: 15px !important'>"+
                        "<div class='other-cmt col-sm-1' style='border-radius: 50%; width:30px; height:30px;'>"+
                            "<img class='othersUserImg' style='border-radius: 50%;' width='30px' height='30px' src='"+path_img+"'>"+
                        "</div>"+
                        "<div class='cmt col-sm-11'>"+
                            "<div class='md-form'>"+
                                "<small for='user10'>"+obj.user_name+"</small>"+
                                "<p id='user10'>"+obj.comment_content+"</p>"+
                            "</div>"+
                        "</div>"+
                    "</div>"
                );
            }
        },
        error : function(){
            console.log("Error");
        }
    });
}
function clickActiveUnbox(id){
    if(id == "news-feed"){
        $("#news-feed").removeClass("info-class-false");
        $("#news-feed").addClass("info-class-true");
        $("#unboxing").removeClass("info-class-true");
        $("#unboxing").addClass("info-class-false");
        $("#product").removeClass("info-class-true");
        $("#product").addClass("info-class-false");
        $("#community").removeClass("hide-none");
        $("#unbox").addClass("hide-none");
        $("#sharedtip").addClass("hide-none");
    }
    if(id == "unboxing"){
        $("#news-feed").removeClass("info-class-true");
        $("#news-feed").addClass("info-class-false");
        $("#unboxing").removeClass("info-class-false");
        $("#unboxing").addClass("info-class-true");
        $("#product").removeClass("info-class-true");
        $("#product").addClass("info-class-false");
        $("#community").addClass("hide-none");
        $("#unbox").removeClass("hide-none");
        $("#sharedtip").addClass("hide-none");
    }
    if(id == "product"){
        $("#news-feed").removeClass("info-class-true");
        $("#news-feed").addClass("info-class-false");
        $("#unboxing").removeClass("info-class-true");
        $("#unboxing").addClass("info-class-false");
        $("#product").removeClass("info-class-false");
        $("#product").addClass("info-class-true");
        $("#community").addClass("hide-none");
        $("#unbox").addClass("hide-none");
        $("#sharedtip").removeClass("hide-none");
    }
}
function popupFail(text){
    Swal.fire({
        title: text,
        width: 600,
        padding: '3em',
        background: '#fff url(img/trees.png)',
        backdrop: `
          rgba(0,0,123,0.4)
          url("img/nyan-cat.gif")
          center left
          no-repeat
        `
    });
}
function receiveSocket(id){
    this.stompClient.connect({}, function () {
        this.stompClient.subscribe('/topic/comments', function (response) {
            var obj = JSON.parse(response.body);
            console.log(obj);
            $("#binhluan"+id).append(
                "<div class='row comment' width='100%' style='margin: 15px !important'>"+
                    "<div class='other-cmt col-sm-1' style='border-radius: 50%; width:30px; height:30px;'>"+
                        "<img class='othersUserImg' width='30px' height='30px' src='"+obj.path_img+"'>"+
                    "</div>"+
                    "<div class='cmt col-sm-11'>"+
                        "<div class='md-form'>"+
                            "<small for='user10'>"+obj.user_name+"</small>"+
                            "<p id='user10'>"+obj.comment_content+"</p>"+
                        "</div>"+
                    "</div>"+
                "</div>"
            );
        });
    });
}
function sendSockett( id, user_id, idBlogPost){
    var create_date =  new Date();
    var comment_content = $("#form"+id).val();
    var user_name = $("#usernameID").html();
    console.log(user_name);
    var description = {
        'comment_content': comment_content,
        'create_date' : create_date,
        'user_id' : user_id,
        'blog_id' : parseInt(idBlogPost),
        'user_name' : user_name
    };
    this.stompClient.send("/app/receive-comments",{},JSON.stringify(description));
}
function formatDate(date){
    var tday = new Date(date);
    var dd = tday.getDate();
    var mm = tday.getMonth()+1;
    var yyyy = tday.getFullYear();
    if (dd < 10) { 
            dd = '0' + dd; 
        } 
        if (mm < 10) { 
            mm = '0' + mm; 
        } 
    var today = dd + '/' + mm + '/' + yyyy;
    return today;
}
function getCollapse(id, id_user){
    var path_img = $(".avatarprofile").attr("src");
    $('#binhluan'+id).collapse();
    $('#binhluan'+id).children().remove();
    $('#binhluan'+id).append(
        "<div class='row comment' width='100%' style='margin: 15px !important'>"+
            "<div class='other-cmt col-sm-1' style='border-radius: 50%; width:30px; height:30px;'>"+
                "<img class='othersUserImg' style='border-radius:50%' width='30px' height='30px' src='"+path_img+"'>"+
            "</div>"+
            "<div class='cmt col-sm-11'>"+
                "<div class='md-form'>"+
                    "<ul class='text-comment'>"+
                       "<li style='width:90%; float:left;'>"+
                            "<input type='text' id='form"+id+"' class='form-control'>"+
                            "<label for='form1'>Me</label>"+
                        "</li>"+
                        "<li style='width:10%; float:left; margin-top:10px;'>"+
                            "<a href='#binhluan"+id+"' class='commentsKey' onclick='comment("+id+","+id+","+id_user+")'>"+
                                "<i class='fas fa-angle-right fa-2x'></i>"+
                            "</a>"+
                        "</li>"+
                    "</ul>"+
                "</div>"+
            "</div>"+
        "</div>"
    );
    getListComment(id, 1);
}