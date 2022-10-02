package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;



/**
 * A class that holds all the information of a mage character in the game.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */


public abstract class AbstractMage extends AbstractPlayerCharacter {

  protected int currentMp;
  protected final int maxMp;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   * @param maxMp      the character's max mp
   */
  protected AbstractMage(final @NotNull String name, final int maxHp,
                         final int defense, int maxMp,
                         final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(0, maxMp, "Max MP");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }

  /**
   * Returns the current MP of the character.
   */
  public int getCurrentMp() {
    return currentMp;
  }

  /**
   * Sets the current MP of the character to {@code newMp}.
   */
  public void setCurrentMp(final int newMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, newMp, "Current MP");
    Require.statValueAtMost(maxMp, newMp, "Current MP");
    this.currentMp = newMp;
  }
}
