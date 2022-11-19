package cl.uchile.dcc.finalreality.driver;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapons;
import java.util.ArrayList;
import java.util.Objects;



/**
 * A class which contains the logic of the game.
 */
public class FinalReality {

  private final ArrayList<PlayerCharacter> party;
  private final ArrayList<Enemy> enemies;
  private final ArrayList<Weapons> inventory;
  boolean isPlayerDead;
  boolean isEnemyDead;



  /**
   * Creates the game.
   *
   * @param party     An ArrayList of PlayerCharacter.
   * @param enemies   An ArrayList of Enemy.
   * @param inventory An ArrayList of Weapons.
   */
  public FinalReality(ArrayList<PlayerCharacter> party, ArrayList<Enemy> enemies,
                      ArrayList<Weapons> inventory) {
    this.party = party;
    this.enemies = enemies;
    this.inventory = inventory;

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
   * Checks if the game is not over.
   */
  public boolean isOver() {
    return deadPlayer() || deadEnemy();
  }

  public String toString() {
    return "FinalReality\n";
  }
}

