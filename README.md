Voici cinq exercices que tu peux implémenter en utilisant l'algorithme du **Self-Scheduling** pour te familiariser avec ce concept. Chaque exercice nécessite de diviser les tâches en portions et de les exécuter parallèlement avec une taille d'itération ajustable, tout en utilisant des threads ou un pool de threads.

### 1. **Somme parallèle d'un tableau d'entiers**

- **But** : Calculer la somme de tous les éléments d'un tableau d'entiers en utilisant plusieurs threads, avec des tâches réparties dynamiquement.
- **Détail** : Tu devras diviser le tableau en portions et chaque thread devra calculer la somme partielle d'une portion du tableau. À la fin, les sommes partielles doivent être combinées pour obtenir la somme totale.
- **Objectif du Self-Scheduling** : Diviser dynamiquement les indices du tableau en blocs de taille `K`, où `K` est la taille d'itération ajustable.

### 2. **Produit des éléments d'une matrice**

- **But** : Multiplier tous les éléments d'une matrice (tableau 2D) et obtenir le produit final, en parallèle.
- **Détail** : Répartir les calculs sur les lignes de la matrice ou sur les éléments individuels, en fonction de la taille de la matrice et du nombre de threads disponibles.
- **Objectif du Self-Scheduling** : Ajuster la taille des portions des lignes ou colonnes traitées par chaque thread pour équilibrer la charge.

### 3. **Recherche de l'élément maximum dans un tableau**

- **But** : Trouver l'élément maximum d'un grand tableau d'entiers.
- **Détail** : Chaque thread est responsable de chercher le maximum dans une portion du tableau. Ensuite, les résultats partiels doivent être combinés pour obtenir le maximum global.
- **Objectif du Self-Scheduling** : Ajuster dynamiquement les portions de travail (taille d'itération) pour chaque thread afin de minimiser la surcharge de synchronisation.

### 4. **Calcul de la norme d'un vecteur**

- **But** : Calculer la norme d'un vecteur (la racine carrée de la somme des carrés des éléments d'un vecteur).
- **Détail** : Diviser le vecteur en portions et chaque thread calcule la somme des carrés pour une partie du vecteur. Ensuite, les résultats partiels sont additionnés et la racine carrée est appliquée pour obtenir la norme finale.
- **Objectif du Self-Scheduling** : Utiliser le self-scheduling pour répartir le travail sur le vecteur de manière équilibrée, tout en réduisant le coût de synchronisation.

### 5. **Filtrage parallèle d'un tableau**

- **But** : Appliquer un filtre à un tableau d'entiers (par exemple, sélectionner uniquement les éléments pairs) en parallèle.
- **Détail** : Chaque thread doit filtrer une portion du tableau, et les résultats filtrés sont combinés à la fin pour former un tableau filtré global.
- **Objectif du Self-Scheduling** : Utiliser le self-scheduling pour équilibrer la charge, chaque thread filtrant une portion du tableau, puis combiner les résultats efficacement.

---

### Suggestions générales pour tous les exercices :

- Implémente une fonction `Worker` ou une classe pour chaque tâche parallèle.
- Utilise un **ExecutorService** ou un pool de threads pour gérer les threads.
- Utilise des `Future<T>` pour collecter les résultats des threads et les combiner à la fin.
- Teste avec différentes tailles d'itérations (`K`) pour observer les performances avec des valeurs petites et grandes.