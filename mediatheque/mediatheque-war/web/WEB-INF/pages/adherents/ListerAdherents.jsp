<%-- 
    Document   : ListerAdherents
    Created on : 5 déc. 2016, 23:44:11
    Author     : glorfindel
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ligne">
    <form action="${pageContext.request.contextPath}/SupAdherent" method="post">
        <h3>Liste  des  adhérents</h3>
        <c:import url="/AdherentList"/>
        <c:set var="ads" value="${requestScope.adList}"/>
        <table>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Prénom</th>
            </tr>
            <c:forEach var="ad" items="${ads}" varStatus="i">
                <tr>
                    <td>${ad.getAdherentId()}</td>
                    <td>${bib.getNom()}</td>
                    <td><button type="submit" name="adId" value=${ad.getAdherentId()}>Supprimer</button>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
