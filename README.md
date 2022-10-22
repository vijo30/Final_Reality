Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---


## Classes

## Abstract Entity
An abstract class that holds the common behaviour of all the entities in the game.

## Model

## Character

### AbstractCharacter
An abstract class that holds the common behaviour of all the characters in the game.

### Enemy
Creates a new enemy with a name, a weight and the queue with the characters ready to play.

### GameCharacter
An interface which represents a character from the game. A character can be controlled by the player or by the CPU (an enemy).

### AbstractPlayerCharacter
An abstract class that holds all the information of a player-controlled character in the game.

### AbstractCommonCharacter
An abstract class that holds all the information of a common character in the game.

### AbstractMage
An abstract class that holds all the information of a mage character in the game.

### BlackMage
Creates a new Black Mage.

### Engineer
Creates a new engineer.

### Knight
Creates a new knight.

### Thief
Creates a new thief.

### WhiteMage
Creates a new White Mage.

### PlayerCharacter
An interface with the method equip(Weapon weapon).

## Object

### AbstractObject
An abstract class that holds the common behaviour of all the objects in the game.

### Weapon
An abstract class that holds all the information of a weapon.

### Axe
A class that holds all the information of an axe.

### Bow
A class that holds all the information of a bow.

### Knife
A class that holds all the information of a knife.

### Staff
A class that holds all the information of a staff.

### Sword
A class that holds all the information of a sword.

## Tests

### MainTest
A class which has all the tests of the project.

