# Atelier Morpion – Exercices Guidés

Bienvenue dans cet atelier où vous allez découvrir la programmation Java à travers la création d’un jeu de morpion (tic-tac-toe) en mode terminal.
L’objectif est de vous faire implémenter, étape par étape, les parties logiques de chaque classe. Les méthodes `print()` sont déjà fournies et ne doivent **pas** être modifiées ; concentrez-vous sur l’implémentation des fonctionnalités manquantes indiquées par des commentaires `TODO`.

---
## Outils recommandés

* L'IDE (Environnements de développement intégré) [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windowsZip&code=IIC) de l'éditeur JetBrain
* Java 21, disponible depuis l'IDE

## Structure du projet

* **Player.java**
  Contient la classe `Player`, qui stocke le symbole d’un joueur et possède une méthode `print()` pour afficher ces informations.

  > **Aucune modification n’est nécessaire** dans cette classe (vous pouvez relire pour comprendre le rôle du joueur).

* **Grid.java**
  Contient la classe `Grid`, responsable de la représentation interne du plateau (une matrice 3×3) et de la détection des coups, de la victoire et du match nul.
  Les méthodes à compléter sont :

    1. `placeMark(int row, int col, char symbol)`
    2. `checkWin(char symbol)`
    3. `isFull()`

* **Game.java**
  Contient la classe `Game`, qui orchestre le déroulé de la partie : boucle de jeu, saisie utilisateur, alternance des joueurs, vérifications de victoire/match nul.
  Les méthodes à compléter sont :

    1. `play()` (logique de placement, vérification victoire/match nul, changement de joueur)
    2. `isValidFormat(String s)` (vérifier que la saisie de l’utilisateur respecte le format `[A-C][1-3]`)

---

## Exercice 1 : Comprendre la classe Player

> **Fichier :** `Player.java`

1. Ouvrez `Player.java` et relisez la classe.
2. Identifiez les membres suivants :

    * Le constructeur qui prend un `symbol`.
    * Le getters `getSymbol()`.
    * La méthode `print()` qui affiche le symbole du joueur.

Aucune implémentation n’est requise ici. Passez à l’exercice suivant une fois que vous êtes à l’aise avec le rôle de cette classe dans la structure générale.

---

## Exercice 2 : Implémenter la classe Grid

> **Fichier :** `Grid.java`

Dans ce fichier, plusieurs méthodes sont incomplètes. Vous allez les remplir afin que la grille fonctionne correctement.

### 2.1 – placeMark(int row, int col, char symbol)

**But :**

* Vérifier que `row` et `col` sont bien dans l’intervalle `[0, 2]`.
* Vérifier que `board[row][col]` est libre (`'\0'`).
* Si c’est le cas, placer `symbol` dans `board[row][col]` et retourner `true`.
* Sinon (case occupée ou indices hors limites), retourner `false`.

### 2.2 – checkWin(char symbol)

**But :**

* Vérifier s’il existe trois cases alignées avec le même symbole sur une même ligne, une même colonne ou l’une des deux diagonales.
* Retourner `true` dès qu’un alignement gagnant est détecté, sinon `false`.

<details>
  <summary>Indices</summary>
    <ol>
    <li>Tester chaque ligne `i`</li>
    <li>Tester chaque colonne `j`</li>
    <li>Tester les deux diagonales</li>
    <li>Si aucun alignement trouvé, retourner `false`</li>
    </ol>
</details>

### 2.3 – isFull()

**But :**

* Parcourir toutes les cases de `board`.
* Si vous trouvez une case valant `'\0'`, cela signifie qu’il reste au moins une case libre : retourner `false`.
* Si vous terminez la boucle sans avoir trouvé de `'\0'`, la grille est pleine : retourner `true`.

---

## Exercice 3 : Implémenter la classe Game

> **Fichier :** `Game.java`

Dans ce fichier, vous allez compléter la logique de la boucle de jeu, la saisie utilisateur, l’alternance des joueurs et la détection de fin de partie.

### 3.1 – isValidFormat(String s)

**But :**

* Vérifier que la chaîne `s` comporte exactement deux caractères.
* Vérifier que `s.charAt(0)` appartient à `{ 'A', 'B', 'C' }`.
* Vérifier que `s.charAt(1)` appartient à `{ '1', '2', '3' }`.
* Si tout est correct, retourner `true`. Sinon, retourner `false`.

### 3.2 – play()

La méthode `play()` gère le déroulé complet de la partie.

**À vous d’implémenter les étapes suivantes (remplacez les TODO dans le fichier)** :

1. **Tentative de placement** et gestion du cas “case occupée ou indices hors limites”.
2. **Vérification de la victoire** avec `grid.checkWin(currentPlayer.getSymbol())`.
3. **Vérification du match nul** avec `grid.isFull()`.
4. **Basculement du `currentPlayer`** si la partie continue.

---

## Conseils généraux et indices

1. **Indices de ligne et de colonne**

    * L’utilisateur entre une lettre (A, B ou C) pour la colonne → `col = lettre - 'A'`.
    * Il entre un chiffre (1, 2 ou 3) pour la ligne → `row = chiffre - '1'`.
    * Vérifiez toujours que `row` et `col` sont dans l’intervalle `[0, 2]` avant d’accéder à `board[row][col]`.

2. **Ordre d’exécution dans `play()`**

    * Vérifier d’abord le format (pour éviter les erreurs d’index).
    * Puis tenter de placer le symbole.
    * Si la case est déjà occupée, afficher un message et recommencer la boucle (sans changer de joueur).
    * Si le placement a réussi, vérifier la victoire et le match nul.
    * Si la partie continue, changer de joueur.

3. **Débogage**

    * Ajoutez des `System.out.println` intermédiaires pour afficher la valeur de `row`, `col` ou l’état de la grille afin de vérifier que vos indices sont corrects.
    * Testez d’abord avec des coups simples (ex. : X à A1, O à B2, X à A2, etc.) pour vous assurer que `placeMark` fonctionne comme attendu.

4. **Extensions possibles (partie libre)**

    * Gérer les majuscules et minuscules automatiquement (nous utilisons déjà `toUpperCase()`).
    * Afficher un message de bienvenue et expliquer les règles avant de lancer la boucle.
    * Permettre à l’utilisateur de rejouer une nouvelle partie après la fin de la première.
    * Ajouter un timer ou un nombre de tours maximum avant match nul.
    * Implémenter une IA basique pour jouer contre l’ordinateur (exercice avancé).

---

## Conseils pour progresser

* **Travailler par petites étapes** : commencez par `placeMark` puis testez-la indépendamment dans `main` en créant une `Grid` et en appelant `placeMark` et `print()`.
* **Tester chaque méthode isolément** : avant d’intégrer `checkWin` dans la boucle de jeu, créez une grille “sous-condition” où vous placez manuellement des symboles, appelez `checkWin('X')` et vérifiez que la méthode renvoie `true` si vous avez aligné trois ‘X’.
* **Utiliser un IDE** : Eclipse, IntelliJ ou NetBeans vous alerteront automatiquement sur les erreurs de compilation, la portée des variables et la syntaxe.
* **Relire régulièrement votre code** : comprenez chaque ligne avant de passer à la suivante, et n’hésitez pas à ajouter des commentaires pour clarifier votre raisonnement.

---

Généré à l'aide de ChatGPT o4-mini-high, le 2 juin 2025.
