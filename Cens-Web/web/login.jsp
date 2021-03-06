<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Connexion</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<form method="post" action="Connexion">
    <fieldset>
        <legend>Connexion</legend>
        <p>Vous pouvez vous connecter via ce formulaire.</p>

        <label for="nom">Nom <span class="requis">*</span></label>
        <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="60" />
        <span class="erreur">${form.erreurs['nom']}</span><br />

        <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['motdepasse']}</span><br />

        <input type="submit" value="Connexion" class="sansLabel" />

        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

    </fieldset>
</form>
</body>
</html>