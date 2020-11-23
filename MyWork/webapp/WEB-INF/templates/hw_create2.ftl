<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
</head>
<div class="form_base">
    <form class="form" action="/hwCreate" method="POST">
        <h4 class="from__title">Добавление домашнего задания</h4> <br>
<#--        <div class="input-group mb-3">-->
<#--            <div class="input-group-prepend">-->
<#--                <span class="input-group-text" id="inputGroup-sizing-default">Предмет:</span>-->
<#--            </div><br>-->
<#--            <input name="subject" type="text" class="form__input" placeholder="Что то там" aria-label="Default"-->
<#--                   aria-describedby="inputGroup-sizing-default">-->
<#--        </div>-->
<#--        <br>-->

        <div class="form-group">
            <label for="exampleFormControlTextarea1">Описание:</label>
            <textarea name="text" class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea>
        </div>
        <br>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Дедлайн:</label>
            <input name="deadline" type="date" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">  </div><br>
<#--        <div class="form-group">-->
<#--            <label for="exampleFormControlTextarea1">Группа:</label>-->
<#--            <input name="group" type="number" class="form-control" aria-label="Default"-->
<#--                   aria-describedby="inputGroup-sizing-default">    </div><br>-->
        <button type="submit" class="from__button">Создать</button>
        <p>
            <a href="http://localhost:8080/profile">
                <button type="button" class="from__button">Назад</button>
            </a>
        </p>
    </form>
</div>
