function clickActiveUnbox(id){
    if(id == "news-feed"){
        $("#news-feed").removeClass("info-class-false");
        $("#news-feed").addClass("info-class-true");
        $("#unboxing").removeClass("info-class-true");
        $("#unboxing").addClass("info-class-false");
        $("#product").removeClass("info-class-true");
        $("#product").addClass("info-class-false");
    }
    if(id == "unboxing"){
        $("#news-feed").removeClass("info-class-true");
        $("#news-feed").addClass("info-class-false");
        $("#unboxing").removeClass("info-class-false");
        $("#unboxing").addClass("info-class-true");
        $("#product").removeClass("info-class-true");
        $("#product").addClass("info-class-false");
    }
    if(id == "product"){
        $("#news-feed").removeClass("info-class-true");
        $("#news-feed").addClass("info-class-false");
        $("#unboxing").removeClass("info-class-true");
        $("#unboxing").addClass("info-class-false");
        $("#product").removeClass("info-class-false");
        $("#product").addClass("info-class-true");
    }
}