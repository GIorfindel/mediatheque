<%-- 
    Document   : SelectAdresse
    Created on : 24 nov. 2016, 19:11:38
    Author     : glorfindel
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Choisissez une adresse</h3>
<select name="adrId">
    <c:import url="/AdresseList"/>
    <c:set var="adresses" value="${requestScope.adressesList}"/>
    <c:forEach var="adresse" items="${adresses}" varStatus="i">
        <option value=${adresse.getAdresseId()}>${adresse.getAdresseId()}</option>
    </c:forEach>
</select>
<c:choose><c:when test="${sessionScope.errSadr!=null}"><br/>${errSadr}<c:remove var="errSadr"/></c:when><c:otherwise></c:otherwise></c:choose><br/>

