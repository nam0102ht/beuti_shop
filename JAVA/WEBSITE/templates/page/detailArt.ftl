<!DOCTYPE html>
<html>

<head>
    <#include "cssscript.ftl">
    <link href="css/posts.css?v=2" rel="stylesheet" />
    <script src="js/article.js"></script>
</head>
<body>
    <#include "header.ftl">
    <div id="_main">
        <div class="container containermain">
            <div class="row container">
                <img width="100%" src="${path_dir}${art.getImg()}" alt="First slide">
            </div>
            <div class="row rowtitleposts" style="margin-top:50px;">
                <div class="col-sm-2 _2smtitlepost"></div>
                <div class="col-sm-8 _8smtitlepost">
                    <h1 class="_titlepost">
                        ${art.getPage_title()}
                    </h1>
                </div>
                <div class="col-sm-2 _2smtitlepost"></div>

            </div>
            <!-- end title post -->

            <div class="row rowbtnfb">
                <div class="col-sm-2 _2smbtnfb"></div>
                <div class="col-sm-8 _8mbtnfb">
                    <div class="row">
                        <div class="col-sm-6 _6smiconfb">
                            <!-- <div id="fb-root"></div>
    
                                <!-- Your share button code -->
                                <div class="fb-share-button" data-href="https://www.facebook.com" data-layout="button_count">
                                </div>

                        </div>
                        <div class="col-sm-6 _6smbtnsave text-xs-right">
                            <button type="button" class="btn btn-primary btnsaveposts"> <p class="textsavepost">Lưu bài viết</p> </button>
                        </div>
                    </div>

                </div>
                <div class="col-sm-2 _2smbtnfb"></div>


            </div>
            <!-- end nut share va save -->
            <div class="row _datetimeview">
                <div class="col-sm-2 _2smdatetime">

                </div>
                <div class="col-sm-8 _8smdatetime">
                    <p class="_pdatetime">
                        20-02-2019 | 19481312 view
                    </p>
                </div>
                <div class="col-sm-2 _2smdatetime">

                </div>
            </div>
            <div class="row contentpost">
                <div class="col-sm-2 _2smcontent"></div>
                <div class="col-sm-8 _8smcontent">
                    <b class="bcontent">Bước 1</b>
                    <p class="pcontent">Proin numquam quisque minim neque incidunt similique rhoncus, porta? Gravida tempus commodo, lacus. Impedit magni integer donec laudantium possimus, ullamco doloribus, nostrud! Condimentum dolorum! Vel cubilia ullam? Dui? Ipsum accumsan,
                        molestiae quasi, aliquip consequatur recusandae! Esse, elementum odit, unde! Leo, ante alias necessitatibus hendrerit provident! Bibendum dolor magna, earum primis minima, optio sociis pretium, adipisci vulputate exercitation voluptatum
                        animi iure ultrices torquent, montes bibendum. Litora consequatur. Autem facilis eleifend faucibus? Commodo deleniti rem felis incidunt minim laudantium? Aperiam nobis magnis eleifend anim numquam pretium, iste! Volutpat voluptate,
                        rutrum? Taciti optio, qui temporibus vestibulum. Eaque tristique nostra, mattis ante, justo placerat.</p>
                    <div class="imgcontent">
                    </div>
                    <p class="pcontent"> Minim neque incidunt similique rhoncus, <b>Proin numquam quisque</b> porta? Gravida tempus commodo, lacus. Impedit magni integer donec laudantium possimus, ullamco doloribus, nostrud! Condimentum dolorum! Vel cubilia ullam? Dui? Ipsum
                        accumsan, molestiae quasi, aliquip consequatur recusandae! Esse, elementum odit, unde! Leo, ante alias necessitatibus hendrerit provident! Bibendum dolor magna, earum primis minima, optio sociis pretium, adipisci vulputate exercitation
                        voluptatum animi iure ultrices torquent, montes bibendum. Litora consequatur. Autem facilis eleifend faucibus? Commodo deleniti rem felis incidunt minim laudantium? Aperiam nobis magnis eleifend anim numquam pretium, iste! Volutpat
                        voluptate, rutrum? Taciti optio, qui temporibus vestibulum. Eaque tristique nostra, mattis ante, justo placerat.</p>

                    <p class="pcontent"> minim neque incidunt similique rhoncus, porta? Gravida tempus commodo, lacus. Impedit magni integer donec laudantium possimus, ullamco doloribus, nostrud! Condimentum dolorum! Vel cubilia ullam? Dui? Ipsum accumsan, molestiae quasi,
                        aliquip consequatur recusandae! Esse, elementum odit, unde! Leo, ante alias necessitatibus hendrerit provident! Bibendum dolor magna, earum primis minima, optio sociis pretium, adipisci vulputate exercitation voluptatum animi iure
                        ultrices torquent, montes bibendum. Litora consequatur. Autem facilis eleifend faucibus? Commodo deleniti rem felis incidunt minim laudantium? Aperiam nobis magnis eleifend anim numquam pretium, iste! Volutpat voluptate, rutrum?
                        Taciti optio, qui temporibus vestibulum. Eaque tristique nostra, mattis ante, justo placerat.</p>
                    
                    <b class="bcontent">Bước 2</b>
                    <p class="pcontent">Proin numquam quisque minim neque incidunt similique rhoncus, porta? Gravida tempus commodo, lacus. Impedit magni integer donec laudantium possimus, ullamco doloribus, nostrud! Condimentum dolorum! Vel cubilia ullam? Dui? Ipsum accumsan,
                        molestiae quasi, aliquip consequatur recusandae! <b> Esse, elementum odit, unde!  </b> Leo, ante alias necessitatibus hendrerit provident! Bibendum dolor magna, earum primis minima, optio sociis pretium, adipisci vulputate exercitation
                        voluptatum animi iure ultrices torquent, montes bibendum. Litora consequatur. Autem facilis eleifend faucibus? Commodo deleniti rem felis incidunt minim laudantium? Aperiam nobis magnis eleifend anim numquam pretium, iste! Volutpat
                        voluptate, rutrum? Taciti optio, qui temporibus vestibulum. Eaque tristique nostra, mattis ante, justo placerat.</p>

                    <p class="pcontent">Proin numquam quisque minim neque incidunt similique rhoncus, porta? Gravida tempus commodo, lacus. Impedit magni integer donec laudantium possimus, ullamco doloribus, nostrud! Condimentum dolorum! Vel cubilia ullam? Dui? Ipsum accumsan,
                        molestiae quasi, aliquip consequatur recusandae! Esse, elementum odit, unde! Leo, ante alias necessitatibus hendrerit provident! Bibendum dolor magna, earum primis minima, optio sociis pretium, adipisci vulputate exercitation voluptatum
                        animi iure ultrices torquent, montes bibendum. Litora consequatur. Autem facilis eleifend faucibus? Commodo deleniti rem felis incidunt minim laudantium? Aperiam nobis magnis eleifend anim numquam pretium, iste! Volutpat voluptate,
                        rutrum? Taciti optio, qui temporibus vestibulum. Eaque tristique nostra, mattis ante, justo placerat.</p>
                    
                    <b class="bcontent">Bước 3</b>
                    <p class="pcontent">Proin numquam quisque minim neque incidunt similique <b> Esse, elementum odit, unde!  </b> rhoncus, porta? Gravida tempus commodo, lacus. Impedit magni integer donec laudantium possimus, ullamco doloribus, nostrud! Condimentum dolorum!
                        Vel cubilia ullam? Dui? Ipsum accumsan, molestiae quasi, aliquip consequatur recusandae! Esse, elementum odit, unde! Leo, ante alias necessitatibus hendrerit provident! Bibendum dolor magna, earum primis minima, optio sociis pretium,
                        adipisci vulputate exercitation voluptatum animi iure ultrices torquent, montes bibendum. Litora consequatur. Autem facilis eleifend faucibus? Commodo deleniti rem felis incidunt minim laudantium? Aperiam nobis magnis eleifend
                        anim numquam pretium, iste! Volutpat voluptate, rutrum? Taciti optio, qui temporibus vestibulum. Eaque tristique nostra, mattis ante, justo placerat.</p>

                    <p class="pcontent">Proin numquam quisque minim neque incidunt similique rhoncus, porta? Gravida tempus commodo, lacus. Impedit magni integer donec laudantium possimus, ullamco doloribus, nostrud! Condimentum dolorum! Vel cubilia ullam? Dui? Ipsum accumsan,
                        molestiae quasi, aliquip consequatur recusandae! Esse, elementum odit, unde! Leo, ante alias necessitatibus hendrerit provident! Bibendum dolor magna, earum primis minima, optio sociis pretium, adipisci vulputate exercitation voluptatum
                        animi iure ultrices torquent, montes bibendum. Litora consequatur. Autem facilis eleifend faucibus? Commodo deleniti rem felis incidunt minim laudantium? Aperiam nobis magnis eleifend anim numquam pretium, iste! Volutpat voluptate,
                        rutrum? Taciti optio, qui temporibus vestibulum. Eaque tristique nostra, mattis ante, justo placerat.</p>
                    
                    <b class="bcontent">Bước 4</b>
                    <p class="pcontent">Proin numquam quisque minim neque incidunt similique rhoncus, porta? Gravida tempus commodo, lacus. Impedit magni integer donec laudantium possimus, ullamco doloribus, nostrud! Condimentum dolorum! Vel cubilia ullam? Dui? Ipsum accumsan,
                        molestiae quasi, aliquip consequatur recusandae! Esse, elementum odit, unde! Leo, ante alias necessitatibus hendrerit provident! Bibendum dolor magna, earum primis minima, optio sociis pretium, adipisci vulputate exercitation voluptatum
                        animi iure ultrices torquent, montes bibendum. Litora consequatur. <b> Esse, elementum odit, unde!  </b> Autem facilis eleifend faucibus? Commodo deleniti rem felis incidunt minim laudantium? Aperiam nobis magnis eleifend anim
                        numquam pretium, iste! Volutpat voluptate, rutrum? Taciti optio, qui temporibus vestibulum. Eaque tristique nostra, mattis ante, justo placerat.</p>
                    <p class="pcontent">Proin numquam quisque minim neque incidunt similique rhoncus, porta? Gravida tempus commodo, lacus. Impedit magni integer donec laudantium possimus, ullamco doloribus, nostrud! Condimentum dolorum! Vel cubilia ullam? Dui? Ipsum accumsan,
                        molestiae quasi, aliquip consequatur recusandae! Esse, elementum odit, unde! Leo, ante alias necessitatibus hendrerit provident! Bibendum dolor magna, earum primis minima, optio sociis pretium, adipisci vulputate exercitation voluptatum
                        animi iure ultrices torquent, montes bibendum. Litora consequatur. Autem facilis eleifend faucibus? Commodo deleniti rem felis incidunt minim laudantium? Aperiam nobis magnis eleifend anim numquam pretium, iste! Volutpat voluptate,
                        rutrum? Taciti optio, qui temporibus vestibulum. Eaque tristique nostra, mattis ante, justo placerat.</p>

                    <p class="pcontent">Proin numquam quisque minim neque incidunt similique rhoncus, <b> Esse, elementum odit, unde!  </b> porta? Gravida tempus commodo, lacus. Impedit magni integer donec laudantium possimus, ullamco doloribus, nostrud! Condimentum dolorum!
                        Vel cubilia ullam? Dui? Ipsum accumsan, molestiae quasi, aliquip consequatur recusandae! Esse, elementum odit, unde! Leo, ante alias necessitatibus hendrerit provident! Bibendum dolor magna, earum primis minima, optio sociis pretium,
                        adipisci vulputate exercitation voluptatum animi iure ultrices torquent, montes bibendum. Litora consequatur. Autem facilis eleifend faucibus? Commodo deleniti rem felis incidunt minim laudantium? Aperiam nobis magnis eleifend
                        anim numquam pretium, iste! Volutpat voluptate, rutrum? Taciti optio, qui temporibus vestibulum. Eaque tristique nostra, mattis ante, justo placerat.</p>
                    
                    <p class="pcontent">Repudiandae nobis hymenaeos sapiente. Laboris exercitationem. Nunc scelerisque earum, voluptatum doloribus faucibus?</p>
                    
                </div>
                <div class="col-sm-2 _2smcontent"></div>
            </div>

        </div>
        <!-- end container -->

    </div>
    <#include "footer.ftl">
</body>

</html>