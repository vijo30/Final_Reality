package cl.uchile.dcc.finalreality.driver;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapons;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * A class which contains the logic of the game.
 */
public class FinalReality {

  private final ArrayList<PlayerCharacter> party;
  private final ArrayList<Enemy> enemies;
  private final ArrayList<Weapons> inventory;
  private final Player player;
  boolean isPlayerDead;
  boolean isEnemyDead;



  /**
   * Creates the game.
   *
   * @param party     An ArrayList of PlayerCharacter.
   * @param enemies   An ArrayList of Enemy.
   * @param inventory An ArrayList of Weapons.
   * @param player    A player.
   */
  public FinalReality(ArrayList<PlayerCharacter> party, ArrayList<Enemy> enemies,
                      ArrayList<Weapons> inventory, Player player) throws InterruptedException {
    assert !party.isEmpty() && !enemies.isEmpty();
    assert party.size() <= 5 && enemies.size() <= 5;
    this.party = party;
    this.enemies = enemies;
    this.inventory = inventory;
    this.player = player;
    for (PlayerCharacter character : party) {
      character.waitTurn();
    }
    for (Enemy enemy : enemies) {
      enemy.waitTurn();
    }
    Thread.sleep(5000);

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinalReality that = (FinalReality) o;
    return Objects.equals(getParty(), that.getParty())
        && Objects.equals(getEnemies(), that.getEnemies())
        && Objects.equals(getInventory(), that.getInventory());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getParty(), getEnemies(), getInventory());
  }


  public ArrayList<PlayerCharacter> getParty() {
    return party;
  }

  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  public ArrayList<Weapons> getInventory() {
    return inventory;
  }

  public Player getPlayer() {
    return player;
  }

  /**
   * Checks if all players' characters are dead.
   */
  public boolean deadPlayer() {
    isPlayerDead = true;
    for (PlayerCharacter playerCharacter : party) {
      isPlayerDead &= playerCharacter.getCurrentHp() <= 0;
    }
    return isPlayerDead;
  }

  /**
   * Checks if all enemies' characters are dead.
   */
  public boolean deadEnemy() {
    isEnemyDead = true;
    for (Enemy enemy : enemies) {
      isEnemyDead &= enemy.getCurrentHp() <= 0;
    }
    return isEnemyDead;
  }

  /**
   * Checks if the game is over.
   */
  public boolean isOver() {
    return deadPlayer() || deadEnemy();
  }

  /**
   * Updates the game state.
   */
  public void update()
      throws IOException, InvalidStatValueException, InterruptedException {
    LinkedBlockingQueue<GameCharacter> queue = party.get(0).getQueue();
    if (queue.isEmpty()) {
      refillQueue();
    }
    GameCharacter character = queue.poll();
    Objects.requireNonNull(character).execute(this, character);
  }

  public String toString() {
    return "FinalReality\n";
  }


  /**
   * A party member attacks an enemy named by what's written in line.
   */
  public void attackEnemy(String line, PlayerCharacter partyMember)
      throws InvalidStatValueException {
    assert !this.isOver();
    boolean found = false;
    for (Enemy enemy : enemies) {
      if (line.equals(enemy.getName())) {
        int hp = enemy.getCurrentHp();
        int weaponDamage = partyMember.getEquippedWeapon().getDamage();
        int enemyDefense = enemy.getDefense();
        int realDamage = weaponDamage - enemyDefense;
        int newHp = Math.max(0, hp - realDamage);
        enemy.setCurrentHp(newHp);
        System.out.println(partyMember.getName() + " attacks "
            + enemy.getName() + " dealing " + realDamage + " damage!");
        found = true;
      }
    }
    if (!found) {
      throw new InvalidStatValueException("Enemy not found.");
    }

  }

  public void castSpell(String line, PlayerCharacter partyMember) {
    assert !this.isOver();

  }

  /**
   * Equips a weapon, if it exists and if the character can equip it.
   */
  public void equip(String line, PlayerCharacter partyMember) throws InvalidStatValueException {
    assert !this.isOver();
    assert !inventory.isEmpty();
    boolean found = false;
    for (Weapons weapon : inventory) {
      if (line.equals(weapon.getName())) {
        partyMember.equip(weapon);
        found = true;
        System.out.println(partyMember.getName() + " equips "
            + weapon.getName() + "!");
      }
    }
    if (!found) {
      throw new InvalidStatValueException("Weapon not found.");
    }

  }

  /**
   * An enemy attacks a random party member.
   */
  public void attackParty(GameCharacter character) throws InvalidStatValueException {
    assert !this.isOver();
    ArrayList<PlayerCharacter> party = getParty();
    int index = (int) (Math.random() * party.size());
    PlayerCharacter partyMember = party.get(index);
    int hp = partyMember.getCurrentHp();
    int enemyDamage = 20;
    int memberDefense = partyMember.getDefense();
    int realDamage = (enemyDamage - memberDefense);
    int newHp = Math.max(0, hp - (enemyDamage - memberDefense));
    partyMember.setCurrentHp(newHp);
    System.out.println(character.getName() + " attacks "
        + partyMember.getName() + " dealing " + realDamage + " damage!");
  }

  /**
   * Refills the queue.
   */
  public void refillQueue() throws InterruptedException {
    for (PlayerCharacter character : party) {
      character.waitTurn();
    }
    for (Enemy enemy : enemies) {
      enemy.waitTurn();
    }
    Thread.sleep(5000);
  }


}

