package cl.uchile.dcc.finalreality.model.user.player;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.user.AbstractPlayer;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapon;

import java.util.Arrays;
import java.util.Objects;

/**
 * A class that holds all the information of a single player of the game.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */

public class Player extends AbstractPlayer {





    /**
     * Creates a new player
     *
     * @param party     the player's party
     * @param enemies   the player's enemies
     * @param inventory the player's inventory
     */
    public Player(GameCharacter[] party, Enemy[] enemies, Weapon[] inventory) {
        super(party, enemies, inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Player.class, Arrays.hashCode(party), Arrays.hashCode(enemies), Arrays.hashCode(inventory));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof final Player player)){
            return false;
        }
        return hashCode() == player.hashCode()
                && party == player.party
                && enemies == player.enemies
                && inventory == player.inventory;
    }

    @Override
    public String toString() {
        return "Player{" +
                "party=" + Arrays.toString(party) +
                ", enemies=" + Arrays.toString(enemies) +
                ", inventory=" + Arrays.toString(inventory) +
                '}';
    }
    public GameCharacter[] getParty() {
        return party;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public Weapon[] getInventory() {
        return inventory;
    }
}
