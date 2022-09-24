package cl.uchile.dcc.finalreality.model.user;


import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapon;


/**
 * An abstract class that holds the common behaviour of all players in the game.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */



public abstract class AbstractPlayer {
    protected GameCharacter[] party;
    protected Enemy[] enemies;
    protected Weapon[] inventory;

    /**
     * Creates a new player
     *
     * @param party
     *      the player's party
     * @param enemies
     *      the player's enemies
     * @param inventory
     *      the player's inventory
     */
    public AbstractPlayer(GameCharacter[] party, Enemy[] enemies, Weapon[] inventory){
        this.party = party;
        this.enemies = enemies;
        this.inventory = inventory;

    }

}
