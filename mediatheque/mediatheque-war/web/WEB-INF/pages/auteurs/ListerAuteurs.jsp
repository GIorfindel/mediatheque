<%-- 
    Document   : ListerAuteurs
    Created on : 6 déc. 2016, 22:12:55
    Author     : florian
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table ligne">
    <form action="${pageContext.request.contextPath}/SupAuteur" method="post">
        <h3>Liste  des  auteurs</h3>
        <%--On récupère la liste des auteurs puis on itère dessus--%>
        <c:import url="/AuteurList"/>
        <c:set var="ats" value="${requestScope.atList}"/>
        <table>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th></th>
            </tr>
            <%--On affiche l'ID et le nom de chaque auteur--%>
            <c:forEach var="at" items="${ats}" varStatus="i">
                <tr>
                    <td>${at.getAuteurId()}</td>
                    <td>${at.getPersonne().getNom()}</td>
                    <%--On ajoute un bouton pour supprimer l'auteur--%>
                    <td><button type="submit" name="atId" value=${at.getAuteurId()}>Supprimer</button>
                </tr>
            </c:forEach>
        </table>
        <%--Si on renvoie des erreurs alors on les affiches--%>
        <c:choose><c:when test="${sessionScope.errEd!=null}">${errEd}<br/><c:remove var="errEd"/></c:when><c:otherwise></c:otherwise></c:choose>
    </form>
</div>