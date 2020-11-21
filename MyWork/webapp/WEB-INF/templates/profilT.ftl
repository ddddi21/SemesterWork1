<#ftl encoding="utf-8">
<#include "base.ftl" />

<br><br><br>

<!--эту херню хз как сделать Еще макросы не забудь-->
<!--<form method="post" action="/profile">-->

<!-- Do you want to sign out? <input name="logout" type="checkbox"/>-->
<!-- <input type="submit">-->



<#macro content>
    <div class="container">
        <div id="main">

            <div class="row" id="real-estates-detail">
                <div class="col-lg-4 col-md-4 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <header class="panel-title">
                                <div class="text-center">
                                    <h5>Welcome back, ${name} ${lastName}!</h5>
                                </div>
                            </header>
                        </div>
                        <div class="panel-body">
                            <div class="text-center" id="author">
                                <#if imagepath?has_content>
                                    <img src="..${imagepath}" class="m-x-auto img-fluid img-circle" alt="avatar" height="300" width="300">
                                <#else>
                                    <img src="//placehold.it/150" class="m-x-auto img-fluid img-circle" alt="avatar" height="300" width="300">
                                </#if>
                                <h3>${name}</h3>
                                <p class="sosmed-author">
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8 col-xs-12">
                    <div class="panel">
                        <div class="panel-body">
                            <ul id="myTab" class="nav nav-pills">
                                <!--  эти li надо будет переделать тебе на кнопки как хочешь.Класс ток поставь.в листе такие требования были, а в фтл херня какая то-->
                                <#--                            <li class="active"><a href="#detail" data-toggle="tab">О пользователе</a></li>-->
                                <button type="button" class="from__button"><a  href="/homework">Домашнее задание</a></button>
                                <button type="button"  class="from__button"><a href="/hwCreate">Добавить дз</a></button>
                                <button type="button"  class="from__button"><a href="#detail" data-toggle="tab">Сообщение</a></button>
                                <button type="button"  class="from__button"><a href="/logout">Выйти</a></button>
                                <form name="uploadPhoto" class="form-check-inline inputPhotoSize noPadding"
                                      action="/photo"
                                      method="post"
                                      enctype='multipart/form-data'>
                                    <p><input class="inputPhotoBtn" type="file" name="photo" accept="image/*">
                                        <input class="inputPhotoBtn" type="submit" value="Отправить"></p>
                                </form>



                            </ul>
                            <div id="myTabContent" class="tab-content">
                                <hr>
                                <div class="tab-pane fade active in" id="detail">
                                    <h4>Профиль</h4>
                                    <table class="table table-th-block">
                                        <tbody>
                                        <tr><td class="active"><p>Your age:</p></td><td>${age}</td></tr>
                                        <tr><td class="active">You are:</td><td>${role}</td></tr>
                                        <tr><td class="active"><p>Your email:</p></td><td> ${email}</td></tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="tab-pane fade" id="contact">
                                    <p></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div><!-- /.main -->
    </div><!-- /.container -->
</#macro>
<@main title="Profile"/>