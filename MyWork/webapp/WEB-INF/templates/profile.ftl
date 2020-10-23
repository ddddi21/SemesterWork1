<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${name}!</title>
</head>
<body>
<h2>Welcome back, ${name} ${lastName}! You are ${role}</h2>
<br>
<p>Your email: ${email}</p>
<p>Your age: ${age}</p>
<br>
<p>How are you?</p><br><br><br>
<form method="post" action="/profile">

    Do you want to sign out? <input name="logout" type="checkbox"/>
    <input type="submit">
</form>
<#--<p>What do you want to do?</p>-->
<#--<p style="text-align: left"><button>change your name</button>-->
<#--    <button>change password</button>-->
<#--    <button>change</button>-->

</body>
</html>