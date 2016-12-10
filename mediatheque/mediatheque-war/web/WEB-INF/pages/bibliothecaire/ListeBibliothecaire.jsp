<%-- 
    Document   : ListeBibliothecaire
    Created on : 24 nov. 2016, 15:44:54
    Author     : glorfindel
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table ligne">
    <form action="${pageContext.request.contextPath}/SupBibliothecaire" method="post">
        <h3>Liste  des  bibliothecaires</h3>
        <%--On importe la liste des bibliothecaires puis on itère dessus--%>
        <c:import url="/Bibliothecairelist"/>
        <c:set var="bibs" value="${requestScope.bibList}"/>
        <table>
            <tr>
                <th>Id</th>
                <th>Pseudo</th>
                <th></th>
            </tr>
            <%--On affiche l'ID et le pseudo des bibliothecaires--%>
            <c:forEach var="bib" items="${bibs}" varStatus="i">
                <tr>
                    <td>${bib.getBibliothecaireId()}</td>
                    <td>${bib.getLogin()}</td>
                    <%--On ajoute un bouton pour supprimer le bibliothecaire--%>
                    <td><button type="submit" name="bibId" value=${bib.getBibliothecaireId()}>Supprimer</button>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
