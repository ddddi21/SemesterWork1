<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="en">
<#macro main title>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="css/profilStyle.css">
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <script src="https://bootstraptema.ru/plugins/2015/b-v3-3-6/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            let $result = $("search_box-result")
            let rootEl = document.getElementById("search_box-result");
            $('#search').on('keyup', function () {
                rootEl.innerHTML = ""
                var search = $(this).val();
                if ((search !== '') && (search.length > 1)) {
                    $.ajax({
                        type: "POST",
                        url: "/ajax_search",
                        data: {'search': search},
                        success: function (msg) {
                            if (msg !== " ") {
                                msg = msg.replace(/\n/ig, '');
                                $result.fadeIn();
                                let msgList = msg.split('!');
                                msgList.forEach(function (item, i, arr) {
                                    let itemMas = item.split('#')
                                    if (itemMas.length > 1) {
                                        let el = document.createElement("div");
                                        el.innerHTML =
                                            "<div class=\"search_result\"><table><tr><td class=\"search_result-name\">" + itemMas[0] + ' ' + itemMas[1] + '<p>' + itemMas[2]+'</p>'+ "</a></td><td class=\"search_result-btn\"><a href=\"/user?user_id="+ itemMas[3] + "\">Перейти</a></td> </tr> </table> </div>"
                                        rootEl.appendChild(el);
                                    }
                                });
                            } else {
                                rootEl.innerHTML = ""
                                $result.fadeOut(100);
                            }
                        }
                    })
                } else {
                    $result.html('');
                    rootEl.innerHTML = ""
                    $result.fadeOut(100);
                }
            });
        })

    </script>
</head>
<#--<#if isLogged>-->
<#--    <header>-->
<#--        <nav class="navbar navbar-expand-lg navbar-light bg-header">-->
<#--            <div class="collapse navbar-collapse" id="navbarSupportedContent">-->
<#--                <ul class="navbar-nav mr-auto">-->
<#--                    <li class="nav-item active ">-->
<#--                        <a name="element" class="nav-link font-italic" href="/profile"> Profile <span class="sr-only">(current)</span></a>-->
<#--                    </li>-->
<#--                    <li class="nav-item active ">-->
<#--                        <a name="element" class="nav-link font-italic" href="/home"> Home <span class="sr-only">(current)</span></a>-->
<#--                    </li>-->
<#--                    <li class="nav-item active">-->
<#--                        <a name="element" class="nav-link font-italic" href="/news">News <span-->
<#--                                    class="sr-only">(current)</span></a>-->
<#--                    </li>-->
<#--                    <li class="nav-item active">-->
<#--                        <a name="element" class="nav-link font-italic" href="/chat">Chat <span-->
<#--                                    class="sr-only">(current)</span></a>-->
<#--                    </li>-->
<#--                    <li class="nav-item active">-->
<#--                        <a name="element" class="nav-link font-italic" href="/post">Posts <span class="sr-only">(current)</span></a>-->
<#--                    </li>-->

<#--                </ul>-->
<#--            </div>-->
<#--        </nav>-->
<#--    </header>-->
<#--    <div class="search_box">-->
<#--        <form autocomplete="off">-->
<#--            <input type="text" name="search" id="search" placeholder="Введите имя пользователя">-->
<#--            <input type="submit">-->
<#--        </form>-->
<#--        <div id="search_box-result"></div>-->
<#--    </div>-->
<#--<#else>-->
<#--    <header>-->
<#--        <nav class="navbar navbar-expand-lg navbar-light bg-header">-->
<#--            <div class="collapse navbar-collapse" id="navbarSupportedContent">-->
<#--                <ul class="navbar-nav mr-auto">-->
<#--                    <li class="nav-item active ">-->
<#--                        <a name="element" class="nav-link font-italic" href="/login">-->
<#--                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-people" fill="currentColor"-->
<#--                                 xmlns="http://www.w3.org/2000/svg">-->
<#--                                <path fill-rule="evenodd"-->
<#--                                      d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1h7.956a.274.274 0 0 0 .014-.002l.008-.002c-.002-.264-.167-1.03-.76-1.72C13.688 10.629 12.718 10 11 10c-1.717 0-2.687.63-3.24 1.276-.593.69-.759 1.457-.76 1.72a1.05 1.05 0 0 0 .022.004zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10c-1.668.02-2.615.64-3.16 1.276C1.163 11.97 1 12.739 1 13h3c0-1.045.323-2.086.92-3zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z"/>-->
<#--                            </svg>-->
<#--                            Login <span class="sr-only">(current)</span></a>-->
<#--                    </li>-->
<#--                    <li class="nav-item active">-->
<#--                        <a name="element" class="nav-link font-italic" href="/register">Join Us <span class="sr-only">(current)</span></a>-->
<#--                    </li>-->
<#--                    <li class="nav-item active ">-->
<#--                        <a name="element" class="nav-link font-italic" href="/main"> Main <span class="sr-only">(current)</span></a>-->
<#--                    </li>-->
<#--                    <li class="nav-item active">-->
<#--                        <a name="element" class="nav-link font-italic" href="/news">News <span-->
<#--                                    class="sr-only">(current)</span></a>-->
<#--                    </li>-->
<#--                    <li class="nav-item active">-->
<#--                        <a name="element" class="nav-link font-italic" href="/post">Posts <span class="sr-only">(current)</span></a>-->
<#--                    </li>-->
<#--                </ul>-->
<#--            </div>-->
<#--        </nav>-->
<#--    </header>-->
<#--</#if>-->
    <body><@content/></body>
<body id="main">
</#macro>