package cl.uchile.dcc.finalreality.model.object.weapon.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapon;
import java.util.Objects;

/**
 * A class that holds all the information of a staff.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */

public class Staff extends Weapon {



  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name the object's name
   * @param damage the object's damage
   * @param weight the object's weight
   * @param magicDamage the weapons' magic damage
   */

  public Staff(String name, int damage, int weight, int magicDamage) {
    super(name, damage, weight, magicDamage);
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Staff other)) {
      return false;
    }
    return hashCode() == other.hashCode()
        && damage == other.getDamage()
        && weight == other.getWeight()
        && name.equals(other.getName())
        && magicDamage == other.magicDamage;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Weapon.class, name, damage, weight, magicDamage);
  }

  @Override
  public String toString() {
    return "Staff{name='%s', damage=%d, weight=%d, magicDamage=%d}"
        .formatted(name, damage, weight, magicDamage);
  }

  /**
   * Handles its type in a way the method in AbstractPlayerCharacher equip(Weapon weapon)
   * can determinate which type of weapon it's being equipped.
   */
  @Override
  public void handle(PlayerCharacter playerCharacter) throws InvalidStatValueException {
    playerCharacter.equipStaff(this);
  }
}

