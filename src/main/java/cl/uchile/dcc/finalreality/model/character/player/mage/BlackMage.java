/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Knife;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Staff;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 * @version 2.0
 */
public class BlackMage extends AbstractMage {

  Random random;

  /**
   * Creates a new Black Mage.
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
  public BlackMage(final @NotNull String name, final int maxHp, final int defense,
      int maxMp, final @NotNull LinkedBlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, maxMp, turnsQueue);
    Require.statValueAtLeast(0, maxMp, "Max MP");
  }



  // region : UTILITY METHODS
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final BlackMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense
        && maxMp == that.maxMp;
  }

  @Override
  public String toString() {
    return "BlackMage{name='%s', maxHp='%d', defense='%d', maxMp='%d'}"
        .formatted(name, maxHp, defense, maxMp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(BlackMage.class, name, maxHp, defense, maxMp);
  }

  /**
   * Equips a knife.
   */
  @Override
  public void equipKnife(Knife knife) {
    this.equippedWeapon = knife;
  }

  /**
   * Equips a staff.
   */
  @Override
  public void equipStaff(Staff staff) {
    this.equippedWeapon = staff;
  }

  @Override
  public void castThunder(GameCharacter gameCharacter) throws InvalidStatValueException {
    assert getCurrentMp() - 15 >= 0;
    int hp = gameCharacter.getCurrentHp();
    int weaponDamage = this.getEquippedWeapon().getMagicDamage();
    int enemyDefense = gameCharacter.getDefense();
    int realDamage = Math.max(0, weaponDamage - enemyDefense);
    int newHp = Math.max(0, hp - realDamage);
    gameCharacter.setCurrentHp(newHp);
    System.out.println(this.getName() + " | Maximum mana: " + this.getMaxMp() + " mana.");
    this.setCurrentMp(Math.max(0, getCurrentMp() - 15));
    System.out.println(this.getName() + " has spent " + 15 + " mana.");
    System.out.println(this.getName() + " now has " + getCurrentMp() + " mana.");
    random = new Random();
    int res = random.nextInt(100) + 1;
    System.out.println(this.getName() + " smacks "
        + gameCharacter.getName() + " with the power of thunder,"
        + " dealing " + realDamage + " damage.");
    if (!gameCharacter.isParalyzed() && res <= 30) {
      gameCharacter.setTurnEffect(gameCharacter.getTurn());
      gameCharacter.paralyze();
      System.out.println(gameCharacter.getName() + " is paralyzed.");
    }
  }

  @Override
  public void castFire(GameCharacter gameCharacter) throws InvalidStatValueException {
    assert getCurrentMp() - 15 >= 0;
    int hp = gameCharacter.getCurrentHp();
    int weaponDamage = this.getEquippedWeapon().getMagicDamage();
    int enemyDefense = gameCharacter.getDefense();
    int realDamage = Math.max(0, weaponDamage - enemyDefense);
    int newHp = Math.max(0, hp - realDamage);
    gameCharacter.setCurrentHp(newHp);
    System.out.println(this.getName() + " | Maximum mana: " + this.getMaxMp() + " mana.");
    this.setCurrentMp(Math.max(0, getCurrentMp() - 15));
    System.out.println(this.getName() + " has spent " + 15 + " mana.");
    System.out.println(this.getName() + " now has " + getCurrentMp() + " mana.");
    random = new Random();
    int res = random.nextInt(100) + 1;
    System.out.println(this.getName() + " roasts "
        + gameCharacter.getName() + " with the power of fire, dealing " + realDamage + " damage.");
    if (!gameCharacter.isBurned() && res <= 20) {
      gameCharacter.setTurnEffect(gameCharacter.getTurn());
      gameCharacter.burn();
      System.out.println(gameCharacter.getName() + " is burning.");
    }
  }
}
