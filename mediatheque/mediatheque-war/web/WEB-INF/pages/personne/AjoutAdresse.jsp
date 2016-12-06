<%-- 
    Document   : AjoutAdresse
    Created on : 24 nov. 2016, 16:46:20
    Author     : glorfindel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose><c:when test="${sessionScope.errAdrE!=null}">${errAdrE}<c:remove var="errAdrE"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
<label>Pays: </label><input pattern="[A-z|-]{5,20}" type='text' name='pays' required title="Le pays doit contenir 5 à 20 lettres"><c:choose><c:when test="${sessionScope.errPays!=null}"><br/>${errPays}<c:remove var="errPays"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
<label>Ville: </label><input pattern="[A-z|-]{5,20}" type='text' name='ville' required title="La ville doit contenir 5 à 20 lettres"><c:choose><c:when test="${sessionScope.errVille!=null}"><br/>${errVille}<c:remove var="errVille"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
<label>Rue: </label><input pattern="[A-z|-]{5,20}" type='text' name='rue' required title="La rue doit contenir 5 à 20 lettres"><c:choose><c:when test="${sessionScope.errRue!=null}"><br/>${errRue}<c:remove var="errRue"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
<label>Numéro: </label><input type='number' name='num' min="1" max="300" required title="Le numéro doit être compris entre 1 et 300"><c:choose><c:when test="${sessionScope.errNum!=null}"><br/>${errNum}<c:remove var="errNum"/></c:when><c:otherwise></c:otherwise></c:choose><br/>