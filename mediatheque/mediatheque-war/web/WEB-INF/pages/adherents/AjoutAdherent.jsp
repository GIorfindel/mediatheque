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
            <jsp:include page="/WEB-INF/pages/personne/AjoutPersonne.jsp"/>
        </div>
        <div>
            <jsp:include page="/WEB-INF/pages/personne/SelectAdresse.jsp"/>
        </div>
            <input type='submit'><br/>
    </form>
</div>
