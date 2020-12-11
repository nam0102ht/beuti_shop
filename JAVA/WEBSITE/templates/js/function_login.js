function loginNormal(){
    var username = $("#username_lg").val();
    var password = $("#password_lg").val();
    if(username === "" || password === ""){
        popupFail("Không được để trống nè bạn ơi !");
    }
    else if(password.length < 6){
        popupFail("Mật khẩu phải lớn hơn 6 ký tự nhé !");
    }
    else{
        var datas = {
        "username" : username,
        "password" : password
        };
    }
    $.ajax({
        url : '/login_nm',
        data : datas,
        success: function (result) {
            if(result.popup === 0){
                popupTimer("Đăng nhập thành công rồi! Meow Meow",result.root_url);
            }
            else if(result.popup === 1){
                popupFail("Username password có thể sai? Nhập lại nhe ~~ Meow Meow");
            }
        },
        error : function (){
            console.log("Error");
        }
    });
}
function loginFB(){
    FB.login(function(response) {
        if (response.authResponse) {
            var accessToken = response.authResponse.accessToken;
            FB.api('/me?fields=id,name,email,picture', function(response) {
                var email = "";
                var avatar = "";
                if(response.email)
                    email = response.email;
                avatar = "https://graph.facebook.com/"+response.id+"/picture?type=square"
                var datas = {
                    "open_id": accessToken,
                    "open_name": response.name,
                    "open_avatar": avatar,
                    "open_email": email,
                    "user_id": response.id
                };
                $.ajax({
                url: "/login_fb",
                data: datas,
                    success: function(result) {
                        if(result.popup===0)
                            popupTimer("Đăng nhập thành công rồi! Meow Meow", result.root_url);
                        else{
                            popupTimer("Đăng nhập thành công rồi! Meow Meow", result.root_url);
                        }
                            
                    },
                    error: function() {
                        console.log("error");
                    }
                });
            });
        }
    }, {scope: 'public_profile,email'});      
}
function popupSuccess(text){
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
function popupSuccess(text){
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
function popupTimer(text, page){
    setTimeout(function(){
        Swal.fire({
            text: text,
            type: 'success',
            padding: 3+'em',
            width: 600,
            showCancelButton: false,
            showConfirmButton: false,
            showCloseButton: true,
            backdrop: `
              rgba(0,0,123,0.4)
              url("img/nyan-cat.gif")
              center left
              no-repeat
            `,
            timer: 2000
        }).then(function () {
            location.href = "http://"+page;
        });
    }, 100);
}
function popUpLogin(){
    popupFail("Vui lòng đăng nhập để tiếp tục");
}