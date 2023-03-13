# Projet-CarbonIt

Enoncé du projet :
[Exercice pratique - La carte aux treėsors.pdf](https://github.com/AlexisRelin/Projet-CarbonIt/files/10960636/Exercice.pratique.-.La.carte.aux.treesors.pdf)

Lancement de l'application :
- Ajouter votre fichier d'entrée dans le dossier src/resources/Entree de l'application
- Lancer la classe main se trouvant dans la classe App avec pour parametre d'entrée le nom du fichier avec son extention (exemple : MatriceEntree.txt)

Sortie :
- le fichier MatriceSortie.txt est généré et contient les informations de sortie de l'application sous src/resources/Sortie

____________________________________________________________________________________
Structure du code

Business : 
- Couche contenant les objets métier (carte, aventurier, montagne, trésor) 

Constantes : 
- Regroupement des constantes du projet

DAO :
- DataInputDAO => Récupère les données du fichier d'entrée
- DataOutputDAO => Ecrit les données de sortie dans un fichier

Mapper :
- FichierEntreeMapper => Mappe les données récupérées en entrées en des listes d'objets métier
- FichierSortieMapper => Mappe les listes de données métier de sortie en données de sortie

ListesUtilitaires : 
- Listes et traitement sur ces listes utilisés dans la couche métier de l'application

App : Classe main de l'application
____________________________________________________________________________________
Logique de développement :

L'application a été pensée comment un module évolutif qui suit la trame suivante
Fichier entrée > DAO > mapper > application > mapper > DAO > Fichier de sortie

Chacune de ses briques peuvent être modifiées indépendamment des autres avec pour seule contrainte le respect de leurs types de données d'entrées et de sorties. 
