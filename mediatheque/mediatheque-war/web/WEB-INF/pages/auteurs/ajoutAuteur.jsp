<%-- 
    Document   : ajoutAuteur
    Created on : 6 déc. 2016, 22:08:33
    Author     : florian
--%>


<div class="ligne">
    <h3>Ajouter auteur</h3>
    <form action="${pageContext.request.contextPath}/AjoutAuteur" method="post">
        <div id="left">
            <h5>Informations de la personne: </h5>
            <%--On importe la partie du formulaire qui correspond aux informations de la personne--%>
            <jsp:include page="/WEB-INF/pages/personne/AjoutPersonne.jsp"/>
        </div>
        <div>
            <%--On importe la partie du formulaire qui permet de sélectionner l'adresse de l'auteur--%>
            <jsp:include page="/WEB-INF/pages/personne/SelectAdresse.jsp"/>
        </div>
        <input type='submit'><br/>
        </div>
    </form>
</div>
