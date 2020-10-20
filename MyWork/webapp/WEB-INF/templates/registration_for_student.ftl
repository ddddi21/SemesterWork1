<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
    <title>registration for student</title>
</head>
<body>
<#if message?has_content>
    <p>${message}</p>
</#if>
<form method="post" action="/studentRegistration">
    <p>Please, choose your group</p>
    <p><select name="select_group" multiple>
            <option value="901">901</option>
            <option value="902">902</option>
            <option value="903">903</option>
            <option value="908">908</option>
        </select>
        <input type="submit"></p>

</form>

</body>
</html>