<%-- 
    Document   : gestionAdherent
    Created on : 5 déc. 2016, 23:17:48
    Author     : glorfindel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Gestion des adhérents</title>
    </head>
    <body>
        <ul id="menu">
            <li class="limenu"><a href="admin.jsp">Admin</a></li>
            <li class="limenu"><a class="active" href="gestionAdherent.jsp">Gestion adhérents</a></li>
            <li class="limenu"><a href="#contact">Contact</a></li>
            <li class="limenu"><a href="#about">About</a></li>
        </ul>
        <jsp:include page="/WEB-INF/pages/adherents/AjoutAdherent.jsp"/>
        <jsp:include page="/WEB-INF/pages/adherents/ListerAdherents.jsp"/>
        <jsp:include page="/WEB-INF/pages/personne/ListerAdresse.jsp"/>
    </body>
</html>

