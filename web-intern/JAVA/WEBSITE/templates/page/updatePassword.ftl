<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <link rel="stylesheet" type="text/css" href="css/profile.css">
        <#include "cssscript.ftl">
        <link rel="stylesheet" href="css/profile-matkhau.css">
    </head>
    <body>
        <#include "header.ftl">
        <div id="_mainprofile">
            <div class="container containpro">
                <div class="row rowimg">
                    <div class="_info">
                        <div class="layer1">
                            <img class="imgcover" src="img/banner-profile.png" alt="">
                        </div>
                        <div class="layer2">
                            <img src="${path_img}" class="imgavt img-fluid" alt="">
                            <form class="formimages">


                                <input type="file" name="pic" class="imputavt" style="color:transparent; width:100px;" />
                                <input type="file" name="pic" class="imputcover" style="color:transparent; width:100px;" />

                            </form>

                        </div>


                    </div>
                </div>
                <div class="row rownavpro">
                    <div class="col-sm-3 sm2pro">
                        <div class="textinfo">
                            Trang cá nhân
                        </div>
                        <#include "leftMenuProfile.ftl">

                    </div>
                    <div class="col-sm-9 sm10pro">

                        <div class="row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-8">
                                <h3 style="text-align:center">Đổi mật khẩu</h3>
                                <form Id="signupform" action="" class="form-horizontal" method="post" role="form"><input name="__RequestVerificationToken" type="hidden" value="" />
                                    <fieldset style="padding: 15px;">
                                        <div class="form-group has-feedback">
                                            <a href="" class="iconprivate"> <i class="fas fa-lock"></i></a>
                                            <input class="form-control" data-val="true" data-val-length="Mật khẩu dài ít nhất 4 ký tự" data-val-length-max="255" data-val-length-min="4" data-val-required="Nhập mật khẩu mới" id="NewPassword" name="NewPassword" placeholder="Mật khẩu mới" type="password"
                                            />
                                            <span class="field-validation-valid" data-valmsg-for="NewPassword" data-valmsg-replace="true"></span>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <a href="" class="iconprivate"> <i class="fas fa-lock"></i></a>
                                            <input class="form-control" data-val="true" data-val-equalto="Xác nhận mật khẩu không đúng" data-val-equalto-other="*.NewPassword" data-val-required="Xác nhận mật khẩu mới" id="ConfirmNewPassword" name="ConfirmNewPassword" placeholder="Xác nhận mật khẩu mới"
                                                type="password" />
                                            <span class="field-validation-valid" data-valmsg-for="ConfirmNewPassword" data-valmsg-replace="true"></span>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                            </div>
                                            <div class="col-sm-6">
                                                <div>
                                                    <input type="submit" value="Đổi mật khẩu" id="bt_submit" class="btn btn-primary" style="width:100%" />
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                            </div>
                                        </div>

                                    </fieldset>
                                </form>
                            </div>
                            <div class="col-sm-2"></div>
                        </div>


                    </div>


                </div>
            </div>
        </div>
        <div class="line"></div>
        <#include "footer.ftl">
    </body>
</html>
