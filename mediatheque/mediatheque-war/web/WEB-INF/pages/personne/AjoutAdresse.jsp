<%-- 
    Document   : AjoutAdresse
    Created on : 24 nov. 2016, 16:46:20
    Author     : glorfindel
--%>

<label>Pays: </label><input pattern="[A-z|-]{5,20}" type='text' name='pays' required title="Le pays doit contenir 5 à 20 lettres"><br/>
<label>Ville: </label><input pattern="[A-z|-]{5,20}" type='text' name='ville' required title="La ville doit contenir 5 à 20 lettres"><br/>
<label>Rue: </label><input pattern="[A-z|-]{5,20}" type='text' name='rue' required title="La rue doit contenir 5 à 20 lettres"><br/>
<label>Numéro: </label><input type='number' name='num' min="1" max="300" required title="Le numéro doit être compris entre 1 et 300"><br/>