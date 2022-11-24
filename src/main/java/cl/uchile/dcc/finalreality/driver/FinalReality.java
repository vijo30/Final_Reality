package cl.uchile.dcc.finalreality.driver;


import cl.uchile.dcc.finalreality.exceptions.InvalidSkillException;
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

 *
 * @author <a href="https://github.com/vijo30">V30</a>
 * @author ~José Videla~
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
    assert party.size() <= 5 && enemies.size() <= 10;
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
    return getParty().equals(that.getParty()) && getEnemies().equals(that.getEnemies())
        && Objects.equals(getInventory(), that.getInventory())
        && getPlayer().equals(that.getPlayer());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getParty(), getEnemies(), getInventory(), getPlayer());
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
      throws IOException, InvalidStatValueException, InterruptedException, InvalidSkillException {
    LinkedBlockingQueue<GameCharacter> queue = party.get(0).getQueue();
    if (queue.isEmpty()) {
      refillQueue();
    }
    GameCharacter character = queue.poll();
    assert character != null;
    character.setTurn(character.getTurn() + 1);
    int turn = character.getTurn();
    System.out.println("Character: " + character.getName() + " | Turn: " + turn);
    int turnEffect = character.getTurnEffect();
    if (character.isParalyzed() && (turn - turnEffect == 2)) {
      character.undo();
      System.out.println(character.getName() + " is no longer paralyzed.");
    }
    character.applyEffect();
    if (character.getCurrentHp() > 0 && !character.isParalyzed()) {
      character.execute(this, character);
    }

  }




  /**
   * A party member attacks an enemy based on what's written in line.
   */
  public void attackEnemy(String line, PlayerCharacter partyMember)
      throws InvalidStatValueException {
    boolean found = false;
    for (Enemy enemy : enemies) {
      if (line.equals(enemy.getName())) {
        System.out.print(partyMember.getName() + " attacks "
            + enemy.getName() + " dealing ");
        partyMember.attack(enemy);
        found = true;
      }
    }
    if (!found) {
      throw new InvalidStatValueException("Enemy not found.");
    }

  }

  /**
   * A party member casts a spell to an enemy.
   */
  public void castSpell(String line, String line2, PlayerCharacter partyMember)
      throws InvalidStatValueException, InvalidSkillException {
    try {
      switch (line) {
        case "T" -> castSpellThunder(line2, partyMember);
        case "F" -> castSpellFire(line2, partyMember);
        case "H" -> castSpellHeal(line2, partyMember);
        case "Po" -> castSpellPoison(line2, partyMember);
        case "Pa" -> castSpellParalysis(line2, partyMember);
        default -> throw new InvalidStatValueException("Invalid option.");
      }
    } catch (InvalidSkillException e) {
      throw new InvalidSkillException("Invalid skill.");
    }

  }

  private void castSpellThunder(String line2, PlayerCharacter partyMember)
      throws InvalidSkillException, InvalidStatValueException {
    boolean found = false;
    for (Enemy enemy : enemies) {
      if (line2.equals(enemy.getName())) {
        found = true;
        partyMember.castThunder(enemy);
      }
    }
    if (!found) {
      throw new InvalidStatValueException("Enemy not found.");
    }
  }

  private void castSpellFire(String line2, PlayerCharacter partyMember)
      throws InvalidSkillException, InvalidStatValueException {
    boolean found = false;
    for (Enemy enemy : enemies) {
      if (line2.equals(enemy.getName())) {
        found = true;
        partyMember.castFire(enemy);
      }
    }
    if (!found) {
      throw new InvalidStatValueException("Enemy not found.");
    }
  }

  private void castSpellHeal(String line2, PlayerCharacter partyMember)
      throws InvalidSkillException, InvalidStatValueException {
    boolean found = false;
    for (PlayerCharacter ally : party) {
      if (line2.equals(ally.getName())) {
        found = true;
        partyMember.castHeal(ally);
      }
    }
    if (!found) {
      throw new InvalidStatValueException("Ally not found.");
    }

  }

  private void castSpellPoison(String line2, PlayerCharacter partyMember)
      throws InvalidSkillException, InvalidStatValueException {
    boolean found = false;
    for (Enemy enemy : enemies) {
      if (line2.equals(enemy.getName())) {
        found = true;
        partyMember.castPoison(enemy);
      }
    }
    if (!found) {
      throw new InvalidStatValueException("Enemy not found.");
    }
  }

  private void castSpellParalysis(String line2, PlayerCharacter partyMember)
      throws InvalidSkillException, InvalidStatValueException {
    boolean found = false;
    for (Enemy enemy : enemies) {
      if (line2.equals(enemy.getName())) {
        found = true;
        partyMember.castParalysis(enemy);
      }
    }
    if (!found) {
      throw new InvalidStatValueException("Enemy not found.");
    }
  }

  /**
   * Equips a weapon, if it exists and if the character can equip it.
   */
  public void equip(String line, PlayerCharacter partyMember) throws InvalidStatValueException {
    assert !inventory.isEmpty();
    boolean found = false;
    for (Weapons weapon : inventory) {
      if (line.equals(weapon.getName())) {
        System.out.println(partyMember.getName() + " equips "
            + weapon.getName() + "!");
        System.out.println(partyMember.getEquippedWeapon().getName() + " is now in the inventory.");
        inventory.add(partyMember.getEquippedWeapon());
        partyMember.equip(weapon);
        inventory.remove(weapon);
        found = true;

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
    ArrayList<PlayerCharacter> party = getParty();
    int index = (int) (Math.random() * party.size());
    PlayerCharacter partyMember = party.get(index);
    System.out.print(character.getName() + " attacks "
        + partyMember.getName() + " dealing ");
    character.attack(partyMember);
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

