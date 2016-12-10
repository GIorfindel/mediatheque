<%-- 
    Document   : AjoutBibliothecaire
    Created on : 24 nov. 2016, 15:44:30
    Author     : glorfindel
--%>

<div class="ligne">
    <h3>Ajouter Bibliothécaire</h3>
    <form action="${pageContext.request.contextPath}/AjoutBibliothecaire" method="post">
        <div id="left">
            <h5>Informations de la personne: </h5>
            <%--On importe la partie du formulaire qui correspond aux informations de la personne--%>
            <jsp:include page="/WEB-INF/pages/personne/AjoutPersonne.jsp"/>
        </div>
        <div>
            <%--On importe la partie du formulaire qui correspond permet de sélectionner l'adresse--%>
            <jsp:include page="/WEB-INF/pages/personne/SelectAdresse.jsp"/>
        </div>
        <div id="right">
            <%--On importe la partie du formulaire qui correspond aux informations d'identification--%>
            <jsp:include page="/WEB-INF/pages/bibliothecaire/AjoutIdentification.jsp"/>
            <input type='submit'><br/>
        </div>
    </form>
</div>
