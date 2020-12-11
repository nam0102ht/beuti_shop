$(document).ready(function(){
    var today = new Date();
    var currentMonth = today.getMonth();
    var currentYear = today.getFullYear();
    var totalDay = 32 - (new Date(currentYear, currentMonth, 32).getDate());
    var firstDateOfMonth = new Date(currentYear, currentMonth);
    let date = 1;
    
    for(var i = 0; i<6; i++){
        for(var j=0 ;j<7;j++){
            if(i == 0 && j< firstDateOfMonth.getDay()){
                $("#alldateinweek").append("<li class='none'></li>");
            }
            else if(date > totalDay){
                break;
            }
            else{
                if(date < today.getDate() && currentYear <= today.getFullYear() && currentMonth <= today.getMonth()){       
                            $("#alldateinweek").append("<li class='ltDate'>"+
                                    "<a href='#' id='number_"+date+"'>"+
                                    date+
                                    "</a>"+
                                    "</li>");
                        }
                else if(date == today.getDate() && currentYear == today.getFullYear() && currentMonth == today.getMonth()){
                        $("#alldateinweek").append("<li id='tday'>"+"<a href='#' style='color:red; font-weight:800;' id='number_"+date+"'>"+
                                    date+
                                    "</a>"+
                                    "</li>");
                }
                else if(date > today.getDate() && currentYear >= today.getFullYear() && currentMonth >= today.getMonth()){
                        $("#alldateinweek").append("<li>"+"<a href='#' id='number_"+date+"'>"+
                                    date+
                                    "</a>"+
                                    "</li>");
                }
                date++;
            }
        }        
    }
});