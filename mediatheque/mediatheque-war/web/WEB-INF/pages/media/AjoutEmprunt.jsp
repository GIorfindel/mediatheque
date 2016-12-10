<%-- 
    Document   : AjoutEmprunt
    Created on : 10 déc. 2016, 00:27:17
    Author     : florian
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table ligne medias">
    <form action="${pageContext.request.contextPath}/EmprunterMedia" method="post">
        <h3>Emprunter:</h3>
        <c:import url="/EmprunterMedia"/>
        <c:set var="mds" value="${requestScope.mdList}"/>
        <table>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Publication</th>
                <th>Exemplaires</th>
                <th>Type</th>
                <th>Auteurs</th>
                <th>Adhérent</th>
                <th></th>
            </tr>
            <c:forEach var="md" items="${mds}" varStatus="i">
                <tr>
                    <td>${md.editionId}</td>
                    <td>${md.getNom()}</td>
                    <td>${md.getPublication()}</td>
                    <td>${md.getIdMedia().getNbexemplaires()}</td>
                    <td>${md.getIdMedia().getTypeId().getNom()}</td>
                    <td>            
                        <c:forEach var="au" items="${md.getAuteurCollection()}" varStatus="i">
                            ${au.auteurId},
                        </c:forEach>
                    </td>
                    <td><select name="adId">
                        <c:import url="/AdherentList"/>
                        <c:set var="ads" value="${requestScope.adList}"/>
                            <c:forEach var="ad" items="${ads}" varStatus="i">
                                <option value=${ad.adherentId}>${ad.adherentId}:${ad.getPersonne().getNom()}</option>
                        </c:forEach></td>
                    <td><button type="submit" name="mdId" value=${md.editionId}>Emprunter</button>
                </tr>
            </c:forEach>
        </table>
        <c:choose><c:when test="${sessionScope.errEa!=null}"><br/>${errEa}<c:remove var="errEa"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
    </form>
</div>
