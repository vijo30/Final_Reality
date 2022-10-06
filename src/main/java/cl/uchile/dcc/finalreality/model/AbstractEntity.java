package cl.uchile.dcc.finalreality.model;

/**
 * An abstract class that holds the common behaviour of all the entities in the game.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */

public abstract class AbstractEntity {

  protected String name;


  public String getName() {
    return name;
  }

  /**
   * Creates a new entity.
   *
   * @param name
   *     the entity's name
   */

  protected AbstractEntity(final String name) {
    this.name = name;
  }




}
