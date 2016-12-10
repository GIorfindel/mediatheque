<%-- 
    Document   : AjoutIdentification
    Created on : 25 nov. 2016, 22:53:29
    Author     : glorfindel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h5>Informations d'identification: </h5>
<%--On vérifie que le pseudo contiens 5 à 20 caractères et on affiche une erreur dans le cas contraire ou si le pseudo est déjà utilisé--%>
<label>Pseudo: </label><input pattern=".{5,20}" type='text' name='pseudo' required title="Votre pseudo doit contenir 5 à 20 caractères"><c:choose><c:when test="${sessionScope.errPseudo!=null}"><br/>${errPseudo}<c:remove var="errPseudo"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
<%--On vérifie que le mot de passe contiens 5 à 20 caractères et on affiche une erreur dans le cas contraire--%>
<label>Mot de passe: </label><input pattern=".{5,20}" type='password' name='mdp' required title="Votre pseudo doit contenir 5 à 20 caractères"><c:choose><c:when test="${sessionScope.errMdp!=null}"><br/>  ${errMdp}<c:remove var="errMdp"/></c:when><c:otherwise></c:otherwise></c:choose><br/>