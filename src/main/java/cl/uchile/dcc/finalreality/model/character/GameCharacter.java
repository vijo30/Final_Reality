package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.driver.FinalReality;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.states.State;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public interface GameCharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's current HP.
   */
  int getCurrentHp();

  /**
   * Returns this character's max HP.
   */
  int getMaxHp();

  /**
   * Returns this character's defense.
   */
  int getDefense();

  /**
   * Sets this character's current HP to {@code newHp}.
   */
  void setCurrentHp(int hp) throws InvalidStatValueException;

  int getTurn();

  void setTurn(int value);

  int getTurnEffect();

  void setTurnEffect(int value);


  /**
   * Sets wait turn depending on the case.
   */
  void setWaitTurn();

  LinkedBlockingQueue<GameCharacter> getQueue();



  @SuppressWarnings("checkstyle:ParameterName")
  void setState(State aState);

  void paralyze();

  void burn();

  void poison();

  void undo();

  boolean isParalyzed();

  boolean isBurned();

  boolean isPoisoned();

  boolean isNormal();

  void attack(GameCharacter gameCharacter) throws InvalidStatValueException;

  void applyEffect() throws InvalidStatValueException;


  void setInit(FinalReality finalReality);




}
