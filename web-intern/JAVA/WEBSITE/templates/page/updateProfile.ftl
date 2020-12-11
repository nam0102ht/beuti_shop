<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <link rel="stylesheet" type="text/css" href="css/profile.css">
        <#include "cssscript.ftl">
        <link href="css/profile-thongtin.css" rel="stylesheet">
        <script src="js/updateAccount.js?v=3"></script>
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
                        <ul class="nav nav-tabs navtabinfo" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active linkiteminfo" id="infoaccount-tab" data-toggle="tab" href="#infoaccount" role="tab" aria-controls="infoaccount" aria-selected="true">Thông
                                    tin cá nhân</a>
                            </li>
                            <!-- <li class="nav-item">
                                <a class="nav-link linkiteminfo" id="infobeauty-tab" data-toggle="tab" href="#infobeauty" role="tab" aria-controls="infobeauty" aria-selected="false">Thông tin làm đẹp</a>
                            </li> -->

                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div id="infoaccount" class="tab-pane active">
                                <div class="edit-profile-basic-info">
                                    <form action="" id="UpdateProfileBasicInfoForm" method="post">
                                        <div class="widget-info-edit clearfix">
                                            <label>Tên:</label>
                                            <input class="firsname" id="FirstName" name="FirstName" tabindex="1" type="text" value="${user.getLast_name()}"/>
                                        </div>
                                        <div class="widget-info-edit clearfix">
                                            <label>Họ:</label>
                                            <input class="lastname" id="LastName" name="LastName" tabindex="2" type="text" value="${user.getFirst_name()}"/>
                                        </div>
                                        <#if user.getEmail() ??>
                                        <#else>
                                            <div class="widget-info-edit clearfix">
                                                <label>Email:</label>
                                                <input class="relationship" id="email" name="LastName" tabindex="3" type="email"/>
                                            </div>
                                        </#if>
                                        <div class="widget-info-edit clearfix">
                                            <label>Ngày sinh:</label>
                                            <input class="lastname" id="datepicker" class="datepicker" data-date-format="dd/mm/yyyy">
                                        </div>
                                        <div class="widget-info-edit clearfix">
                                            <label class="sex">Giới tính:</label>
                                            <input checked="checked" id="Gender" name="Gender" style="margin-left:-5px;" type="radio" value="0" /><label style="width:70px;">Nam</label>
                                            <input id="Gender" name="Gender" type="radio" value="1" /><label style="width:70px;">Nữ</label>
                                            
                                        </div>
                                        <label class="alert-success" id="id-UpdateProfileBasicInfoForm-success" style="display:none">Cập nhật thành công</label>
                                        <input type="button" class="btn btn-info" value="Lưu thay đổi" onclick="updateAccount()" />
                                    </form>
                                </div>

                            </div>

                            <!-- <div class="tab-pane fade" id="infobeauty" role="tabpanel" aria-labelledby="infobeauty-tab">

                            </div> -->

                        </div>


                    </div>


                </div>
            </div>
        </div>
        <div class="line"></div>
    <#include "footer.ftl">
    </body>
</html>