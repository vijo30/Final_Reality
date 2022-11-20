/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.common;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Axe;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Bow;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import org.jetbrains.annotations.NotNull;


/**
 * A {@link PlayerCharacter} that can equip {@code Axe}s and {@code Bow}s.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public class Engineer extends AbstractCommonCharacter {


  /**
   * Creates a new engineer.
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
  public Engineer(final @NotNull String name, final int maxHp, final int defense,
      final @NotNull LinkedBlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public String toString() {
    return "Engineer{name='%s', maxHp='%d', defense='%d'}".formatted(name, maxHp, defense);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Engineer.class, name, maxHp, defense);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Engineer that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense;
  }


  /**
   * Equips an axe.
   */
  @Override
  public void equipAxe(Axe axe) {
    this.equippedWeapon = axe;
  }

  /**
   * Equips a bow.
   */
  @Override
  public void equipBow(Bow bow) {
    this.equippedWeapon = bow;
  }
}
