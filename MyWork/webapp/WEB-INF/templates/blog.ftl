<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ru">

<#--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"-->
<#--      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">-->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script><head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="assets/css/catStyle.css">
    <link rel="stylesheet" href="modal.css">
<#--    <script src="modal.js"></script>-->
    <title>Blog page</title>
        <script src="../templates/navbar.js"></script>

</head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">

<#--<nav class="navbar navbar-expand-lg navbar-light bg-header">-->
<#--    <div class="collapse navbar-collapse" id="navbarSupportedContent">-->
<div class="navbar navbar-expand-md navbar-dark bg-dark mb-4" role="navigation">
    <a class="navbar-brand" href="#">Cool blog from BadBoy Nail aka Arias</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/profile">Profile<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/workouts">Workouts<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="dropdown1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Какаято штука</a>
                <ul class="dropdown-menu" aria-labelledby="dropdown1">
                    <li class="dropdown-item" href="#"><a>Сделать то</a></li>
                    <li class="dropdown-item" href="#"><a>Сделать се</a></li>
                </ul>
            </li>
        </ul>
        <!--        <form class="form-inline mt-2 mt-md-0">-->
        <!--            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">-->
        <!--            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>-->
        <!--        </form>-->
    </div>
</div>
<#--    <script src="modal.js"></script>-->
<#--    <script>-->
<#--        (function () {-->
<#--            // создаём модальное окно-->
<#--            var modal = $modal();-->
<#--            // при клике по кнопке #show-modal-->
<#--            document.querySelector('#show-modal').addEventListener('click', function () {-->
<#--                // отобразим модальное окно-->
<#--                modal.show();-->
<#--            });-->
<#--        })();-->
<#--    </script>-->
<#--    <br>-->
    <div class="container">
        <h3 class="pb-3 mb-4 font-italic border-bottom">
             Workouts
        </h3>
    <div class="row">
        <div class="col-md-4">
            <div class="card mb-4">
                <img class="card-img-top" src="//placeimg.com/290/180/any" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <a href="#" class="btn btn-outline-dark btn-sm">Go somewhere</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4">
                <img class="card-img-top" src="//placeimg.com/290/180/any" alt="Card image cap">
                <!--            меняешь тут ссылку на фоточку и в остальных так же-->
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <a href="#" class="btn btn-outline-dark btn-sm">Go somewhere</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4">
                <img class="card-img-top" src="//placeimg.com/290/180/any" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <a href="#" class="btn btn-outline-dark btn-sm">Go somewhere</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4">
                <img class="card-img-top" src="//placeimg.com/290/180/any" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <a href="#" class="btn btn-outline-dark btn-sm">Go somewhere</a>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card mb-4">
                <img class="card-img-top" src="//placeimg.com/290/180/any" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <a href="#" class="btn btn-outline-dark btn-sm">Go somewhere</a>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card mb-4">
                <img class="card-img-top" src="//placeimg.com/290/180/any" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <a href="#" class="btn btn-outline-dark btn-sm">Go somewhere</a>
                </div>
            </div>
        </div>
    </div>
</div>
</div>