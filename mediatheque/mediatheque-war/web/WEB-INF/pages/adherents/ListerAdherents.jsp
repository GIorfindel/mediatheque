<%-- 
    Document   : ListerAdherents
    Created on : 5 déc. 2016, 23:44:11
    Author     : glorfindel
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table ligne">
    <form action="${pageContext.request.contextPath}/SupAdherent" method="post">
        <h3>Liste  des  adhérents</h3>
        <c:import url="/AdherentList"/>
        <%--On récupére la liste des adhérents puis on itère dessus--%>
        <c:set var="ads" value="${requestScope.adList}"/>
        <table>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th></th>
            </tr>
            <%--Pour chaque adhérent on affiche l'ID et le nom--%>
            <c:forEach var="ad" items="${ads}" varStatus="i">
                <tr>
                    <td>${ad.getAdherentId()}</td>
                    <td>${ad.getPersonne().getNom()}</td>
                    <%--On ajoute un bouton pour supprimer l'adhérent--%>
                    <td><button type="submit" name="adId" value=${ad.getAdherentId()}>Supprimer</button>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
