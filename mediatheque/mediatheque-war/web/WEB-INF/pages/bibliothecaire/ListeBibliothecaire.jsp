<%-- 
    Document   : ListeBibliothecaire
    Created on : 24 nov. 2016, 15:44:54
    Author     : glorfindel
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ligne">
    <form action="${pageContext.request.contextPath}/SupBibliothecaire" method="post">
        <h3>Liste  des  bibliothecaires</h3>
        <c:import url="/Bibliothecairelist"/>
        <c:set var="bibs" value="${requestScope.bibList}"/>
        <table border="1" cellpadding="0" cellspacing="0">
            <tr bgcolor="#cccccc">
                <td>Id</td>
                <td>Pseudo</td>
            </tr>
            <c:forEach var="bib" items="${bibs}" varStatus="i">
                <tr>
                    <td>${bib.getBibliothecaireId()}</td>
                    <td>${bib.getLogin()}</td>
                    <td><button type="submit" name="bibId" value=${bib.getBibliothecaireId()}>Supprimer</button>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
