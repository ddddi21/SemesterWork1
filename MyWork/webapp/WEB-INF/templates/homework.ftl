<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ru">
<html xmlns="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="style2.css">
    <script src="../templates/ajax.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        @media only screen and (min-width: 768px) {
            .dropdown:hover .dropdown-menu {
                display: block;
                margin-top: 0;
            }
        }

    </style>
    <title>Homework page</title>

    <script>
        $('.dropdown-toggle').click(function(e) {
            if ($(document).width() > 768) {
                e.preventDefault();
                var url = $(this).attr('href');
                if (url !== '#') {
                    window.location.href = url;
                }
            }
        });
    </script>
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
                            el.innerHTML =  '<div class ="container center">'+'<div class="card">' +
                               ' <div class="card-header"> ' +
                                '<h5 class="card-title">'+ postItem[0] +'</h5> ' + '<hr>' + '</div>'+
                                    '<div class="card-body">'+
                                '<p class="card-text">'+ postItem[1] +'</p> ' +'<hr>'+
                                '<div class="card-footer text-muted">' +
                                '<p class="card-text"> Deadline: '+ postItem[2] + '</p> </div> </div> </div>'
                            rootEl.appendChild(el);
                        }
                    });
                }
            });
        })
    </script>
</head>
<nav class="navbar navbar-default" a>
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"></a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/home">Главная страница<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/profile">Профиль<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/homework">Просмотр д\з<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Выйти<span class="sr-only">(current)</span></a>
                </li>
                <div class="search_box">
                            <form autocomplete="off" class="navbar-form navbar-left">
                                <div class="form-group">
                                <input type="text" class="form-control" name="search" id="search" placeholder="Введите имя пользователя">
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                            <div id="search_box-result"></div>
                        </div>

                <!--                <li class="dropdown">-->
                <!--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>-->
                <!--                    <ul class="dropdown-menu">-->
                <!--                        <li><a href="#">Action</a></li>-->
                <!--                        <li><a href="#">Another action</a></li>-->
                <!--                        <li><a href="#">Something else here</a></li>-->
                <!--                        <li role="separator" class="divider"></li>-->
                <!--                        <li><a href="#">Separated link</a></li>-->
                <!--                        <li><a href="#">One more separated link</a></li>-->
                <!--                    </ul>-->
                <!--                </li>-->
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
    <!--/.container-fluid -->
</nav>
<!--/.navbar -->
<body>
<#--<div class="container center">-->
<#--    <div class="card">-->
<#--        <div class="card-header">-->
<#--            <h5 class="card-title" align="center">Предмет</h5>-->
<#--            <hr>-->
<#--        </div>-->
<#--        <div class="card-body">-->
<#--            <p class="card-text">Текст для дз</p>-->
<#--        </div>-->
<#--        <hr>-->
<#--        <div class="card-footer">-->
<#--            <p class="card-text">Deadline:</p>-->
<#--        </div>-->
<#--    </div>-->
<#--</div>-->
<!--        <h2 align="center">Предмет</h2>-->
<!--        <hr/>-->
<!--        -->
<!--        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.-->
<!--        </p>-->
<!--        -->
<!--        <p>Deadline</p>-->
</body>

<div>
    <ul id="list" class="list-group listSize">

    </ul>
</div>
