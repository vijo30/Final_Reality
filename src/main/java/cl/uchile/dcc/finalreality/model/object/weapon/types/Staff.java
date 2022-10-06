package cl.uchile.dcc.finalreality.model.object.weapon.types;

import cl.uchile.dcc.finalreality.model.object.weapon.Weapon;
import java.util.Objects;

/**
 * A class that holds all the information of a staff.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */

public class Staff extends Weapon {

  private final int magicDamage;

  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name the object's name
   * @param damage the object's damage
   * @param weight the object's weight
   * @param magicDamage the weapon's magic damage
   */

  public Staff(String name, int damage, int weight, int magicDamage) {
    super(name, damage, weight);
    this.magicDamage = magicDamage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Staff staff = (Staff) o;
    return magicDamage == staff.magicDamage;
  }

  @Override
  public int hashCode() {
    return Objects.hash(magicDamage);
  }

  @Override
  public String toString() {
    return "Staff{"
        + "magicDamage="
        + magicDamage
        + ", damage="
        + damage
        + ", weight="
        + weight
        + ", name='"
        + name
        + '\''
        + '}';
  }
}

