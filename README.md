TAA Serveur REST
================
Pour lancer l'application :
Il faut modifier /etc/hosts pour faire correspondre myapp.taa.fr vers 127.0.0.1.
Puis vous devez tapez la commande à l'endroit où se trouve le fichier docker-compose.yml:
```
docker-compose up 
```

En tapant cela vous lancerez plusieurs conteneurs docker, un conteneur contenant la base de données, trois conteneurs contenant l'application REST, directement reliés à la base de données et un nginx qui fait le load balancing entre les différents serveurs rest.
L'instance nginx est accessible via le port 80 à l'adresse myapp.taa.fr.

Documentation des appels REST possibles
=======================================
Une fois les conteneurs lancées, la documentation des appels REST disponible est accessible via swagger à l'adresse:
```
http://myapp.taa.fr/swagger/index.html
```

Description du projet
=====================

Le projet est une application rest, l'application se lance graĉe à Springboot.
J'ai découpé l'application java en plusieurs package:
Dans le package controller on peut retoruver l'intégralité des controlleurs rest.
Dans le package service, on peut retrouver à tous les services qui sont appelés par les controleurs.
Dans le package domain, on peut retrouver les entités JPA représentant le model du projet.
Dans le package dao, on peut retrouver les éléments qui permettent de faire des requetes en base de données (CrudRepository).
Dans le package aspect, on retrouve les aspects du projet, notament l'aspect qui log des qu'un utilisateur appelle une méthode du controlleur.


