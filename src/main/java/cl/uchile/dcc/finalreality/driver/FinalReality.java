package cl.uchile.dcc.finalreality.driver;


import cl.uchile.dcc.finalreality.driver.states.Init;
import cl.uchile.dcc.finalreality.driver.states.StateFinalReality;
import cl.uchile.dcc.finalreality.exceptions.InvalidInputException;
import cl.uchile.dcc.finalreality.exceptions.InvalidSkillException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetException;
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
  private StateFinalReality state;







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
    this.setState(new Init());

  }

  @SuppressWarnings("checkstyle:ParameterName")
  public void setState(StateFinalReality aState) {
    state = aState;
    state.setFinalReality(this);
  }

  public void init() {
    state.init();
  }

  public void playerIdle() {
    state.playerIdle();
  }

  public void playerAttack() {
    state.playerAttack();
  }

  public void enemyIdle() {
    state.enemyIdle();
  }

  public void enemyAttack() {
    state.enemyAttack();
  }
  

  public void playerEquip() {
    state.playerEquip();
  }

  public void playerCast() {
    state.playerCast();
  }

  public boolean isInit() {
    return state.isInit();
  }

  public boolean isPlayerIdling() {
    return state.isPlayerIdling();
  }

  public boolean isPlayerAttacking() {
    return state.isPlayerAttacking();
  }

  public boolean isEnemyIdling() {
    return state.isEnemyIdling();
  }

  public boolean isEnemyAttacking() {
    return state.isEnemyAttacking();
  }
  

  public boolean isPlayerEquipping() {
    return state.isPlayerEquipping();
  }

  public boolean isPlayerCasting() {
    return state.isPlayerCasting();
  }

  public void execute(GameCharacter gameCharacter)
      throws InvalidStatValueException, IOException, InvalidSkillException, InvalidInputException,
      InvalidTargetException {
    state.execute(gameCharacter);
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
      throws IOException, InvalidStatValueException, InterruptedException, InvalidSkillException,
      InvalidInputException, InvalidTargetException {
    LinkedBlockingQueue<GameCharacter> queue = party.get(0).getQueue();
    if (queue.isEmpty()) {
      this.refillQueue();
    }
    GameCharacter character = queue.poll();
    assert character != null;
    character.setTurn(character.getTurn() + 1);
    int turn = character.getTurn();
    character.applyEffect();
    if (character.getCurrentHp() > 0 && !character.isParalyzed()) {
      System.out.println("Character: " + character.getName() + " | Turn: " + turn);
      character.setInit(this);
      this.execute(character);
    }

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

