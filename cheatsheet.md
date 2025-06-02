# Java Cheat Sheet

Ce document propose un aperçu concis des notions de base de Java (déclarations, conditions, boucles, tableaux, classes) et une mini-section expliquant certaines méthodes utilisées dans l’atelier Morpion (ex. : `charAt`, `toUpperCase`, etc.).

---

## 1. Structure Générale d’un Fichier Java

```java
// Package (optionnel)
package mon.package;

// Imports (optionnels)
import java.util.Scanner;

public class MaClasse {
    // 1. Champs (variables d’instance ou static)
    private int monEntier;
    private static final double PI = 3.14;

    // 2. Constructeurs
    public MaClasse(int valeurInitiale) {
        this.monEntier = valeurInitiale;
    }

    // 3. Méthodes (fonctions associées à la classe)
    public void afficherValeur() {
        System.out.println("Valeur : " + monEntier);
    }

    // 4. Point d’entrée (main)
    public static void main(String[] args) {
        MaClasse obj = new MaClasse(42);
        obj.afficherValeur();
    }
}
```

* **`public class MaClasse`** : déclaration d’une classe publique nommée `MaClasse`.
* **Champs** : variables stockées dans l’objet ou dans la classe (`static`).
* **Constructeur** : méthode spéciale sans type de retour, nommée comme la classe, appelée à l’instanciation.
* **Méthodes** : fonctions membres qui peuvent prendre des paramètres et retourner un résultat.
* **`main(String[] args)`** : méthode statique qui sert de point d’entrée à l’application.

---

## 2. Déclarations et Types Primitifs

### 2.1 Types Primitifs

| Type      | Taille  | Valeurs possibles                                                |
| --------- | ------- | ---------------------------------------------------------------- |
| `int`     | 32 bits | Entiers (−2 147 483 648 à 2 147 483 647)                         |
| `long`    | 64 bits | Entiers (−9 223 372 036 854 775 808 à 9 223 372 036 854 775 807) |
| `short`   | 16 bits | Entiers (−32 768 à 32 767)                                       |
| `byte`    | 8 bits  | Entiers (−128 à 127)                                             |
| `float`   | 32 bits | Virgule flottante (simple précision)                             |
| `double`  | 64 bits | Virgule flottante (double précision)                             |
| `char`    | 16 bits | Caractère Unicode (ex : `'A'`, `'\n'`)                           |
| `boolean` | 1 bit   | `true` ou `false`                                                |

### 2.2 Déclaration et Initialisation

```java
// Déclaration sans initialisation (valeur par défaut = 0/false/'\0')
int    entier;  
double reel;    
boolean flag;   
char   lettre;  

// Déclaration + initialisation
int    x = 10;
double pi = 3.14159;
boolean estVrai = false;
char   c = 'Z';

// Chaîne de caractères (non primitif, objet)
String texte = "Bonjour Java !";
```

---

## 3. Opérateurs et Expressions

### 3.1 Opérateurs arithmétiques

```java
int a = 5, b = 2;
int somme     = a + b;    // 7
int difference= a - b;    // 3
int produit   = a * b;    // 10
int quotient  = a / b;    // 2  (division entière)
int reste     = a % b;    // 1  (modulo)
double div    = (double) a / b; // 2.5 (cast en double)
```

### 3.2 Opérateurs de comparaison

```java
a == b;   // égalité
a != b;   // différent
a < b;    // strictement moins
a <= b;   // moins ou égal
a > b;    // strictement plus
a >= b;   // plus ou égal
```

### 3.3 Opérateurs logiques

```java
boolean p = true, q = false;
p && q;   // ET logique (false)
p || q;   // OU logique (true)
!p;       // NON logique (false)
```

### 3.4 Opérateurs d’affectation

```java
int n = 0;
n += 5;   // équivalent à n = n + 5
n -= 2;   // équivalent à n = n - 2
n *= 3;   // équivalent à n = n * 3
n /= 4;   // équivalent à n = n / 4
n %= 3;   // équivalent à n = n % 3
```

---

## 4. Conditions (`if`, `else if`, `else`, `switch`)

### 4.1 `if` / `else if` / `else`

```java
int score = 75;

if (score >= 90) {
    System.out.println("Excellent !");
} 
else if (score >= 75) {
    System.out.println("Bien joué !");
} 
else if (score >= 50) {
    System.out.println("Passable.");
} 
else {
    System.out.println("Échec.");
}
```

* Le bloc `if` s’exécute si la condition (entre parenthèses) est vraie.
* `else if` permet de tester une deuxième condition si la précédente est fausse.
* `else` final couvre tous les cas restants.

### 4.2 `switch`

```java
char lettre = 'B';

switch (lettre) {
    case 'A':
        System.out.println("Vous avez tapé A");
        break;
    case 'B':
        System.out.println("Vous avez tapé B");
        break;
    case 'C':
        System.out.println("Vous avez tapé C");
        break;
    default:
        System.out.println("Lettre non reconnue");
        break;
}
```

* Chaque `case` teste une valeur constante (entier, char ou String).
* **`break`** est nécessaire pour sortir du `switch` après exécution d’un bloc.
* `default` est optionnel et s’exécute si aucun `case` ne correspond.

