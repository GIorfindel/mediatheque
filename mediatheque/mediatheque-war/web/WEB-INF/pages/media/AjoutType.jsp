<%-- 
    Document   : AjoutType
    Created on : 9 d�c. 2016, 16:18:41
    Author     : florian
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="ligne">
    <h3>Ajouter type:</h3>
    <div>
    <form action="${pageContext.request.contextPath}/AjoutType" method="post">
        <%--On v�rifie l'input de l'utilisateur et on affiche les erreurs �ventuelles--%>
        <label>Nom: </label><input pattern="[A-z|-]{2,20}" type='text' name='nom' required title="Le nom doit contenir 2 � 20 lettres"><c:choose><c:when test="${sessionScope.errNomT!=null}"><br/>${errNomT}<c:remove var="errNomT"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
        <input type='submit'><br/>
    </form>
    </div>
</div>
