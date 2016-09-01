<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>

<div id="content" role="main">
    <g:if test="${message}">
        <div>${message}</div>
    </g:if>
    Upload Form: <br />
    <g:uploadForm controller="upload" action="upload">
        <input type="file" name="archivo" />
        <input type="submit" />
    </g:uploadForm>
</div>

</body>
</html>
