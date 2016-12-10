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
            <li class="limenu"><a href="gestionMedias.jsp">Gestion médias</a></li>
            <li class="limenu"><a href="gestionAuteurs.jsp">Gestion des auteurs</a></li>
            <li class="limenu"><a href="gestionEditeurs.jsp">Gestion des éditeurs</a></li>
            <li class="limenu"><a href="gestionEmprunts.jsp">Gestion des emprunts</a></li>
        </ul>
        <jsp:include page="/WEB-INF/pages/adherents/AjoutAdherent.jsp"/>
        <jsp:include page="/WEB-INF/pages/adherents/ListerAdherents.jsp"/>
        <jsp:include page="/WEB-INF/pages/personne/ListerAdresse.jsp"/>
        <jsp:include page="/WEB-INF/pages/footer.jsp"/>
    </body>
</html>

