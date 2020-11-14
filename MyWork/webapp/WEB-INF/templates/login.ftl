<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ru" xmlns:margin-top="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="css/style.css">
        <meta charset="UTF-8">
    <title>login</title>
</head>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form {
        width: 300px;
        padding: 32px;
        border-radius: 10px;
        box-shadow: 0 4px 16px #ccc;
        font-family: sans-serif;
        letter-spacing: 1px;
    }

    .form__input,
    .form__button {
        font-family: sans-serif;
        letter-spacing: 1px;
        font-size: 16px;
    }

    .form__title {
        text-align: center;
        margin: 0 0 32px 0;
        font-weight: normal;
    }

    .form__group {
        position: relative;
        margin-bottom: 32px;
    }
    .form__label {
        position: absolute;
        top: 0;
        left: 0;
        z-index: -1;
        color: #9e9e9e;
        transition: 0.3s;
    }

    .form__input {
        width: 100%;
        padding: 0 0 10px 0;
        border: none;
        border-bottom: 1px solid #e0e0e0;
        background-color: transparent;
        outline: none;
        transition: 0.3s;
    }

    .form__input:focus {
        border-bottom: 1px solid #1a73a8;
    }

    .from__button {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        color: #fff;
        background-color: #0071f0;
        outline: none;
        cursor: pointer;
        transition: 0.3s;
    }

    .form__button:focus,
    .form__button:hover {
        background-color: rgba(0, 113, 240, 0.7);
    }

    .form__input:focus ~ .form__label,
    .form__input:not(:placeholder-shown) ~ .form__label {
        top: -18px;
        font-size: 12px;
        color: #e0e0e0;
    }
</style>
<body>
<#if message?has_content>
    <p>${message}</p>
</#if>
<form class="form" method="post" action="/login">
    <h1 class="from__title">Вход</h1> <br>
    <div class="form__group">
        <input class="form__input" name="email" type="email" placeholder="Email">
    </div>
    <div class="form__group">
        <input class="form__input" name="password" type="password" placeholder="Password">
    </div>
    <input type="submit" class="from__button" value="Войти">
    <input type="checkbox" class="checkbox" name = "remember" id="checkbox" />
    <label for="checkbox">Запомнить меня?</label>
    <p margin-top: 20%>
        <a href="http://localhost:8080/registration">
        <button type="button" class="from__button">Регистрация</button>
        </a>
    </p>
</form>
</body>
</html>