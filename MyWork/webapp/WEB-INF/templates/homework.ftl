<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ru">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="assets/css/modal.css">
    <link rel="stylesheet" href="modal.css">
    <title>Homework page</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $.ajax({
            url : "/getHw",
            type : "GET",
            async : false,
            success : function(data) {
                let rootEl = document.getElementById("list");
                let postList = data.split('!');
                postList.forEach(function(item, i, arr) {
                    let postItem = item.split('#')
                    if(postItem.length > 1) {
                        let el = document.createElement("div")
                        el.innerHTML =  '<div class="card mb-4"> ' +
                            '<img class="card-img-top" ' +
                            'src="..'+ postItem[2] +'" ' +
                            'alt="Card image cap"> <div class="card-body"> ' +
                            '<h2 class="card-title">'+ postItem[0] +'</h2> ' +
                            '<p class="card-text">'+ postItem[1] +'</p> ' +
                            '</div> <div class="card-footer text-muted"> Posted by <a href="/user?user_id='+ postItem[3] + '">'+ postItem[4] +'</a> </div> </div>'
                        rootEl.appendChild(el);
                    }
                });
            }
        });
    })
</script>
<div>
    <ul id="list" class="list-group listSize">

    </ul>
</div>