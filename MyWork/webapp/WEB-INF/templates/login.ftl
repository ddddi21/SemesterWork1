<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="en">
<head>
<#--    <meta charset="UTF-8">-->
    <title>login</title>
</head>
<body>
<#if message?has_content>
    <p>${message}</p>
</#if>
<form method="post" action="/login">
    <label>Welcome</label> <br>
    <p>Please sign in</p>
    <input type="email" name="email" placeholder="enter email"/>
    <input type="password" name="password" placeholder="enter password"/>
    <input type="submit">
</form>

</body>
</html>