<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ru">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="assets/css/modal.css">
    <link rel="stylesheet" href="modal.css">
    <script src="modal.js"></script>
    <title>Home page</title>
</head>
<style>
    body{    margin: 0px;
        background:
                #333333;

    }

    /* Form Style */
    .form-horizontal{
        background: #fff;
        padding-bottom: 40px;
        border-radius: 15px;
        text-align: center;
    }
    .form-horizontal .heading{
        display: block;
        font-size: 35px;
        font-weight: 700;
        padding: 35px 0;
        border-bottom: 1px solid #f0f0f0;
        margin-bottom: 30px;
    }
    .form-horizontal .form-group{
        padding: 0 40px;
        margin: 0 0 25px 0;
        position: relative;
    }
    .form-horizontal .form-control{
        background: #f0f0f0;
        border: none;
        border-radius: 20px;
        box-shadow: none;
        padding: 0 20px 0 45px;
        height: 40px;
        transition: all 0.3s ease 0s;
    }
    .form-horizontal .form-control:focus{
        background: #e0e0e0;
        box-shadow: none;
        outline: 0 none;
    }
    .form-horizontal .form-group i{
        position: absolute;
        top: 12px;
        left: 60px;
        font-size: 17px;
        color: #c8c8c8;
        transition : all 0.5s ease 0s;
    }
    .form-horizontal .form-control:focus + i{
        color: #00b4ef;
    }
    .form-horizontal .fa-question-circle{
        display: inline-block;
        position: absolute;
        top: 12px;
        right: 60px;
        font-size: 20px;
        color: white;
        transition: all 0.5s ease 0s;
    }
    .form-horizontal .fa-question-circle:hover{
        color: #000;
    }
    .form-horizontal .main-checkbox{
        float: left;
        width: 20px;
        height: 20px;
        background: #11a3fc;
        border-radius: 50%;
        position: relative;
        margin: 5px 0 0 5px;
        border: 1px solid #11a3fc;
    }
    .form-horizontal .main-checkbox label{
        width: 20px;
        height: 20px;
        position: absolute;
        top: 0;
        left: 0;
        cursor: pointer;
    }
    .form-horizontal .main-checkbox label:after{
        content: "";
        width: 10px;
        height: 5px;
        position: absolute;
        top: 5px;
        left: 4px;
        border: 3px solid #fff;
        border-top: none;
        border-right: none;
        background: transparent;
        opacity: 0;
        -webkit-transform: rotate(-45deg);
        transform: rotate(-45deg);
    }
    .form-horizontal .main-checkbox input[type=checkbox]{
        visibility: hidden;
    }
    .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
        opacity: 1;
    }
    .form-horizontal .text{
        float: left;
        margin-left: 7px;
        line-height: 20px;
        padding-top: 5px;
        text-transform: capitalize;
    }
    .form-horizontal .btn{
        float: right;
        font-size: 14px;
        color: #fff;
        background: #00b4ef;
        border-radius: 30px;
        padding: 10px 25px;
        border: none;
        text-transform: capitalize;
        transition: all 0.5s ease 0s;
    }
    @media only screen and (max-width: 479px){
        .form-horizontal .form-group{
            padding: 0 25px;
        }
        .form-horizontal .form-group i{
            left: 45px;
        }
        .form-horizontal .btn{
            padding: 10px 20px;
        }
    }

    .navbar-dark {
        /*background: #000;*/
        background:#333333;;
        transition: background-color .15s linear;
    }
    .fixed-top {
        position: fixed;
        top: 0;
        right: 0;
        left: 0;
        z-index: 1030;
    }
    .navbar {
        position: relative;
        display: flex;
        flex-wrap: wrap;
        align-items: center;
        justify-content: space-between;
        padding: 0.8333333333rem 3rem;
    }
    .reg{
        float: bottom;
        font-size: 14px;
        color: #fff;
        background: #00b4ef;
        border-radius: 30px;
        padding: 10px 25px;
        border: none;
        text-transform: capitalize;
        transition: all 0.5s ease 0s;
    }
    .post{
        align-items: center;
        max-height: 30px;
        max-width: 500px;
        position: relative;
    }
    .article{
        text-align: center;
        color: whitesmoke;
        size: 25px;
        border-radius: 10px;
        border: 1px solid greenyellow;
        font-family: Georgia, SansSerif, sans-serif;

    }
    .list-group{
        padding-left: 200px;
        align-items: center;
    }
    .work{
        text-align: center;
        color: whitesmoke;
        position: relative;
        padding-left: 100px;
    }
    .topp{
        padding-left: 600px;
    }
