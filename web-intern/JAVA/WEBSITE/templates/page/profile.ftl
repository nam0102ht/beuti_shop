<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <#include "cssscript.ftl">
        <link rel="stylesheet" type="text/css" href="css/profile.css">
        <script src="js/updateAccount.js"></script>
        <script src="js/blogpost.js"></script>
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
                        <#if user2 ??>
                            <div class="layer2">
                                <img src="${path_img2}" class="imgavt img-fluid" alt="">
                                <span id="fileName" style="display: none!important"></span>
                                <form class="formimages disabled" enctype="multipart/form-data" id="fileUploadForm" name="fileUploadForm">
                                    <input type="file" onclick="changeNameAvatar()" name="uploadfile" id="inputGroupFile01" class="imputavt" style="color:transparent; width:100px;" />
                                </form>
                            </div>
                        <#else>
                            <div class="layer2">
                                <img src="${path_img}" class="imgavt img-fluid" alt="">
                                <span id="fileName" style="display: none!important"></span>
                                <form class="formimages" enctype="multipart/form-data" id="fileUploadForm" name="fileUploadForm">
                                    <input type="file" onclick="changeNameAvatar()" name="uploadfile" id="inputGroupFile01" class="imputavt" style="color:transparent; width:100px;" />
                                </form>
                            </div>
                        </#if>
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

                        <ul class="nav nav-tabs navprofile" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active navlinkprofile" id="blog-tab" data-toggle="tab" href="#blog" role="tab" aria-controls="blog" aria-selected="true"><i class="fas fa-blog"></i>Blog</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link navlinkprofile" id="pictures-tab" data-toggle="tab" href="#pictures" role="tab" aria-controls="pictures" aria-selected="false"><i class="fas fa-image"></i>Hình ảnh</a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link navlinkprofile" id="care-tab" data-toggle="tab" href="#care" role="tab" aria-controls="care" aria-selected="false"><i class="fas fa-user-cog"></i>Quan tâm</a>
                            </li>

                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="blog" role="tabpanel" aria-labelledby="blog-tab">
                                <div class="info-news-feed" id="local-newsfeed2" style="width:80%;">
                                 
                                </div>
                            </div>
                            <div class="tab-pane fade" id="pictures" role="tabpanel" aria-labelledby="pictures-tab">Hinh anh</div>
                            <div class="tab-pane fade" id="care" role="tabpanel" aria-labelledby="care-tab">
                                
                            </div>
                        </div>

                    </div>


                </div>
            </div>
        </div>
        <div class="line"></div>
        <#include "footer.ftl">
    </body>
</html>
