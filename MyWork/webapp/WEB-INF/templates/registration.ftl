<#ftl encoding="utf-8">
<#--<#include "base.ftl"/>-->

<#--<#macro content>-->
<!DOCTYPE html>
<html lang="ru" xmlns:margin-top="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link rel="stylesheet" href="css/RegStyle.css">
</head>

<body>
<#if message?has_content>
    <p>${message}</p>
</#if>
<#if errors??>
    <#list errors as g>
        <p>${g}</p>
        <hr>
    </#list>
<#else>
</#if>
<form class="form" method="post" action="/registration">
    <h1 class="from__title">Регистрация</h1>
    <h3>Кто вы?</h3>
    <p><input name="role" type="radio" value="student"> Ученик</p>
    <br>
    <p margin-top: 20%><input name="role" type="radio" value="teacher"> Преподаватель</p>
    <div class="form__group">
        <p margin-top: 20%>
            <input class="form__input" type="email" name="email" placeholder="Введите почту"/>
        </p>
    </div>
    <div class="form__group">
        <input class="form__input" type="password" name="password" placeholder="Введите пароль"/>
    </div>
    <div class="form__group">
        <input class="form__input" type="text" name="first_name" placeholder="Введите имя"/>
    </div>
    <div class="form__group">
        <input class="form__input" type="text" name="last_name" placeholder="Введите фамилию"/>
    </div>
    <div class="form__group">
        <input class="form__input" type="number" name="age" placeholder="Введите возраст"/>
    </div>
    <input type="submit" class="from__button" value="Зарегистрироваться">
    <p margin-top: 20%>
        <a href="http://localhost:8080/home">
            <button type="button" class="from__button">Назад</button>
        </a>
    </p>
</form>

</body>
</html>
<#--</#macro>-->
<#--<#macro title>-->
<#--    <title>Registration</title>-->
<#--</#macro>-->
<#--<@display_page />-->