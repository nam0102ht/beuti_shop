
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta charset="UTF8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <#include "cssscript.ftl">
        <script src="js/login.js?v=9"></script>
        <script src="js/function_login.js?v=9"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-loading-overlay/2.1.6/loadingoverlay.min.js" integrity="sha256-CImtjQVvmu/mM9AW+6gYkksByF4RBCeRzXMDA9MuAso=" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="plugins/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="plugins/fonts/iconic/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
    <body>
        <script>
          window.fbAsyncInit = function() {
            FB.init({
              appId      : '385848498773537',
              cookie     : true,
              xfbml      : true,
              version    : 'v4.0'
            });

            FB.AppEvents.logPageView();   

          };

          (function(d, s, id){
             var js, fjs = d.getElementsByTagName(s)[0];
             if (d.getElementById(id)) {return;}
             js = d.createElement(s); js.id = id;
             js.src = "https://connect.facebook.net/en_US/sdk.js";
             fjs.parentNode.insertBefore(js, fjs);
           }(document, 'script', 'facebook-jssdk'));
        </script>
        <div class="limiter">
		<div class="container-login100" style="background-image: url('img/meowmeow.jpg');background-size: 100%;">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<div class="login100-form validate-form">
					<span class="login100-form-title p-b-49">
                                                <p><img src="img/logo-icon.png" width="50px"/></p>
						Login
					</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is required">
						<span class="label-input100">Username</span>
						<input id="username_lg" class="input100" type="text" name="username" placeholder="Type your username">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password</span>
						<input id="password_lg" class="input100" type="password" name="pass" placeholder="Type your password">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					<div class="flex-sb-m w-full p-t-10 p-b-50 ">
						<div class="text-left p-t-8 p-b-31">
								<a href="/register" >
									Register
								</a>
						</div>
						<div class="text-right p-t-8 p-b-31">
						
								<a href="#">
									Forgot password?
								</a>
						</div>
					</div>
					
					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" onclick="loginNormal()">
								Login
							</button>
						</div>
					</div>

					<div class="txt1 text-center p-t-54 p-b-20">
						<span>
							Or Sign Up Using
						</span>
					</div>

					<div class="flex-c-m">
						<a href="#" onclick="loginFB()" class="login100-social-item bg1">
							<i class="fa fa-facebook"></i>
						</a>

						<a href="#" class="login100-social-item bg2">
							<i class="fa fa-twitter"></i>
						</a>

						<a href="#" class="login100-social-item bg3">
							<i class="fa fa-google"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="dropDownSelect1"></div>
        <script src="plugins/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="plugins/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="plugins/vendor/bootstrap/js/popper.js"></script>
<!--===============================================================================================-->
	<script src="plugins/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="plugins/vendor/daterangepicker/moment.min.js"></script>
	<script src="plugins/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="plugins/vendor/countdowntime/countdowntime.js"></script>
    </body>
</html>
