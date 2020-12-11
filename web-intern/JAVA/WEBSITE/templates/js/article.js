$(document).ready(function(){
    getListArticle(1);
});

function getListArticle(page){
    var datas = {"page" : page};
    $.ajax({
        url: "/getListArticle",
        data : datas,
        success : function(result){
            var lst = result.listArticle;
            $("#sharedBlog").children().remove();
            for(let i=0; i< lst.length; i++){
                var obj = lst[i];
                $("#sharedBlog").append(
                    "<div class='col-sm-4 news-related'>"+
                        "<div class='card text-left'>"+
                            "<img class='card-img-top' style='width:244.984px; height:153.844px;' src='"+result.path_img+obj.img+"' alt=''>"+
                            "<div class='card-body'>"+
                                "<a href='/detailArticle?idArt="+obj.id+"' class='card-title'>"+obj.page_title+"</a>"+
                            "</div>"+
                        "</div>"+
                    "</div>"
                );
            }
        }
    });
}