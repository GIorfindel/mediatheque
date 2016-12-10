<%-- 
    Document   : ListeMedia
    Created on : 7 déc. 2016, 10:55:19
    Author     : glorfindel
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table ligne medias">
    <form action="${pageContext.request.contextPath}/SupMedia" method="post">
        <h3>Liste  des  médias:</h3>
        <%--On importe la liste de médias puis affiches les informations et le bouton de suppression--%>
        <c:import url="/MediaList"/>
        <c:set var="mds" value="${requestScope.mdList}"/>
        <table>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Publication</th>
                <th>Exemplaires</th>
                <th>Type</th>
                <th>Auteurs</th>
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
                    <td><button type="submit" name="mdId" value=${md.editionId}>Supprimer</button>
                </tr>
            </c:forEach>
        </table>
        <c:choose><c:when test="${sessionScope.errSupM!=null}">${errSupM}<br/><c:remove var="errSupM"/></c:when><c:otherwise></c:otherwise></c:choose>
    </form>
</div>