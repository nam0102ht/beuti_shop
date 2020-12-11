$(document).ready(function(){
    $.fn.datepicker.defaults.format = "dd/mm/yyyy";
    $("#datepicker").datepicker({
        startDate: '1/1/1980'
    });
});
function updateAccount(){
    var name = $("#FirstName").val();
    var ho = $("#LastName").val();
    var email = $("#email").val();
    var dateofbirth = $("#datepicker").val();
    var gender = $("input:radio[name=gender]:checked").val();
    if(gender == undefined)
        gender = 0;
    if(email != null){
        var arr = email.split("@");
        if(arr.length > 1){
            var datas = {
                "name" : name,
                "ho" : ho,
                "email" : email,
                "gender" : gender,
                "dateofbirth" :dateofbirth
            };
            $.ajax({
                url : "/updatePro",
                data : datas,
                success : function(result){
                    if(result.popup == 0){
                        popupFail("Lỗi");
                    }
                    if(result.popup == 1){
                        popupFail("Email đã sử dụng");
                    }
                    if(result.popup == 2){
                        popupSuccess("Cập nhật thành công");
                    }
                }
            });
        }
        else
            popupFail("Email không đúng định dạng");
    }
    else{
        var datas = {
            "name" : name,
            "ho" : ho,
            "email" : email,
            "gender" : gender,
            "dateofbirth" :dateofbirth
        };
        $.ajax({
            url : "/updatePro",
            data : datas,
            success : function(result){
                if(result.popup == 0){
                    popupFail("Lỗi");
                }
                if(result.popup == 1){
                    popupFail("Email đã sử dụng");
                }
                if(result.popup == 2){
                    popupSuccess("Cập nhật thành công");
                }
            }
        });
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
function updateAvatar(){
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

function changeNameAvatar(){
    var input = document.getElementById('inputGroupFile01');
    input.addEventListener( 'change', showFileName );
    function showFileName( event ) { 
      var input = event.srcElement;
      var fileName = null;
      if(fileName == undefined){
          fileName = input.files[0].name;
      }
      $("#fileName").html(fileName);
      updateAvatar();
        changeAvatar(fileName);
    }
}
function changeAvatar(filename){
    var datas = {
        "filename" : filename
    }
    $.ajax({
        url : "/changeAvatar",
        data : datas,
        success: function(result){
            location.href= "/profile";
        }
       
    })
}
