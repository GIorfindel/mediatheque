<%-- 
    Document   : gestionMedias
    Created on : 6 déc. 2016, 21:57:02
    Author     : florian
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Gestion des médias</title>
    </head>
    <body>
        <ul id="menu">
            <li class="limenu"><a href="admin.jsp">Admin</a></li>
            <li class="limenu"><a href="gestionAdherent.jsp">Gestion adhérents</a></li>
            <li class="limenu"><a class="active" href="gestionMedias.jsp">Gestion médias</a></li>
            <li class="limenu"><a href="gestionAuteurs.jsp">Gestion des auteurs</a></li>
        </ul>
        <jsp:include page="/WEB-INF/pages/media/AjoutMedia.jsp"/>
        <jsp:include page="/WEB-INF/pages/media/ListeMedia.jsp"/>
    </body>
</html>