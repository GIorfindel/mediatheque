<%-- 
    Document   : AjoutMedia
    Created on : 7 déc. 2016, 10:54:49
    Author     : glorfindel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="ligne">
    <h3>Ajouter un media:</h3>
    <form action="${pageContext.request.contextPath}/AjoutMedia" method="post">
        <c:choose><c:when test="${sessionScope.errAdrE!=null}">${errAdrE}<br/><c:remove var="errAdrE"/></c:when><c:otherwise></c:otherwise></c:choose>
        <label>Nom: </label><input pattern="[A-z|-]{5,20}" type='text' name='nom' required title="Le nom doit contenir 5 à 20 lettres"><c:choose><c:when test="${sessionScope.errNom!=null}"><br/>${errNom}<c:remove var="errNom"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
        <label>Année de publication: </label><input pattern="(0?\d|[12]\d|3[01])-(0?\d|1[012])-((?:19|20)\d{2})" type='text' name='date' required title="La date doit être au format jj-mm-aaaa"><c:choose><c:when test="${sessionScope.errPub!=null}"><br/>${errPub}<c:remove var="errPub"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
                <lable>Type: </label><select name="typeId">
                <c:import url="/TypeList"/>
                <c:set var="types" value="${requestScope.typeList}"/>
                <c:forEach var="type" items="${types}" varStatus="i">
                    <option value=${type.getTypeId()}>${type.getNom()}</option>
                </c:forEach>
            </select><br/>    
            <lable>Editeur: </label><select name="editeurId">
                    <c:import url="/EditeurList"/>
                    <c:set var="editeurs" value="${requestScope.edList}"/>
                    <c:forEach var="editeur" items="${editeurs}" varStatus="i">
                        <option value=${editeur.getEditeurId()}>${editeur.getNom()}</option>
                    </c:forEach>
                </select><br/> 
                <label>Exemplaires: </label><input min="1" max="20" type="number" name='nbe' required title="Vous pouvez ajouter entre 1 et 20 exemplaires"><c:choose><c:when test="${sessionScope.errNbE!=null}"><br/>${errNbE}<c:remove var="errNbE"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
                <label>ISBN: </label><input pattern="[0-9]{13}" type='text' name='isbn' title="Le numéro ISBN doit contenir 13 chiffres"><c:choose><c:when test="${sessionScope.errIsbn!=null}"><br/>${errIsbn}<c:remove var="errIsbn"/></c:when><c:otherwise></c:otherwise></c:choose><br/>
                <input type='submit'>
                </form>
                </div>