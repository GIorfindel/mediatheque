<%-- 
    Document   : RendreEmprunt
    Created on : 10 déc. 2016, 13:53:17
    Author     : florian
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table ligne medias">
    <form action="${pageContext.request.contextPath}/RendreMedia" method="post">
        <h3>Rendre:</h3>
        <c:import url="/MediaEmpruntes"/>
        <c:set var="emps" value="${requestScope.empLt}"/>
        <table>
            <tr>
                <th>MediaId</th>
                <th>Adhérent</th>
                <th>Date d'emprunt</th>
                <th>Retour au plus tard</th>
                <th></th>
            </tr>
            <c:forEach var="emp" items="${emps}" varStatus="i">
                <tr>
                    <td>${emp.empruntePK.idMedia}</td>
                    <td>${emp.empruntePK.idAdherent}</td>
                    <td>${emp.empruntePK.dateemprunt}</td>
                    <td>${emp.empruntePK.dateretour}</td>
                    <td><button type="submit" name="mId" value=${emp.empruntePK.idMedia}>Rendre</button>
                    <input type="hidden" name="aId" value=${emp.empruntePK.idAdherent}> 
                </tr>
            </c:forEach>
        </table>
        <c:choose><c:when test="${sessionScope.errEa!=null}"><br/>${errEa}<c:remove var="errEa"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
    </form>
</div>
