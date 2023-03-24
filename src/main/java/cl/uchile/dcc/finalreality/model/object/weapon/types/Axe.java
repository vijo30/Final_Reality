package cl.uchile.dcc.finalreality.model.object.weapon.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapon;
import java.util.Objects;

/**
 * A class that holds all the information of an axe.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */
public class Axe extends Weapon {


  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name the object's name
   * @param damage the object's damage
   * @param weight the object's weight
   */
  public Axe(String name, int damage, int weight) {
    super(name, damage, weight, 0);
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
    return "Axe{name='%s', damage=%d, weight=%d}"
        .formatted(name, damage, weight);
  }

  /**
   * Handles its type in a way the method in AbstractPlayerCharacher equip(Weapon weapon)
   * can determinate which type of weapon it's being equipped.
   */
  @Override
  public void handle(PlayerCharacter playerCharacter) throws InvalidStatValueException {
    playerCharacter.equipAxe(this);
  }
}
