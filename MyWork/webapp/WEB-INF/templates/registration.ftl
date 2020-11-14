<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ru" xmlns:margin-top="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link rel="stylesheet" href="css/style.css">
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
<form class="form" method="post" action="/registration">
    <h1 class="from__title">Регистрация</h1>
    <h3>Кто вы?</h3>
    <p><input name="role" type="radio" value="student"> Ученик</p>
    <br>
    <p margin-top: 20%><input name="role" type="radio" value="teacher"> Преподаватель</p>
    <div class="form__group">
        <p margin-top: 20%>
            <input class="form__input" type="email" name="email" placeholder="enter email"/>
        </p>
    </div>
    <div class="form__group">
        <input class="form__input" type="password" name="password" placeholder="enter password"/>
    </div>
    <div class="form__group">
        <input class="form__input" type="text" name="first_name" placeholder="enter first_name"/>
    </div>
    <div class="form__group">
        <input class="form__input" type="text" name="last_name" placeholder="enter last_name"/>
    </div>
    <div class="form__group">
        <input class="form__input" type="number" name="age" placeholder="enter age"/>
    </div>
    <input type="submit" class="from__button" value="Зарегистрироваться">
</form>

</body>
</html>