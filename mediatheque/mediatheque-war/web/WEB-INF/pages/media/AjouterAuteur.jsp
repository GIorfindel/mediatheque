<%-- 
    Document   : AjouterAuteur
    Created on : 9 déc. 2016, 20:25:21
    Author     : florian
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="ligne">
    <h3>Ajouter un auteur à un média:</h3>
    <div>
        <form action="${pageContext.request.contextPath}/AjoutAuteurMedia" method="post">
            <lable>Media: </label><select name="mediaId">
                <%--On importe la liste de médias puis on les ajoutes au select--%>
                <c:import url="/MediaList"/>
                <c:set var="mds" value="${requestScope.mdList}"/>
                <c:forEach var="md" items="${mds}" varStatus="i">
                    <option value=${md.editionId}>${md.editionId}</option>
                </c:forEach>
            </select>
            <lable>Auteur: </label><select name="autId">
                <%--On importe la liste de auteurs puis on les ajoutes au select--%>
                <c:import url="/AuteurList"/>
                <c:set var="auts" value="${requestScope.atList}"/>
                <c:forEach var="aut" items="${auts}" varStatus="i">
                    <option value=${aut.getAuteurId()}>${aut.getAuteurId()}</option>
                </c:forEach>
            </select>
            <input type='submit'>
        </form>
        <c:choose><c:when test="${sessionScope.errAe!=null}"></br>${errAe}<br/><c:remove var="errAe"/></c:when><c:otherwise></c:otherwise></c:choose>
    </div>
</div>