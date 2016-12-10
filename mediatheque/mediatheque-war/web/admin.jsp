<%-- 
    Document   : admin
    Created on : 24 nov. 2016, 15:43:50
    Author     : glorfindel
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Administration</title>
    </head>
    <body>
        <ul id="menu">
            <li class="limenu"><a class="active" href="admin.jsp">Admin</a></li>
            <li class="limenu"><a href="gestionAdherent.jsp">Gestion adhérents</a></li>
            <li class="limenu"><a href="gestionMedias.jsp">Gestion médias</a></li>
            <li class="limenu"><a href="gestionAuteurs.jsp">Gestion des auteurs</a></li>
            <li class="limenu"><a href="gestionEditeurs.jsp">Gestion des éditeurs</a></li>
            <li class="limenu"><a href="gestionEmprunts.jsp">Gestion des emprunts</a></li>
        </ul>
        <jsp:include page="/WEB-INF/pages/bibliothecaire/AjoutBibliothecaire.jsp"/>
        <jsp:include page="/WEB-INF/pages/bibliothecaire/ListeBibliothecaire.jsp"/>
        <jsp:include page="/WEB-INF/pages/personne/ListerAdresse.jsp"/>
        <jsp:include page="/WEB-INF/pages/footer.jsp"/>
    </body>
</html>
