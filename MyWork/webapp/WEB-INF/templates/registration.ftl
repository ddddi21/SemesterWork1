<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
    <meta charset="UTF-8">
    <title>registration</title>
</head>
<body>
<#if message?has_content>
    <p>${message}</p>
</#if>
<form method="post" action="/registration">
    <label>Let's do registration</label> <br>
    <p><b>Кем вы являетесь?</b></p>
    <p><input name="role" type="radio" value="student"> Ученик</p>
    <p><input name="role" type="radio" value="teacher"> Преподаватель</p>
    <input type="text" name="first_name" placeholder="enter first_name"/>
    <input type="text" name="last_name" placeholder="enter last_name"/>
    <input type="number" name="age" placeholder="enter age"/>
<#--    TODO(установить ограничение на возраст)-->
    <input type="password" name="password" placeholder="enter password"/>
    <input type="email" name="email" placeholder="enter email"/>
    <input type="submit">
</form>

</body>
</html>