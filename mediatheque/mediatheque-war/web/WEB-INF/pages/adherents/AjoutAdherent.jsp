<%-- 
    Document   : AjoutAdherent
    Created on : 24 nov. 2016, 15:35:53
    Author     : glorfindel
--%>

<div class="ligne">
    <h3>Ajouter Adhérent</h3>
    <form action="${pageContext.request.contextPath}/AjoutAdherent" method="post">
        <div id="left">
            <h5>Informations de la personne: </h5>
            <%--On importe le formulaire qui contient les informations relatives à la personne--%>
            <jsp:include page="/WEB-INF/pages/personne/AjoutPersonne.jsp"/>
        </div>
        <div>
            <%--On importe la partie qui permet de sélectionner une adresse--%>
            <jsp:include page="/WEB-INF/pages/personne/SelectAdresse.jsp"/>
            <input type='submit'><br/>
        </div>
    </form>
</div>
