<%-- 
    Document   : ListeType
    Created on : 9 déc. 2016, 15:50:26
    Author     : florian
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table ligne">
    <form action="${pageContext.request.contextPath}/SupType" method="post">
        <h3>Liste  des  types:</h3>
        <%--On importe la liste des types puis on les affiches et on ajoute le bouton de suppression--%>
        <c:import url="/TypeList"/>
        <c:set var="tps" value="${requestScope.tpList}"/>
        <table>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th></th>
            </tr>
            <c:forEach var="tp" items="${tps}" varStatus="i">
                <tr>
                    <td>${tp.getTypeId()}</td>
                    <td>${tp.getNom()}</td>
                    <td><button type="submit" name="tpId" value=${tp.getTypeId()}>Supprimer</button>
                </tr>
            </c:forEach>
        </table>
        <c:choose><c:when test="${sessionScope.errTpU!=null}"><br/>${errTpU}<c:remove var="errTpU"/></c:when><c:otherwise></c:otherwise></c:choose><br/> 
    </form>
</div>
