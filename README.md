**Final Reality**
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

**Context**
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---


## **Classes**

### **AbstractEntity**
**protected AbstractEntity(final String name)**

An abstract class that holds the common behaviour of all the entities in the game.


**Methods**

- **public String getName():** Returns the name of the entity.



## **Model**

## **Character**

### **< interface > GameCharacter**
An interface which represents a character from the game. A character can be controlled by the player or by the CPU (an enemy).

**Methods**

- **void waitTurn():** Sets a scheduled executor to make this character (thread) wait for {@code speed / 10} seconds before adding the character to the queue.
- **String getName():** Returns this character's name.
- **getCurrentHp():**  Returns this character's current HP.
- **int getMaxHp():** Returns this character's max HP.
- **int getDefense():** Returns this character's defense.
- **setCurrentHp(int hp) throws InvalidStatValueException:** Sets this character's current HP to {@code newHp}.
- **void setWaitTurn():** Sets wait turn depending on the case.

### **AbstractCharacter**
Extends AbstractEntity, implements GameCharacter. An abstract class that holds the common behaviour of all the characters in the game.

 **AbstractCharacter(@NotNull String name, int maxHp, int defense,
      @NotNull BlockingQueue< GameCharacter > turnsQueue) throws InvalidStatValueException**

**Methods**

- **@Override public void waitTurn()**
- **protected void addToQueue():** Adds this character to the turns queue.
- **@Override public int getMaxHp()**
- **@Override public int getDefense()**
- **@Override public void setCurrentHp(int hp) throws InvalidStatValueException**


### **Enemy**
Extends AbstractCharacter. Creates a new enemy with a name, a weight and the queue with the characters ready to play.