---

## 5. Boucles

### 5.1 `for`

```java
// Boucle classique de 0 à 4
for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}

// Parcourir un tableau (indice + valeur)
int[] tab = {10, 20, 30};
for (int i = 0; i < tab.length; i++) {
    System.out.println("tab[" + i + "] = " + tab[i]);
}
```

### 5.2 `for-each`

```java
String[] fruits = {"Pomme", "Banane", "Cerise"};
for (String fruit : fruits) {
    System.out.println(fruit);
}
```

* Syntaxe simplifiée : pour chaque élément (`fruit`) dans le tableau `fruits`.

### 5.3 `while`

```java
int compteur = 0;
while (compteur < 3) {
    System.out.println("compteur = " + compteur);
    compteur++;
}
```

* On vérifie la condition avant d’entrer dans le bloc.
* Si la condition est fausse dès le départ, le bloc n’est pas exécuté.

### 5.4 `do-while`

```java
int x = 0;
do {
    System.out.println("x = " + x);
    x++;
} while (x < 3);
```

* Le bloc s’exécute au moins une fois, puis la condition est testée en fin de boucle.

---

## 6. Tableaux (Arrays)

### 6.1 Déclaration et Initialisation

```java
// 1) Déclaration sans taille (références à assigner ensuite)
int[]    tabEntiers;
String[] tabChaines;

// 2) Création avec taille fixe (valeurs par défaut = 0 ou null)
tabEntiers = new int[5];      // indices 0 à 4
tabChaines = new String[3];   // indices 0 à 2

// 3) Déclaration + initialisation littérale
int[]    tab = {1, 2, 3, 4};
String[] noms = {"Alice", "Bob", "Charlie"};
```

### 6.2 Accès et Longueur

```java
int[] valeurs = {10, 20, 30};
int premier = valeurs[0];     // 10
int taille  = valeurs.length; // 3
valeurs[2] = 50;              // modifie la 3ᵉ case
```

* Les indices vont de `0` à `length - 1`.
* Tenter d’accéder à un indice hors bornes (`valeurs[5]`) provoque une `ArrayIndexOutOfBoundsException`.

---

## 7. Chaînes de Caractères (String)

### 7.1 Déclaration et Concaténation

```java
String a = "Java";
String b = "Cheat Sheet";
String message = a + " " + b; // "Java Cheat Sheet"
```

### 7.2 Quelques Méthodes Utiles

| Méthode                                  | Description                                                        |
| ---------------------------------------- | ------------------------------------------------------------------ |
| `int length()`                           | Renvoie la longueur de la chaîne (nombre de caractères).           |
| `char charAt(int index)`                 | Renvoie le caractère à l’indice spécifié (0-based).                |
| `String substring(int begin)`            | Renvoie la sous-chaîne à partir de `begin` jusqu’à la fin.         |
| `String substring(int b, int e)`         | Renvoie la sous-chaîne \[b, e) (e non inclus).                     |
| `boolean equals(String other)`           | Compare le contenu (sensible à la casse).                          |
| `boolean equalsIgnoreCase(String other)` | Compare le contenu (insensible à la casse).                        |
| `String toUpperCase()`                   | Retourne une nouvelle chaîne en majuscules.                        |
| `String toLowerCase()`                   | Retourne une nouvelle chaîne en minuscules.                        |
| `String trim()`                          | Supprime les espaces en début et fin de chaîne.                    |
| `boolean contains(String s)`             | Renvoie `true` si la chaîne contient la sous-chaîne `s`.           |
| `String replace(char old, char neu)`     | Remplace tous les caractères `old` par `neu`.                      |
| `String[] split(String regex)`           | Coupe la chaîne selon le séparateur `regex` et renvoie un tableau. |

**Exemples :**

```java
String s = "  Bonjour123  ";
int len = s.length();                     // 12 (espaces comptés)
char c = s.charAt(3);                     // 'n'
String sub = s.substring(2, 8);           // "njour1"
String up = s.toUpperCase();              // "  BONJOUR123  "
String low = s.trim().toLowerCase();      // "bonjour123"
boolean b1 = s.contains("jour");          // true
String[] parts = "A,B,C".split(",");      // {"A", "B", "C"}
```

---

## 8. Entrée/Sortie Basique

### 8.1 Affichage à l’écran

```java
System.out.print("Texte sans saut de ligne");
System.out.println("Texte avec saut de ligne");
System.out.printf("Valeur : %d et %.2f%n", 42, 3.1415);
```

* `printf` utilise des spécificateurs de format (ex : `%d`, `%s`, `%f`) et permet une mise en forme précise.

### 8.2 Lecture au Clavier

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);

System.out.print("Entrez un entier : ");
int entier = scanner.nextInt();

scanner.nextLine(); // Consomme le « newline » restant

System.out.print("Entrez une chaîne : ");
String ligne = scanner.nextLine();

