<#ftl encoding="utf-8">
<#include "base.ftl" />
<!DOCTYPE html>
<html lang="en">
<#macro content>
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
                        <a class="nav-link" href="/profile">Профиль<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/homework">Просмотр д\з<span class="sr-only">(current)</span></a>
                    </li>
                    <#if role=="teacher">
                        <li class="nav-item">
                            <a class="nav-link" href="/hwCreate">Добавить д\з<span class="sr-only">(current)</span></a>
                        </li>
                    </#if>
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
<div class="container">
    <div id="main">
        <div class="row" id="real-estates-detail">
            <div class="col-lg-4 col-md-4 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <header class="panel-title">
                            <div class="text-center">
                                <h5>${name} ${lastName}</h5>
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
                            <!--                        <#&#45;&#45;                            <li class="active"><a href="#detail" data-toggle="tab">О пользователе</a></li>&ndash;&gt;-->
                            <!--                        <button type="button" class="from__button"><a  href="/homework">Домашнее задание</a></button>-->
                            <!--                        <button type="button"  class="from__button"><a href="/hwCreate">Добавить дз</a></button>-->
                            <!--                        <button type="button"  class="from__button"><a href="#detail" data-toggle="tab">Сообщение</a></button>-->
                            <!--                        <button type="button"  class="from__button"><a href="/logout">Выйти</a></button>-->

                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <hr>
                            <div class="tab-pane fade active in" id="detail">
                                <h4>Профиль</h4>
                                <table class="table table-th-block">
                                    <tbody>
                                    <tr><td class="active"><p>Age:</p></td><td>${age}</td></tr>
                                    <tr><td class="active">Role:</td><td>${role}</td></tr>
                                    <tr><td class="active"><p>Email:</p></td><td> ${email}</td></tr>
                                    </tbody>
                                </table>
                            </div>
                            <#if owner>
                            <form name="uploadPhoto" class="form-check-inline inputPhotoSize noPadding"
                                  action="/photo"
                                  method="post"
                                  enctype='multipart/form-data'>
                                <p><input class="button3" type="file" name="photo" accept="image/*"><br>
                                    <input class="button2" type="submit" value="Отправить"></p>
                            </form>
                            <button type="button" class="btn"><a href="/editUser">Редактировать</a></button>
                            </#if>
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
</html>
</#macro>
<@main title="Profile"/>