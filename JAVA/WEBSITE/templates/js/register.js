function register(){
    var username = $("#username").val();
    var password = $("#password").val();
    var repeatpassword = $("#repeatpassword").val();
    if(password === "" || repeatpassword === ""){
        popupFail("Điền mật khẩu đi! Meow meow");
    }else{
        if(!password.includes(repeatpassword)){
            popupFail("Meow meow ~~~ Mật khẩu bạn nhập lại sai rồi. Bạn nhập lại nhé!");
        }
        else{
            var datas = {
                "username" : username,
                "password" : password,
                "repeatpassword" : repeatpassword
            };
            $.ajax({
                url : "/register_nm",
                data:datas,
                success: function (result) {
                    var popup = result.popup;
                    if(popup === 0){
                        popupSuccess("Đăng kí thành công rồi! Meow~~");
                    }
                    if(popup === 1){
                        popupFail("Meow Meow ~~~ Hình như bạn đăng kí rồi?");
                    }
                    if(popup === 2){
                        popupFail("Meow Meow ~~ Hai mật khẩu khác rồi, thử lại nhe!");
                    }
                }
            });
        }
    }
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