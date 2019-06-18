<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="css/main.css" rel="stylesheet">
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
          integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
    <title>Main</title>
</head>
<body>

</body>
</html>
<html>
<head>
    <title>$Title$</title>

    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<div class="pure-menu pure-menu-horizontal">
    <ul class="pure-menu-list">
        <li class="pure-menu-item"><a href="/group">Groups</a></li>
        <li class="pure-menu-item"><a href="/student">Students</a></li>
        <li class="pure-menu-item"><a href="/test">Tests</a></li>
        <li class="pure-menu-item"><a href="/subject">Subjects</a></li>
    </ul>
</div>
<h2>Welcome ${cookie.get("username").value}</h2>
</body>
</html>
