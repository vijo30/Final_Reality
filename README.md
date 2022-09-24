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


## Tests

### Timer Example
A test class with the purpose of being an example of use for the timer.

### Main
A class that is meant for generic testing.


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
A class that holds all the information of a player-controlled character in the game.

### AbstractCommonCharacter
A class that holds all the information of a common character in the game.

### AbstractMage
A class that holds all the information of a mage character in the game.

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
A class that holds all the information of a weapon.

### WeaponType
Enumeration of all the weapon types.

## User

### AbstractPlayer
An abstract class that holds the common behaviour of all players in the game.

### Player
A class that holds all the information of a single player of the game.


## Exceptions

### InvalidStatValueException
This error is used to represent an invalid stat value.

### Require
Class containing a series of methods to check if a condition is met. If the condition is not met, an exception is thrown.

