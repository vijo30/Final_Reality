package cl.uchile.dcc.finalreality.model.object.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.object.AbstractObject;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public abstract class Weapon extends AbstractObject implements Weapons {

  protected final int damage;
  protected final int magicDamage;

  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name
   *         the weapon's name
   *
   * @param damage
   *         the weapon's damage.
   *
   * @param weight
   *         the weapon's weight
   */
  public Weapon(final String name, final int damage, final int weight, final int magicDamage) {
    super(name, weight);
    this.damage = damage;
    this.magicDamage = magicDamage;
  }

  @Override
  public String getName() {
    return name;
  }

  /**
   * Returns the weapon's damage.
   */
  public int getDamage() {
    return damage;
  }

  public int getMagicDamage() {
    return magicDamage;
  }


  /**
   * Handles the type of player.
   */
  @Override
  public abstract void handle(PlayerCharacter playerCharacter) throws InvalidStatValueException;




}
