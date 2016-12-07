<%-- 
    Document   : ajoutEditeur
    Created on : 7 déc. 2016, 14:20:47
    Author     : florian
--%>


<div class="ligne">
    <h3>Ajouter Editeur</h3>
    <form action="${pageContext.request.contextPath}/AjoutEditeur" method="post">
        <div id="left">
            <h5>Nom de l'éditeur: </h5>
            <label>Nom: </label><input pattern="[A-z|-]{5,20}" type='text' name='nom' required title="Le nom doit contenir 5 à 20 lettres"><c:choose><c:when test="${sessionScope.errNomU!=null}"><br/>${errNomU}<c:remove var="errNomU"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
        </div>
        <div>
            <jsp:include page="/WEB-INF/pages/personne/SelectAdresse.jsp"/>
            <input type='submit'><br/>
        </div>
    </form>
</div>
