<%-- 
    Document   : AjoutPersonne
    Created on : 24 nov. 2016, 16:44:03
    Author     : glorfindel
--%>

<label>Nom: </label><input pattern="[A-z|-]{5,20}" type='text' name='nom' required title="Le nom doit contenir 5 � 20 lettres"><br/>
<label>Pr�nom: </label><input pattern="[A-z|-]{5,20}" type='text' name='prenom' required title="Le pr�nom doit contenir 5 � 20 lettres"><br/>
<label>T�l�phone: </label><input pattern="0[0-9]{9,9}" type='text' name='tel' required title="un num�ro de t�l�phone contient 10 chiffres et commence par 0"><br/>
