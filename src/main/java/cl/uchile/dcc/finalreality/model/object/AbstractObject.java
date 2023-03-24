package cl.uchile.dcc.finalreality.model.object;

import cl.uchile.dcc.finalreality.model.AbstractEntity;

/**
 * An abstract class that holds the common behaviour of all the objects in the game.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */




public abstract class AbstractObject extends AbstractEntity {

  protected final int weight;

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Creates a new entity.
   *
   * @param name
   *     the object's name
   *
   * @param weight
   *     the object's weight
   */

  public AbstractObject(final String name, int weight) {
    super(name);
    this.weight = weight;
  }
}
