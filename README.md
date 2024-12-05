# UCE Génie Logiciel Avancé : Techniques de tests


# Mon projet

**Nom et prénom** : PHONG Théo
**Groupe** : IA


# Badges

- Badge CircleCI : [![CircleCI](https://dl.circleci.com/status-badge/img/gh/TheoPhongIA/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/TheoPhongIA/ceri-m1-techniques-de-test/tree/master)
- Badge Couverture de tests : [![codecov](https://codecov.io/gh/TheoPhongIA/ceri-m1-techniques-de-test/graph/badge.svg?token=50N84UN0UO)](https://codecov.io/gh/TheoPhongIA/ceri-m1-techniques-de-test)


# Description

Ce projet est un exemple de mise en place d'une solution d'intégration continue (CI) avec CircleCI et Codecov pour la couverture de tests dans un projet Java utilisant Maven.


# Choix techniques

- **Maven** : Utilisation de Maven comme système de gestion de dépendances et de build. Ce projet utilise la version 17 de Java et inclut les dépendances pour les tests unitaires avec JUnit et Mockito.
- **JaCoCo** : Le plugin JaCoCo a été intégré dans le fichier `pom.xml` pour générer des rapports de couverture de tests. Ces rapports sont ensuite envoyés à Codecov via CircleCI.
- **CircleCI** : CircleCI a été configuré pour automatiser le build, l'exécution des tests, et la génération des rapports de couverture de code. Le fichier `.circleci/config.yml` configure les pipelines pour compiler et tester le projet, et ensuite publier les résultats sur Codecov.
- **Codecov** : Codecov est utilisé pour visualiser les résultats des tests de couverture. Le badge de couverture de tests est affiché dans ce fichier README pour une consultation rapide des résultats.


