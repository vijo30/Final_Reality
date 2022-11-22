package cl.uchile.dcc.finalreality.model.character;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.AbstractEntity;
import cl.uchile.dcc.finalreality.model.character.states.Normal;
import cl.uchile.dcc.finalreality.model.character.states.State;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public abstract class AbstractCharacter extends AbstractEntity implements GameCharacter {

  private int currentHp;
  protected int maxHp;
  protected int defense;
  protected final LinkedBlockingQueue<GameCharacter> turnsQueue;
  private State state;
  private int turn;
  private int turnEffect;

  protected ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractCharacter(@NotNull String name, int maxHp, int defense,
      @NotNull LinkedBlockingQueue<GameCharacter> turnsQueue) throws InvalidStatValueException {
    super(name);
    Require.statValueAtLeast(1, maxHp, "Max HP");
    Require.statValueAtLeast(0, defense, "Defense");
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
    this.setState(new Normal());
    this.turn = 0;
  }

  @SuppressWarnings("checkstyle:ParameterName")
  public void setState(State aState) {
    state = aState;
    state.setGameCharacter(this);
  }

  public void paralyze() {
    state.paralyze();
  }

  public void burn() {
    state.burn();
  }


  public void poison() {
    state.poison();
  }

  public void undo() {
    state.undo();
  }

  public boolean isParalyzed() {
    return state.isParalyzed();
  }

  public boolean isBurned() {
    return state.isBurned();
  }

  public boolean isPoisoned() {
    return state.isPoisoned();
  }

  public boolean isNormal() {
    return state.isNormal();
  }


  public void waitTurn() {
    this.setWaitTurn();
  }

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }



  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  @Override
  public int getMaxHp() {
    return maxHp;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  public int getTurn() {
    return turn;
  }

  public void setTurn(int value) {
    this.turn = value;
  }

  public int getTurnEffect() {
    return turnEffect;
  }

  public void setTurnEffect(int value) {
    this.turnEffect = value;
  }

  @Override
  public void setCurrentHp(int hp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, hp, "Current HP");
    Require.statValueAtMost(maxHp, hp, "Current HP");
    currentHp = hp;
  }

  public LinkedBlockingQueue<GameCharacter> getQueue() {
    return turnsQueue;
  }

  /**
   * Applies an effect depending on the state.
   */

  public void applyEffect() throws InvalidStatValueException {
    state.applyEffect(this);
  }




}
