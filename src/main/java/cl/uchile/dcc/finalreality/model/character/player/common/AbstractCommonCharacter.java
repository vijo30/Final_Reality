package cl.uchile.dcc.finalreality.model.character.player.common;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;


/**
 * A class that holds all the information of a common character in the game.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */

public abstract class AbstractCommonCharacter extends AbstractPlayerCharacter {
  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  protected AbstractCommonCharacter(final @NotNull String name, final int maxHp,
                                    final int defense,
                                    final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }
}
