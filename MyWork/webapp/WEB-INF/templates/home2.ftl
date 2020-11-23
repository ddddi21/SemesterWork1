<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JS</title>
<#--    <link rel="stylesheet" href="css/style.css">-->
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat:400,700&amp;subset=cyrillic-ext" rel="stylesheet"
    <title>Home page</title>
</head>
<style>
    .btn {
        border: none;
        cursor: pointer;
        background-color: #101011;
        color: #fff;
        padding: 10px;
    }
    .btn2{
        display: flex;
        justify-content: center;
        display: inline-block;
        vertical-align: top;
        padding: 8px 30px;
        border: 3px solid #070707;
        font-size: 14px;
        font-weight: 700;
        color: #030303;
        text-transform: uppercase;
        text-decoration: none;
        transition: background .1s linear, color .1s linear;
    }

    .modal-overlay {
        position: fixed;
        left: 0;
        top: 0;
        right: 0;
        bottom: 0;
        background-color: rgba(0, 0, 0, 0.7);
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        width: 100%;
        opacity: 0;
        visibility: hidden;
        transition: all 0.3s ease-in-out;

    }

    .modal {
        background-color: #fff;
        width: 300px;
        margin-left: auto;
        margin-right: auto;
        height: 300px;
        display: flex;
        align-items: center;
        justify-content: center;
        display: none;
    }

    .modal-overlay--visible {
        opacity: 1;
        visibility: visible;
        transition: all 0.3s ease-in-out;
    }

    .modal--visible {
        display: block;
    }
    body {
        margin: 0;
        font-family: 'Montserrat', sans-serif;
        font-size: 15px;
        line-height: 1.6;
        color: #333;
    }
    *,
    *:before,
    *:after {
        box-sizing: border-box;
    }
    h1, h2, h3, h4, h5, h6 {
        margin: 0;
    }
    /* Container */
    .container {
        width: 100%;
        max-width: 1200px;
        margin: 0 auto;
    }
    /* Intro */
    .intro {
        display: flex;
        flex-direction: column;
        justify-content: center;
        width: 100%;
        height: 100vh;
        background: no-repeat center/50% url("../../images/1.jpg");
        -webkit-background-size: cover;
        background-size: cover;
    }
    .intro__inner {
        width: 100%;
        max-width: 880px;
        margin: 0 auto;
        text-align: center;
    }
    .intro__title {
        color: #020202;
        font-size: 100px;
        font-weight: 700;
        text-transform: uppercase;
        line-height: 1;
    }
    .intro__title:after {
        content: "";
        display: block;
        width: 60px;
        height: 3px;
        margin: 60px auto;
        background-color: #ffffff;
    }
    /*.btn:hover {*/
    /*    background-color: #fff;*/
    /*    color: #333;*/
    /*}*/
</style>
<body>
<form method="post" action="/home"><br>
    <header class="header">
        <div class="container">
        </div>
    </header>

    <div class="intro">
        <div class="container">
            <div class="intro__inner">
                <h1 class="intro__title">Добро пожаловать!</h1>
                <button type="button" class="btn" data-path="form-popup">Посетите сайт Диляры</button>
                <!--                <a href="http://localhost:8080/login">-->
                <!--                    <button type="button" class="btn" data-path="form-popup" >Авторизация</button>-->
                <!--                </a>-->
            </div>
        </div>
    </div>
</form>

<div class="modals">
    <div class="modal-overlay" >
        <div class="modal modal--1" data-target="form-popup" align="center"><br>
            <h3>Зарегистрируйтесь или войдите в аккаунт</h3>
            <br>
            <a href="http://localhost:8080/login" >
                <button type="button" class="btn2" data-path="form-popup" >Авторизация</button>
            </a><br><br>
            <a href="http://localhost:8080/registration">
                <button type="button" class="btn2" data-path="form-popup" >Регистрация</button>
            </a>
        </div>
    </div>
</div>
<script src="../../Jquery/scriptForHome.js"></script>

</body>
</html>
