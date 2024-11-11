# Vérificateur de Mot de Passe Sécurisé avec Détection de Parties Mémorisables

## Dates : du 03/11/24 au 10/11/24
## Difficulté : Facile
## Technologies : Java 17+ (ou Kotlin)
## Description
Dans ce challenge, vous allez créer un **vérificateur de mot de passe sécurisé**, mais avec une fonctionnalité supplémentaire : 
- le programme devra détecter et avertir l'utilisateur si le mot de passe contient des **parties mémorisables**. 
Cette détection se fera à l'aide **d'expressions régulières**. Vous allez ainsi apprendre à manipuler les chaînes de caractères tout en renforçant vos connaissances sur la sécurité des mots de passe.
## Objectif
Votre programme doit permetttre à l'utilisateur de saisir un mot de passe sécurisé en respectant les critères suivants :
- La longueur du mot de passe doit être entre 8 et 32 caractères.
- Le mot de passe doit contenir **au moins** :
    - Une lettre majuscule,
    - Une lettre minuscule,
    - Un chiffre,
    - Un caractère spécial (par exemple : @, #, !, etc.).
Si le mot de passe ne convient pas, affichez un **message d’erreur**.
En plus de cela, le programme doit vérifier si le mot de passe généré contient des **parties mémorisables** et afficher un **avertissement** si c'est le cas. 
Voici quelques exemples de parties mémorisables à détecter :
- **Séquences évidentes** comme "1234", "abcd", ou des séquences de touches du clavier comme "qwerty".
- **Répétitions de caractères** trop fréquentes, comme "aaaa" ou "1111".
- **Mots communs** ou phrases simples comme "password", "admin", "hello", etc.
Cette détection doit se faire via des **expressions régulières** simples. Par exemple, une expression régulière comme `(\w)\1{3,}` permettrait de détecter des répétitions de plus de 3 caractères identiques consécutifs.
### Exemple d'exécution
```dos
Entrez le mot de passe  
A1b#cdef1234  
Attention : Votre mot de passe contient une séquence facile à mémoriser ou prévisible.
```

## Bonus

## Bonus 1 - Vérification de la force du mot de passe
Vous pouvez ajouter une fonctionnalité qui analyse la force du mot de passe en fonction de plusieurs critères :
- Longueur du mot de passe.
- Diversité des caractères (majuscules, minuscules, chiffres, symboles).
Cette fonctionnalité pourrait retourner un score ou un niveau (par exemple : "faible", "moyen", "fort") pour chaque mot de passe. Cela encouragerait les utilisateurs à choisir des mots de passe plus robustes.

## Bonus 2 - Tests unitiares
 Ajoutez un système de tests unitaires qui valident à la fois le mot de passe et la détection des parties mémorisables. Vous pouvez utiliser des expressions régulières dans les tests pour vérifier que les mots de passe générés respectent les critères de sécurité et que les parties mémorisables sont correctement détectées. 

## Points
Les participants recevront des points en fonction de leur performance :
## Récompense
- Vainqueur : 5 pts
- 2ème : 3 pts
- 3ème : 1 pts
## Livraison
Code source à déposer dans un dépôt GitHub public.
Copiez le lien GitHub sur le canal #reponse-challenges de notre serveur Discord.
💬 N'oubliez pas de poser vos questions sur le Discord pour toute clarification ou aide sur ce challenge ! Bonne chance et montrez-nous vos talents de codeur ! 🎉
