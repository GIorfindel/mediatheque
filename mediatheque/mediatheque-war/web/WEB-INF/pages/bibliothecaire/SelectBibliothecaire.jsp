<%-- 
    Document   : SelectBibliothecaire
    Created on : 4 déc. 2016, 12:51:42
    Author     : glorfindel
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Choisissez une bibliothecaire à supprimer</h3>
${idb}
<form action="${pageContext.request.contextPath}/SupBibliothecaire" method="post">
    <select name="bibId">
        <c:import url="/Bibliothecairelist"/>
        <c:set var="bibs" value="${requestScope.bibList}"/>
        <c:forEach var="bib" items="${bibs}" varStatus="i">
            <option value=${bib.getBibliothecaireId()}>${bib.getBibliothecaireId()}:${bib.getLogin()}</option>
        </c:forEach>
    </select>
    <input type='submit'><br/>
</form>
