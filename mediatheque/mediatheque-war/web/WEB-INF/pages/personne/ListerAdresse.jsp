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
    <c:choose><c:when test="${sessionScope.errAdr!=null}"><br/>${errAdr}<c:remove var="errAdr"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
    <form action="${pageContext.request.contextPath}/SupAdresse" method="post">
        <table     cellpadding=0" cellspacing="0">
            <tr>
                <th>Id</th>
                <th>Pays</th>
                <th>Ville</th>
                <th>Rue</th>
                <th>Numéro</th>
            </tr>
            <c:forEach var="adresse" items="${adresses}" varStatus="i">
                <tr>
                    <td>${adresse.getAdresseId()}</td>
                    <td align="right">${adresse.getPays()}</td>
                    <td>${adresse.getVille()}</td>
                    <td>${adresse.getRue()}</td>
                    <td>${adresse.getNumero()}</td>
                    <td><button type="submit" name="adrId" value=${adresse.getAdresseId()}>Supprimer</button>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>
        <h5>Ajouter une adresse: </h5>
        <form action="${pageContext.request.contextPath}/AjoutAdresse" method="post">
            <jsp:include page="/WEB-INF/pages/personne/AjoutAdresse.jsp"/>
            <input type='submit'><br/>
        </form>
    </div>
</div>