<#ftl encoding="utf-8">
<#include "base.ftl" />

    <#macro content>
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
    </#macro>
    <@main title="Profile"/>
