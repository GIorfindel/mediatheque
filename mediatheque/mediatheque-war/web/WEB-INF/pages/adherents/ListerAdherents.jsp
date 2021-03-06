<%-- 
    Document   : ListerAdherents
    Created on : 5 d�c. 2016, 23:44:11
    Author     : glorfindel
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table ligne">
    <form action="${pageContext.request.contextPath}/SupAdherent" method="post">
        <h3>Liste  des  adh�rents</h3>
        <c:import url="/AdherentList"/>
        <%--On r�cup�re la liste des adh�rents puis on it�re dessus--%>
        <c:set var="ads" value="${requestScope.adList}"/>
        <table>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th></th>
            </tr>
            <%--Pour chaque adh�rent on affiche l'ID et le nom--%>
            <c:forEach var="ad" items="${ads}" varStatus="i">
                <tr>
                    <td>${ad.getAdherentId()}</td>
                    <td>${ad.getPersonne().getNom()}</td>
                    <%--On ajoute un bouton pour supprimer l'adh�rent--%>
                    <td><button type="submit" name="adId" value=${ad.getAdherentId()}>Supprimer</button>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
