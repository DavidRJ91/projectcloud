<!DOCTYPE html>
<html lang="en">
<head>
    <title>Restaurantes</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.min.css" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <style>
        table, th, td {
            border: 2px solid black;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class= "navbar-brand" href="/"><img src="https://png.icons8.com/ios/50/ffffff/salt-bae.png"> Restaurantes</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Inicio <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="https://github.com/DavidRJ91">Quiénes somos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://www.iesemilidarder.com/web">Contacto</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" style="color: crimson" href="/rest/api/v1/restaurants">API REST</a>
            </li>

        </ul>

        </div>
    </div>
</nav>

<main role="main">
    <div class="container">
        <font color="black" face="Fantasy">
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <h4 class="display-4" align="center">Restaurantes en Mallorca</h4>
            <h4 class="display-5" align="center">Encuentra los mejores restaurantes de Palma de Mallorca</h4>
        </font>
<div class="row">
<#if model??>
    <div class="row center mt-1">
        <#list model["list"] as item>
            <div align="center" class="col-sm-4"/>
                <br>
                <br>
                <div align="center">
                    <img class="align-self-start mr-1 rounded-circle"
                    <img src="${item.imagen!""}" width="340" height="240"/>
                </div>
                <div>
                    <br>
                    <div>
                        <table>
                            <tr>
                                <td><p><b>Codigo de restaurante: </b>${item.codigo!""}</p></td>
                            </tr>
                            <tr>
                                <td><p><b>Restaurante:</b></p><p>${item.nombre!""}</p></td>
                            </tr>
                            <tr>
                                <td><p><b>Direccion:</b></p><p>${item.direccion!""}</p></td>
                            </tr>
                             <tr>
                                <td><p><b>Pagina Web:</b></p><p>${item.web!""}</p></td>
                             </tr>
                            <tr>
                                <td><p><b>Telefono:</b></p> <p>${item.telefono!""}</p></td>
                             </tr>
                        </table>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</#if>
</div>
</div>
</main>


</body>
</html>