<%-- 
    Document   : AjoutGenre
    Created on : 9 déc. 2016, 22:57:20
    Author     : florian
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="ligne">
    <h3>Ajouter un genre à un média:</h3>
    <div>
        <form action="${pageContext.request.contextPath}/AjoutGenre" method="post">
            <lable>Media: </label><select name="mediaId">
                <c:import url="/MediaList"/>
                <c:set var="mds" value="${requestScope.mdList}"/>
                <c:forEach var="md" items="${mds}" varStatus="i">
                    <option value=${md.editionId}>${md.editionId}</option>
                </c:forEach>
            </select>
            <label>Genre: </label><input pattern="[A-z|-]{5,20}" type='text' name='genre' required title="Le genre doit contenir 5 à 20 lettres"><c:choose><c:when test="${sessionScope.errNomT!=null}"><br/>${errNomT}<c:remove var="errNomT"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
            <input type='submit'>
        </form>
        <c:choose><c:when test="${sessionScope.errGenre!=null}"></br>${errGenre}<br/><c:remove var="errGenre"/></c:when><c:otherwise></c:otherwise></c:choose>
    </div>
</div>
