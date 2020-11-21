<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<div class="form_base">
<form action="/hwCreate"
      method="POST"
      >

    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="inputGroup-sizing-default">Subject:</span>
        </div>
        <input name="subject" type="text" class="form-control" aria-label="Default"
               aria-describedby="inputGroup-sizing-default">
    </div>

    <div class="form-group">
        <label for="exampleFormControlTextarea1">Text:</label>
        <textarea name="text" class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea>
    </div>
    <br>
    <div class="form-group">
        <label for="exampleFormControlTextarea1">Deadline:</label>
        <input name="deadline" type="date" class="form-control" aria-label="Default"
               aria-describedby="inputGroup-sizing-default">    </div>
    <div class="form-group">
        <label for="exampleFormControlTextarea1">Group:</label>
        <input name="group" type="number" class="form-control" aria-label="Default"
               aria-describedby="inputGroup-sizing-default">    </div>
    <button type="submit" class="btn btn-success">Создать</button>
</form>
    </div>