scanner.close();
```

* **`nextInt()`**, **`nextDouble()`**, **`nextBoolean()`**, **`nextLine()`**, etc.
* Attention à la gestion du « newline » après `nextInt()` : souvent on appelle `scanner.nextLine()` pour consommer la fin de ligne avant de lire une chaîne entière.

---

## 9. Classes, Objets et Méthodes

### 9.1 Déclaration d’une Classe

```java
public class Exemple {
    // Champs / Attributs
    private String nom;
    private int age;

    // Constructeur
    public Exemple(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    // Méthode d’instance (ne modifie pas forcément l’objet)
    public void afficherInfo() {
        System.out.println("Nom : " + nom + ", Age : " + age);
    }

    // Méthode statique (appartenant à la classe, pas à une instance)
    public static int ajouter(int a, int b) {
        return a + b;
    }
}
```

### 9.2 Création d’un Objet et Appel de Méthodes

```java
Exemple ex = new Exemple("Alice", 30);
ex.afficherInfo();           // Affiche : Nom : Alice, Age : 30

int sum = Exemple.ajouter(5, 7); // sum = 12
```

* **`new Exemple(...)`** : appelle le constructeur et renvoie une instance.
* On peut appeler `ex.afficherInfo()` pour invoquer une méthode d’instance.
* Les méthodes statiques s’appellent depuis la classe `Exemple.ajouter(...)`.

---

## 10. Gestion des Exceptions (try / catch)

```java
try {
    int resultat = 10 / 0; // Provoque une ArithmeticException
    System.out.println("Ce code ne s’exécute pas si exception");
}
catch (ArithmeticException e) {
    System.out.println("Erreur arithmétique : division par zéro");
}
catch (Exception e) {
    System.out.println("Une autre exception est survenue : " + e.getMessage());
}
finally {
    System.out.println("Ce bloc s’exécute toujours, exception ou non.");
}
```

* **`try`** : bloc où une exception peut se produire.
* **`catch`** : bloc qui intercepte une exception spécifique (ou générique).
* **`finally`** : bloc optionnel, exécuté dans tous les cas (pour nettoyer, fermer des ressources, etc.).

---

## 11. Mini-Section : Méthodes Utilisées dans le Projet Morpion

Pour rappel, voici quelques méthodes ou appels de la version Morpion :

1. **`String input = scanner.nextLine().trim().toUpperCase();`**

    * `nextLine()` : lit la ligne entière tapée par l’utilisateur (jusqu’au `\n`).
    * `trim()` : supprime les espaces en début et fin de chaîne (utile si l’utilisateur tape des espaces accidentels).
    * `toUpperCase()` : convertit la chaîne en majuscules (permet d’accepter « a1 » comme « A1 »).

2. **`input.charAt(0)` et `input.charAt(1)`**

    * `charAt(int index)` : renvoie le caractère à l’indice donné (0-based).
    * Dans « A1 », `charAt(0)` renvoie `'A'` et `charAt(1)` renvoie `'1'`.

3. **`input.charAt(0) - 'A'` et `input.charAt(1) - '1'`**

    * En Java, un `char` peut être converti en entier (code Unicode).
    * `'A'` vaut 65 en code ASCII/Unicode, `'B'` vaut 66, etc.
    * `'A' - 'A' = 0`, `'B' - 'A' = 1` → on obtient l’indice de colonne.
    * De même, `'1'` vaut 49, `'2'` vaut 50, etc., donc `'1' - '1' = 0` → indice de ligne.

4. **`grid.checkWin(currentPlayer.getSymbol())`**

    * Vérifie si trois symboles (`'X'` ou `'O'`) sont alignés dans la grille.
    * Itère sur les lignes, colonnes, et deux diagonales.

5. **`grid.isFull()`**

    * Parcourt toutes les cases du tableau `char[][]`; si l’une vaut `'\0'`, retourne `false`.
    * Si aucune case vide, retourne `true` → match nul.

6. **`System.out.println(...)` et `System.out.print(...)`**

    * `println` ajoute automatiquement un saut de ligne après le texte.
    * `print` n’ajoute pas de saut de ligne (utile pour laisser l’utilisateur saisir sur la même ligne).

---

## 12. Quelques Bonnes Pratiques

* **Nommer clairement** : classes en `PascalCase` (ex. : `Grid`, `Game`), variables et méthodes en `camelCase` (ex. : `placeMark`, `currentPlayer`).
* **Conserver la cohérence** : idem pour l’indentation (2 ou 4 espaces), et le style des accolades `{ }`.
* **Vérifier les limites de tableaux** : avant d’accéder à `array[index]`, toujours s’assurer que `0 ≤ index < array.length`.
* **Fermer les ressources** : si vous ouvrez un `Scanner`, appelez `scanner.close()` à la fin pour libérer la ressource.
* **Séparer responsabilités** : une classe ne doit avoir qu’une seule responsabilité (ex. : `Grid` gère uniquement l’état du plateau, `Game` gère la boucle de jeu, `Player` stocke simplement nom + symbole).

---

### Fin de la Cheat Sheet

Vous disposez maintenant d’un résumé des bases du langage Java, ainsi que d’explications sur les méthodes-clés employées dans l’atelier Morpion. Utilisez ce document comme référence rapide lors de vos développements. Bon codage !
