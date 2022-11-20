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
import cl.uchile.dcc.finalreality.model.object.weapon.types.Bow;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Knife;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Sword;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import org.jetbrains.annotations.NotNull;



/**
 * A {@link PlayerCharacter} that can equip {@code Sword}s,{@code Knife}s and
 * {@code Bow}s.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 * @version 2.0
 */
public class Thief extends AbstractCommonCharacter {

  /**
   * Creates a new Thief.
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
  public Thief(final @NotNull String name, final int maxHp, final int defense,
      final @NotNull LinkedBlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Thief.class, name, maxHp, defense);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Thief that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense;
  }

  @Override
  public String toString() {
    return "Thief{name='%s', maxHp='%d', defense='%d'}".formatted(name, maxHp, defense);
  }

  /**
   * Equips a sword.
   */
  @Override
  public void equipSword(Sword sword) {
    this.equippedWeapon = sword;
  }

  /**
   * Equips a knife.
   */
  @Override
  public void equipKnife(Knife knife) {
    this.equippedWeapon = knife;
  }


  /**
   * Equips a bow.
   */
  @Override
  public void equipBow(Bow bow) {
    this.equippedWeapon = bow;
  }
}
