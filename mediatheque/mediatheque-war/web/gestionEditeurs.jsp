<%-- 
    Document   : gestionEditeurs
    Created on : 7 déc. 2016, 14:18:30
    Author     : florian
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Gestion des éditeurs</title>
    </head>
    <body>
        <ul id="menu">
            <li class="limenu"><a href="admin.jsp">Admin</a></li>
            <li class="limenu"><a href="gestionAdherent.jsp">Gestion adhérents</a></li>
            <li class="limenu"><a href="gestionMedias.jsp">Gestion médias</a></li>
            <li class="limenu"><a href="gestionAuteurs.jsp">Gestion des auteurs</a></li>
            <li class="limenu"><a class="active" href="gestionEditeurs.jsp">Gestion des éditeurs</a></li>
            <li class="limenu"><a href="gestionEmprunts.jsp">Gestion des emprunts</a></li>
        </ul>
        <jsp:include page="/WEB-INF/pages/editeurs/ajoutEditeur.jsp"/>
        <jsp:include page="/WEB-INF/pages/editeurs/ListerEditeur.jsp"/>
        <jsp:include page="/WEB-INF/pages/personne/ListerAdresse.jsp"/>
    </body>
</html>