**public Enemy(@NotNull final String name, final int weight, int maxHp, int defense,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException**

**Methods**

- **public int getWeight():** Returns the weight of this enemy.
- **public void setWaitTurn():** Sets waitTurn depending on the class.

### **< interface > PlayerCharacter**
An interface with the method equip(Weapon weapon).

**Methods**

- **void equip(Weapon weapon) throws InvalidStatValueException:** Equips a weapon to the character.
- **void equipAxe(Axe axe) throws InvalidStatValueException:** Equips an axe to the character.
- **void equipBow(Bow bow) throws InvalidStatValueException:** Equips a bow to the character.
- **void equipKnife(Knife knife) throws InvalidStatValueException:** Equips a knife to the character.
- **void equipStaff(Staff staff) throws InvalidStatValueException:** Equips a staff to the character.
- **void equipSword(Sword sword) throws InvalidStatValueException:** Equips a sword to the character.
- **Weapon getEquippedWeapon():** Return this character's equipped weapon.

### **AbstractPlayerCharacter**
Extends AbstractCharacter, implements PlayerCharacter. An abstract class that holds all the information of a player-controlled character in the game.

**protected AbstractPlayerCharacter(@NotNull final String name, final int maxHp,
                                    final int defense,
                                    @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException**

**Methods**

- **@Override public Weapon getEquippedWeapon()**
- **public void setWaitTurn():** Sets waitTurn depending on the class.
- **@Override public void equip(Weapon weapon) throws InvalidStatValueException**
- **@Override void equipAxe(Axe axe) throws InvalidStatValueException**
- **@Override void equipBow(Bow bow) throws InvalidStatValueException**
- **@Override void equipKnife(Knife knife) throws InvalidStatValueException**
- **@Override void equipStaff(Staff staff) throws InvalidStatValueException**
- **@Override void equipSword(Sword sword) throws InvalidStatValueException**





### **AbstractCommonCharacter**
Extends AbstractPlayerCharacter. An abstract class that holds all the information of a common character in the game.

**protected AbstractCommonCharacter(final @NotNull String name, final int maxHp,
                                    final int defense,
                                    final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException**

**Methods**



### **AbstractMage**
Extends AbstractPlayerCharacter. An abstract class that holds all the information of a mage character in the game.

**protected AbstractMage(final @NotNull String name, final int maxHp,
                         final int defense, int maxMp,
                         final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException**

**Methods**

- **public int getCurrentMp():** Returns the current MP of the character.
- **public void setCurrentMp(final int newMp) throws InvalidStatValueException:** Sets the current MP of the character to {@code newMp}.



### **BlackMage**
Extends AbstractMage. Creates a new Black Mage.

**public BlackMage(final @NotNull String name, final int maxHp, final int defense,
      int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException**

**Methods**
- **@Override public boolean equals(final Object o)**
- **@Override public int hashCode()**
- **@Override public String toString()**
- **@Override public void equipKnife(Knife knife)**
- **@Override public void equipStaff(Staff staff)** 


### **WhiteMage**
Extends AbstractMage. Creates a new White Mage.

**public WhiteMage(final @NotNull String name, final int maxHp, final int defense,
      int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException**

**Methods**
- **@Override public boolean equals(final Object o)**
- **@Override public int hashCode()**
- **@Override public String toString()**
- **@Override public void equipStaff(Staff staff)**

### **Engineer**
Extends AbstractCommonCharacter. Creates a new engineer.

**public Engineer(final @NotNull String name, final int maxHp, final int defense,
      final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException**

**Methods**
- **@Override public boolean equals(final Object o)**
- **@Override public int hashCode()**
- **@Override public String toString()**
- **@Override public void equipAxe(Axe axe)**
- **@Override public void equipBow(Bow bow)**



### **Knight**
Extends AbstractCommonCharacter. Creates a new knight.

**public Knight(@NotNull final String name, int maxHp, int defense,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException**

**Methods**
- **@Override public boolean equals(final Object o)**
- **@Override public int hashCode()**
- **@Override public String toString()**
- **@Override public void equipSword(Sword sword)**
- **@Override public void equipAxe(Axe axe)**
- **@Override public void equipKnife(Knife knife)**



### **Thief**
Extends AbstractCommonCharacter. Creates a new thief.

**public Thief(final @NotNull String name, final int maxHp, final int defense,
      final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException**

**Methods**
- **@Override public boolean equals(final Object o)**
- **@Override public int hashCode()**
- **@Override public String toString()**
- **@Override public void equipSword(Sword sword)**
- **@Override public void equipKnife(Knife knife)**
- **@Override public void equipBow(Bow bow)**











## **Object**

### **AbstractObject**
Extends AbstractEntity. An abstract class that holds the common behaviour of all the objects in the game.

**public AbstractObject(final String name, int weight)**

**Methods**
- **public int getWeight():** Returns the weight of the weapon.

### **< interface > Equip**
Handles a PlayerCharacter in order to determinate if it can be equipped by a valid character.

**Methods**
- **void handle(PlayerCharacter playerCharacter) throws InvalidStatValueException:** Handles the type of player.

### **Weapon**
Extends AbstractObject, implements Equip. An abstract class that holds all the information of a weapon.

**public Weapon(final String name, final int damage, final int weight)**

**Methods**
- **@Override public String getName()**
- **public int getDamage():** Returns the weapon's damage.
- **@Override public abstract void handle(PlayerCharacter playerCharacter) throws InvalidStatValueException**



### **Axe**
A class that holds all the information of an axe.

**public Axe(String name, int damage, int weight)**

**Methods**
- **@Override public boolean equals(final Object o)**
- **@Override public int hashCode()**
- **@Override public String toString()** 
- **@Override public void handle(PlayerCharacter playerCharacter) throws InvalidStatValueException:** Handles its type in a way the method in AbstractPlayerCharacher equip(Weapon weapon) can determinate which type of weapon it's being equipped.



### **Bow**
A class that holds all the information of a bow.

**Methods**
- **@Override public boolean equals(final Object o)**
- **@Override public int hashCode()**
- **@Override public String toString()**
- **@Override public void handle(PlayerCharacter playerCharacter) throws InvalidStatValueException:** Handles its type in a way the method in AbstractPlayerCharacher equip(Weapon weapon) can determinate which type of weapon it's being equipped.


### **Knife**
A class that holds all the information of a knife.

**Methods**
- **@Override public boolean equals(final Object o)**
- **@Override public int hashCode()**
- **@Override public String toString()**
- **@Override public void handle(PlayerCharacter playerCharacter) throws InvalidStatValueException:** Handles its type in a way the method in AbstractPlayerCharacher equip(Weapon weapon) can determinate which type of weapon it's being equipped.



### **Staff**
A class that holds all the information of a staff.

**Methods**
- **@Override public boolean equals(final Object o)**
- **@Override public int hashCode()**
- **@Override public String toString()**
- **@Override public void handle(PlayerCharacter playerCharacter) throws InvalidStatValueException:** Handles its type in a way the method in AbstractPlayerCharacher equip(Weapon weapon) can determinate which type of weapon it's being equipped.



### **Sword**
A class that holds all the information of a sword.

**Methods**
- **@Override public boolean equals(final Object o)**
- **@Override public int hashCode()**
- **@Override public String toString()**
- **@Override public void handle(PlayerCharacter playerCharacter) throws InvalidStatValueException:** Handles its type in a way the method in AbstractPlayerCharacher equip(Weapon weapon) can determinate which type of weapon it's being equipped.

## **Exceptions**

### **InvalidStatException**
This error is used to represent an invalid stat value.

**public InvalidStatValueException(String description)**

### **Require**
Checks if a given <i>Stat</i> value is <b>at least</b> a given value.

**public static void statValueAtLeast(int least, int actualStat, String statName)
      throws InvalidStatValueException**

Checks if a given <i>Stat</i> value is <b>at most</b> a given value.

**public static void statValueAtMost(final int most, final int actualStat,
      final String statName) throws InvalidStatValueException**

## **Tests**

### **MainTest**
A class which has all the tests of the project.

