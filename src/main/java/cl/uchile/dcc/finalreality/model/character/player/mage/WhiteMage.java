/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Staff;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Staff}s and use <i>white magic</i>.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public class WhiteMage extends AbstractMage {



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
   * @param maxMp
   *     the character's max mp
   */
  public WhiteMage(final @NotNull String name, final int maxHp, final int defense,
      int maxMp, final @NotNull LinkedBlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final WhiteMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && maxMp == that.maxMp
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense;
  }

  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, name, maxHp, defense, maxMp);
  }

  @Override
  public String toString() {
    return "WhiteMage{name='%s', maxHp='%d', defense='%d', maxMp='%d'}"
        .formatted(name, maxHp, defense, maxMp);
  }

  /**
   * Equips a staff.
   */
  @Override
  public void equipStaff(Staff staff) {
    this.equippedWeapon = staff;
  }



  @Override
  public void castHeal(GameCharacter gameCharacter) throws InvalidStatValueException {
    assert getCurrentMp() - 15 >= 0 : "Out of mana.";
    int hp = gameCharacter.getCurrentHp();
    gameCharacter.setCurrentHp(Math.min(hp + (int) (0.3 * gameCharacter.getMaxHp()),
        gameCharacter.getMaxHp()));
    System.out.println(this.getName() + " | Maximum mana: " + this.getMaxMp() + " mana.");
    this.setCurrentMp(Math.max(0, getCurrentMp() - 15));
    System.out.println(this.getName() + " has spent " + 15 + " mana.");
    System.out.println(this.getName() + " now has " + getCurrentMp() + " mana.");
    System.out.println(this.getName() + " heals "
        + gameCharacter.getName() + " healing " +  ((int) (0.3 * gameCharacter.getMaxHp()))
        + " hp.");
  }

  @Override
  public void castPoison(GameCharacter gameCharacter) throws InvalidStatValueException {
    assert getCurrentMp() - 40 >= 0 : "Out of mana.";
    System.out.println(this.getName() + " | Maximum mana: " + this.getMaxMp() + " mana.");
    this.setCurrentMp(Math.max(0, getCurrentMp() - 40));
    System.out.println(this.getName() + " has spent " + 40 + " mana.");
    System.out.println(this.getName() + " now has " + getCurrentMp() + " mana.");
    if (!gameCharacter.isPoisoned()) {
      gameCharacter.setTurnEffect(gameCharacter.getTurn());
      gameCharacter.poison();
      System.out.println(gameCharacter.getName() + " is poisoned.");
    }
  }

  @Override
  public void castParalysis(GameCharacter gameCharacter) throws InvalidStatValueException {
    assert getCurrentMp() - 25 >= 0 : "Out of mana.";
    System.out.println(this.getName() + " | Maximum mana: " + this.getMaxMp() + " mana.");
    this.setCurrentMp(Math.max(0, getCurrentMp() - 25));
    System.out.println(this.getName() + " has spent " + 25 + " mana.");
    System.out.println(this.getName() + " now has " + getCurrentMp() + " mana.");
    if (!gameCharacter.isParalyzed()) {
      gameCharacter.setTurnEffect(gameCharacter.getTurn());
      gameCharacter.paralyze();
      System.out.println(gameCharacter.getName() + " is paralyzed.");
    }
  }

}
