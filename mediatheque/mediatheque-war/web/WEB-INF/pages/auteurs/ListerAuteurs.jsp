<%-- 
    Document   : ListerAuteurs
    Created on : 6 déc. 2016, 22:12:55
    Author     : florian
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table ligne">
    <form action="${pageContext.request.contextPath}/SupAuteur" method="post">
        <h3>Liste  des  auteurs</h3>
        <c:import url="/AuteurList"/>
        <c:set var="ats" value="${requestScope.atList}"/>
        <table>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th></th>
            </tr>
            <c:forEach var="at" items="${ats}" varStatus="i">
                <tr>
                    <td>${at.getAuteurId()}</td>
                    <td>${at.getPersonne().getNom()}</td>
                    <td><button type="submit" name="atId" value=${at.getAuteurId()}>Supprimer</button>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>