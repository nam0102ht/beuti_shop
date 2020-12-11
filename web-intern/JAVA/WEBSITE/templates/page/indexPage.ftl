<!DOCTYPE html>
<html>

<head>
    <#include "cssscript.ftl">
    <link href="css/blogpost.css?v=2" rel="stylesheet" />
    <script src="js/blogpost.js?v=5"></script>
    <script src="js/article.js"></script>
</head>
<body>
    <div id="fb-root"></div>
    <script>
        window.fbAsyncInit = function() {
          FB.init({
            appId            : 'your-app-id',
            autoLogAppEvents : true,
            xfbml            : true,
            version          : 'v4.0'
          });
        };
    </script>
    <script async defer src="https://connect.facebook.net/en_US/sdk.js"></script>
    <#include "header.ftl">
    <div>
        <div id="community" class="">
            <#include "blogPostPage.ftl">
        </div>
        <div id="unbox" class="">
            <#include "notfound.ftl">
        </div>
        <div id="sharedtip" class="">
            <#include "sharedtip.ftl">
        </div>
        <#include "mini_menu.ftl">
    </div>
    <#include "footer.ftl">
</body>

</html>