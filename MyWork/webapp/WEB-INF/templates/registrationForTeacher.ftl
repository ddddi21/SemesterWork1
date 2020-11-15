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
<form class="form" method="post" action="/teacherRegistration">

 <h1 class="from__title" align="center">Преподаватель</h1>
<#-- <p><select name="select_subject">-->
<#--  <option value="Maths">Математика</option>-->
<#--  <option value="English">Английский</option>-->
<#--  <option value="IT">IT</option>-->
<#--  <option value="Geography">География</option>-->
<#-- </select>-->
 <p>Выберите группу</p>
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
  <input class="form__button" type="submit"></p> <br>

   <p>Выберте предмет</p>
    <p><select multiple size="4" name="select_subject">
            <option value="Maths">Математика</option>
          <option value="English">Английский</option>
           <option value="IT">IT</option>
           <option value="Geography">География</option>
        </select>
       <input class="form__button" type="submit"></p>

 <p align="center">
  <button class="from__button">Вход</button>
 </p>
</form>
</body>
</html>