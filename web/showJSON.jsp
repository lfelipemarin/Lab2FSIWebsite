
<%-- 
    Document   : showJSON.jsp
    Created on : Apr 25, 2015, 12:05:13 PM
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script>
            $(document).ready(function () {
                var trHTML = '';
                $.getJSON("http://localhost:8080/WebSite/webresources/json/getWebs/getFeeds", function (result) {
                    $.each(result, function (i, item) {
                        trHTML += '<tr><td>' + item.id + '</td><td>' + item.title + '</td><td>' + item.description + '</td><td>' + item.url + '</td></tr>';
                    });
                    $('#records_table').append(trHTML);
                });
                // process the form
                $('#form').submit(function (event) {

                    // get the form data
                    // there are many ways to get this data using jQuery (you can use the class or id also)
                    var formData = $('#form').serialize();

                    // process the form
                    $.ajax({
                        type: 'PUT', // define the type of HTTP verb we want to use (POST for our form)
                        url: 'http://localhost:8080/WebSite/webresources/json/getWebs/insertWeb', // the url where we want to POST
                        contentType: "application/json",
                        data: formData, // our data object
                        dataType: 'json' // what type of data do we expect back from the server
                    })
                            // using the done promise callback
                            .done(function (data) {

                                // log data to the console so we can see
                                console.log(data);

                                // here we will handle errors and validation messages
                            });

                    // stop the form from submitting the normal way and refreshing the page
                    event.preventDefault();
                });
            });
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Paginas Web de Interes</h1>
        <div></div>
        <table id="records_table" border='1'>
            <tr>
                <th>ID</th>
                <th>Titulo</th>
                <th>Descripcion</th>
                <th>URL</th>
            </tr>
        </table>
        </br>
        </br>
        </br>
        <div style="
             border: 1px solid;
             display: inline-block;
             border-radius: 5px;
             overflow: hidden;
             background-color: lightblue;
             padding-left: 5px;
             box-shadow: #959595 0 2px 5px;
             text-align: center;
             ">
            <h1>Nueva Pagina de Interes</h1>
            <form id="form" method="POST" action="http://localhost:8080/WebSite/webresources/json/getWebs/insertWeb" enctype="application/json">
                <div style="
                     float: left;
                     overflow: hidden;
                     text-align: left;
                     ">
                    <table border="0">
                        <tr>
                            <td><b>ID: </b></td>
                            <td>
                                <input type="number" name="id" class="form-control" placeholder="id"size="50"/></td>
                        </tr>
                        <tr>
                            <td><b>Titulo: </b></td>
                            <td>
                                <input type="text" name="titulo" class="form-control" placeholder="Titulo"size="50"/></td>
                        </tr>
                        <tr>
                            <td><b>Descripcion: </b></td>
                            <td>
                                <input type="text" name="descrip" class="form-control" placeholder="Descripcion"size="50"/></td>
                        </tr>
                        <tr>
                            <td><b>URL: </b></td>
                            <td>
                                <input type="text" name="url" class="form-control" placeholder="URL"size="50"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <br>
                                <input class="btn btn-primary btn-block" type="submit" value="Enviar">
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
    </table>
</body>
</html>
