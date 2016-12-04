<%-- 
    Document   : AjoutIdentification
    Created on : 25 nov. 2016, 22:53:29
    Author     : glorfindel
--%>

<h5>Informations d'identification: </h5>
<label>Pseudo: </label><input pattern=".{5,20}" type='text' name='pseudo' required title="Votre pseudo doit contenir 5 à 20 caractères"><c:choose><c:when test="${sessionScope.errPseudo!=null}"><br/>${errPseudo}<c:remove var="errPseudo"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
<label>Mot de passe: </label><input pattern=".{5,20}" type='password' name='mdp' required title="Votre pseudo doit contenir 5 à 20 caractères"><c:choose><c:when test="${sessionScope.errMdp!=null}"><br/>  ${errMdp}<c:remove var="errMdp"/></c:when><c:otherwise></c:otherwise></c:choose><br/>