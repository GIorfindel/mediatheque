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
            <jsp:include page="/WEB-INF/pages/personne/AjoutPersonne.jsp"/>
        </div>
        <div>
            <jsp:include page="/WEB-INF/pages/personne/SelectAdresse.jsp"/>
        </div>
        <div id="right">
            <jsp:include page="/WEB-INF/pages/bibliothecaire/AjoutIdentification.jsp"/>
            <input type='submit'><br/>
        </div>
    </form>
</div>
