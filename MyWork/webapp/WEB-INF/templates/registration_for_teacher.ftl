<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
    <title>registration for teacher</title>
</head>
<body>
<#if message?has_content>
    <p>${message}</p>
</#if>
<form method="post" action="/registration_for_teacher">
    <label>Let's do registration</label> <br>
    <p>Please, choose your subjects</p>
    <p><select  name="select_subject" multiple>
<#--            TODO(add multi choosing)-->
            <option value="Maths">Maths</option>
            <option value="English">English</option>
            <option value="IT">IT</option>
            <option value="Geography">Geography</option>
        </select>
        <input type="submit"></p>

</form>

</body>
</html>