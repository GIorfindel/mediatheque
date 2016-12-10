<%-- 
    Document   : ListerEditeur
    Created on : 7 d�c. 2016, 14:36:06
    Author     : florian
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table ligne">
    <form action="${pageContext.request.contextPath}/SupEditeur" method="post">
        <h3>Liste  des  �diteurs</h3>
        <%--On importe la liste des �diteur puis on it�re dessus--%>
        <c:import url="/EditeurList"/>
        <c:set var="eds" value="${requestScope.edList}"/>
        <table>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th></th>
            </tr>
            <%--On affiche l'ID et le nom des �diteurs--%>
            <c:forEach var="ed" items="${eds}" varStatus="i">
                <tr>
                    <td>${ed.getEditeurId()}</td>
                    <td>${ed.getNom()}</td>
                    <%--On ajoute un bouton pour supprimer les �diteurs--%>
                    <td><button type="submit" name="edId" value=${ed.getEditeurId()}>Supprimer</button>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
