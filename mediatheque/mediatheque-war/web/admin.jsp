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
        <jsp:include page="/WEB-INF/pages/bibliothecaire/AjoutBibliothecaire.jsp"/>
        <jsp:include page="/WEB-INF/pages/personne/ListerAdresse.jsp"/>
        <jsp:include page="/WEB-INF/pages/bibliothecaire/ListeBibliothecaire.jsp"/>
        <jsp:include page="/WEB-INF/pages/bibliothecaire/SelectBibliothecaire.jsp"/>
    </body>
</html>
