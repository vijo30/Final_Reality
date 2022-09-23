package cl.uchile.dcc.finalreality.model.object;

/**
 * An abstract class that holds the common behaviour of all the objects in the game.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */




public abstract class AbstractObject {

    protected final int weight;

    /**
     * Creates a new entity.
     *
     * @param weight
     *     the object's weight
     */

    public AbstractObject(int weight) {
        this.weight = weight;
    }
}
