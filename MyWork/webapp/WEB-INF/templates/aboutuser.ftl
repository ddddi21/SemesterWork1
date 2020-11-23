<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ru" xmlns:margin-top="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Редактирование</title>
    <link rel="stylesheet" href="css/RegStyle.css"></head>
<body>

<form class="form" method="post" action="/editUser">
    <h1 class="from__title">Редактирование</h1>

    <div class="form__group">
        <input class="form__input" type="text" name="name" placeholder="Измените имя"/>
    </div>
    <div class="form__group">
        <input class="form__input" type="text" name="lastName" placeholder="Измените фамилию"/>
    </div>
    <input type="submit" class="from__button" value="Готово">
</form>

</body>
</html>