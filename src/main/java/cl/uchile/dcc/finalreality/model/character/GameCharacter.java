package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.driver.FinalReality;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import java.io.IOException;
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

  /**
   * Sets wait turn depending on the case.
   */
  void setWaitTurn();

  LinkedBlockingQueue<GameCharacter> getQueue();

  void execute(FinalReality finalReality, GameCharacter character) throws IOException,
      InvalidStatValueException;

  void setState(State aState);
}