</style>
<#--<nav class="navbar navbar-expand-lg navbar-light bg-header">-->
<#--    <div class="collapse navbar-collapse" id="navbarSupportedContent">-->
<div class="container">
        <div class="row">
    <div class = "top_menu">
        <div class="topp">
        <nav class="navbar navbar-expand-lg fixed-top navbar-dark">
        <ul class="navbar-nav mr-auto">
            <li>
                <a class="mx-auto navbar-brand" href="http://localhost:8080/registration">
                    <#--                    TODO(поменяй на 8081 и ссылку на сервлет с меню)-->
                    <img src="https://dfd5gcc6b7vw5.cloudfront.net/assets/logo-8a7bb8b7de46c1b7163081c1d735c55860cf8d83689ad0a98a1865826a82b7cc.svg" width="34" height="34" class="d-inline-block align-top" alt="Thenx">
                </a>
            </li>
            <li class="nav-item active ">
                <a name="element" class="nav-link font-italic" href="/profile"> Profile <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active ">
                <a name="element" class="nav-link font-italic" href="/home"> Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a name="element" class="nav-link font-italic" href="/workouts">Workouts <span
                            class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a name="element" class="nav-link font-italic" href="/search">Search <span
                            class="sr-only">(current)</span></a>
            </li>
<#--            //TODO(ссылки поменяй)-->
        </ul>
        </nav>
        </div>
    </div>
        </div>
</div>

<#--    </div>-->
<#--</nav>-->
<div class="col-md-10 blogShort">
    <div class="work">
    <h2>WORKOUTS</h2><br><br>
    </div>
    <div>
        <ul id="list" class="list-group listSize">
            <div class="post">
                <img src="../../images/1.jpg" alt="post img" class="pull-left img-responsive thumb margin10 img-thumbnail">
                <p></p>
                <article class="article"><p>
                        Наиль лох
                    </p></article>
                <button id="show-modal" class="btn">Открыть</button>

                <script src="modal.js"></script>
                <script>
                    (function () {
                        // создаём модальное окно
                        var modal = $modal();
                        // при клике по кнопке #show-modal
                        document.querySelector('#show-modal').addEventListener('click', function () {
                            // отобразим модальное окно
                            modal.show();
                        });
                    })();
                </script>
                <br>
                <div class="post">
                    <img src="../../images/1.jpg" alt="post img" class="pull-left img-responsive thumb margin10 img-thumbnail">
                    <p></p>
                    <article class="article"><p>
                            Наиль лох
                        </p></article><br>
                    <div class="post">
                        <img src="../../images/1.jpg" alt="post img" class="pull-left img-responsive thumb margin10 img-thumbnail">
                        <p></p>
                        <article class="article"><p>
                                Наиль лох
                            </p></article><br>
                        <div class="post">
                            <img src="../../images/1.jpg" alt="post img" class="pull-left img-responsive thumb margin10 img-thumbnail">
                            <p></p>
                            <article class="article"><p>
                                    Наиль лох
                                </p></article><br>
                            <div class="post">
                                <img src="../../images/1.jpg" alt="post img" class="pull-left img-responsive thumb margin10 img-thumbnail">
                                <p></p>
                                <article class="article"><p>
                                        Наиль лох
                                    </p></article><br>
                                <div class="post">
                                    <img src="../../images/1.jpg" alt="post img" class="pull-left img-responsive thumb margin10 img-thumbnail">
                                    <p></p>
                                    <article class="article"><p>
                                            Наиль лох
                                        </p></article><br>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </ul>
    </div>
</div>