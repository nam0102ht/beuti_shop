<div class="header">
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <div class="container" style="padding-left:5%;">
                <a class="navbar-brand" href="/">
                    <img src="img/logo-icon.png" alt="logo" style="width:50px">
                </a>
                <!-- end logo -->

                <button class="navbar-toggler" data-target="#my-nav" data-toggle="collapse" aria-controls="my-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div id="my-nav" class="collapse navbar-collapse" style="padding-left:8%">
                    <ul class="navbar-nav mr-auto">

                        <li class="nav-item">
                            <a class="nav-link" href="#" onclick="clickActiveUnbox('news-feed')">Bài Viết</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="#" onclick="clickActiveUnbox('product')">Bộ Sưu Tập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="#" onclick="clickActiveUnbox('unboxing')">Địa Điểm</a>
                        </li>

                        <li class="nav-item dropdown cosmetics ">Mỹ Phẩm

                            <div class="dropdown-content">
                                <a href="/face">Da</a>
                                <a href="/hair">Tóc</a>
                                <a href="/nail">Nail</a>
                            </div>

                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="# ">Điểm Danh</a>
                        </li>

                        <li class="nav-item dropdown bars ">
                            <i class="fas fa-bars "></i>
                            <div class="dropdown-content ">
                                <a href="/about">Giới thiệu về BlackCat</a>

                                <a href="# ">Chính sách điểm thưởng</a>

                                <a href="# ">Top thành viên</a>

                                <a href="# ">Góp ý</a>
                            </div>
                        </li>
                        <li class="nav-item iconfa">
                            <a class="nav-link " href="# "><i class="fas fa-plus "></i></a>
                        </li>

                        <li class="nav-item iconfa-bell">
                            <a class="nav-link " href="# "> <i class="fas fa-bell "></i></a>
                        </li>
                        <li class="nav-item profile ">
                            <#if user??>
                                <a class="nav-link ico_avartar" href="/profile"><img class="img-fluid avatarprofile" src="${path_img}" alt=""></a>
                                <div class="btn-group">
                                        <button data-toggle="dropdown">
                                            <#if user.getUsername() ??>
                                                <a class="profile " href="/profile"><span id="usernameID">${user.getUsername()}</span> <i class="fas fa-chevron-down "></i></a>
                                            <#else>
                                                <a class="profile " href="/profile"><span id="usernameID">${user.getLast_name()}</span> <i class="fas fa-chevron-down "></i></a>
                                            </#if>
                                        </button>

                                    <div class="dropdown-menu" id="dropdown_menu">
                                        <div class="list"><i class="fas fa-plus-square"></i> Hoạt động</div>
                                        <a class="dropdown-item" href="#">Hình ảnh</a>
                                        <a class="dropdown-item" href="#">Thích</a>
                                        <a class="dropdown-item" href="#">Quan tâm</a>

                                        <div class="list"><i class="fas fa-user-alt"></i> Tài khoản</div>
                                        <a class="dropdown-item" href="#">Cập nhật tài khoản</a>
                                        <a class="dropdown-item" href="/logout">Đăng xuất</a>
                                    </div>
                                </div>
                            <#else>
                                <a class="nav-link ico_avartar" href="/login"><img class="avatar " src="img/ico_avatar_chuadangnhap.png " alt=" "></a>
                                <button onclick="location.href='/login'" class="focusDN" data-toggle="dropdown">
                                    <a class="profile" href="/login">Đăng nhập<i class="fas fa-chevron-down "></i></a>
                                </button>
                            </#if>
                </div>
                </li>
                </ul>
            </div>
            <!-- end list item -->
    </div>
    <!-- end container -->

    </nav <!-- end nav bar -->
    </div>