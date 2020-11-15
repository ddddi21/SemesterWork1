<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Форма входа</title>
    <link rel="stylesheet" href="css/RegStyle.css">
</head>
<body>
<#if message?has_content>
    <p>${message}</p>
</#if>
<form class="form" method="post" action="/studentRegistration">

    <h1 class="from__title" align="center">Ученик</h1>
    <p align="center">Выберите группу</p>
    <p align="center"><select name="select_group">
            <option value="901">901</option>
            <option value="902">902</option>
            <option value="903">903</option>
            <option value="904">904</option>
            <option value="905">905</option>
            <option value="906">906</option>
            <option value="907">907</option>
            <option value="908">908</option>
            <option value="909">909</option>
            <option value="910">910</option>
            <option value="911">911</option>
            <option value="912">912</option>
            <option value="913">913</option>
        </select><br>
        <br>
        <input class="from__button" type="submit"></p>

</form>
</body>
</html>