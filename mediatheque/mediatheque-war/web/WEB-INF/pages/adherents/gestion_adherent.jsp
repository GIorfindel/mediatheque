<%-- 
    Document   : gestion_adherent
    Created on : 24 nov. 2016, 14:50:57
    Author     : glorfindel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion des adhérents</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/pages/menu.jsp"/>
        <jsp:include page="/WEB-INF/pages/adherents/AjoutAdherent.jsp"/>
        <jsp:include page="/WEB-INF/pages/adherents/ListeAdherent.jsp"/>
    </body>
</html>
