<%-- 
    Document   : AjoutPersonne
    Created on : 24 nov. 2016, 16:44:03
    Author     : glorfindel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<label>Nom: </label><input pattern="[A-z|-]{5,20}" type='text' name='nom' required title="Le nom doit contenir 5 � 20 lettres"><c:choose><c:when test="${sessionScope.errNom!=null}"><br/>${errNom}<c:remove var="errNom"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
<label>Pr�nom: </label><input pattern="[A-z|-]{5,20}" type='text' name='prenom' required title="Le pr�nom doit contenir 5 � 20 lettres"><c:choose><c:when test="${sessionScope.errPrenom!=null}"><br/>${errPrenom}<c:remove var="errPrenom"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
<label>T�l�phone: </label><input pattern="0[0-9]{9,9}" type='text' name='tel' required title="Un num�ro de t�l�phone contient 10 chiffres et commence par 0"><c:choose><c:when test="${sessionScope.errTel!=null}"><br/>${errTel}<c:remove var="errTel"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
