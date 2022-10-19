package cl.uchile.dcc.finalreality.model.object.weapon.types;

import cl.uchile.dcc.finalreality.model.object.weapon.Weapon;
import java.util.Objects;

/**
 * A class that holds all the information of a knife.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */
public class Knife extends Weapon {
  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name the object's name
   * @param damage the object's damage
   * @param weight the object's weight
   */
  public Knife(String name, int damage, int weight) {
    super(name, damage, weight);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Weapon weapon)) {
      return false;
    }
    return hashCode() == weapon.hashCode()
        && damage == weapon.getDamage()
        && weight == weapon.getWeight()
        && name.equals(weapon.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(Weapon.class, name, damage, weight);
  }

  @Override
  public String toString() {
    return "Weapon{name='%s', damage=%d, weight=%d}"
        .formatted(name, damage, weight);
  }
}