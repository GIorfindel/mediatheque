<%-- 
    Document   : ListerAdresse
    Created on : 24 nov. 2016, 18:15:20
    Author     : glorfindel
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ligne">
    <h3>Liste  des  adresses </h3>
    <c:import url="/AdresseList"/>
    <c:set var="adresses" value="${requestScope.adressesList}"/>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr bgcolor="#cccccc">
            <td>Id</td>
            <td>Pays</td>
            <td>Ville</td>
            <td>Rue</td>
            <td>Numéro</td>
        </tr>
        <c:forEach var="adresse" items="${adresses}" varStatus="i">
            <tr>
                <td>${adresse.getAdresseId()}</td>
                <td align="right">${adresse.getPays()}</td>
                <td>${adresse.getVille()}</td>
                <td>${adresse.getRue()}</td>
                <td>${adresse.getNumero()}</td>
            </tr>
        </c:forEach>
    </table>
    <h5>Ajouter une adresse: </h5>
    <form action="${pageContext.request.contextPath}/AjoutAdresse" method="post">
        <jsp:include page="/WEB-INF/pages/personne/AjoutAdresse.jsp"/>
        <input type='submit'><br/>
    </form>
</div>