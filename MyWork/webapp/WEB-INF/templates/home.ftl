<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="assets/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat:400,700&amp;subset=cyrillic-ext" rel="stylesheet">
    <title>Home page</title>
</head>
<style>
    body {
        margin: 0;
        font-family: 'Montserrat', sans-serif;
        background-image: url("../../images/1.jpg");
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

    /* Button */
    .btn {
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

    .btn:hover {
        background-color: #fff;
        color: #333;
    }




</style>
    <body class="intro">
<form method="post" action="/home"><br>
    <header class="header">
        <div class="container">
        </div>
    </header>


    <div class="intro">
        <div class="container">
            <div class="intro__inner">
                <h1 class="intro__title">Добро пожаловать!</h1>
                <a href="http://localhost:8080/registration">
                    <button type="button" class="btn" >Регистрация</button>
                </a>
                <a href="http://localhost:8080/login">
                    <button type="button" class="btn" >Авторизация</button>
                </a>
            </div>
        </div>
    </div>

</form>
</body>
</html>
