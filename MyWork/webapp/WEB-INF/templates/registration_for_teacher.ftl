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
<form method="post" action="/teacherRegistration">
    <label>Let's do registration</label> <br>
    <p>Please, choose your subjects</p>
    <p><select name="select_subject">
            <option value="Maths">Maths</option>
            <option value="English">English</option>
            <option value="IT">IT</option>
            <option value="Geography">Geography</option>
        </select>
    <p>Choose your groups</p>
    <p><select name="select_group">
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
        </select>
    <#--            TODO(add custom choosing for group (адин) в бутстрапе например)-->
        <input type="submit"></p> <br>

<#--    <p>Please, choose your groups</p>-->
<#--    <p><select multiple size="4" name="select_subject">-->
<#--            <option value="Maths">Maths</option>-->
<#--            <option value="English">English</option>-->
<#--            <option value="IT">IT</option>-->
<#--            <option value="Geography">Geography</option>-->
<#--        </select>-->
<#--        <input type="submit"></p>-->
<#--    -->

</form>

</body>
</html>