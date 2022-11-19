package cl.uchile.dcc.finalreality.driver;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapons;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Axe;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that drives the game.
 */
public class GameDriver {
  /**
   * The main loop.
   */
  public static void main(String[] args) throws InvalidStatValueException {
    LinkedBlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    Enemy e1 = new Enemy("e1", 100, 100, 100, queue);
    Knight k1 = new Knight("k1", 100, 100, queue);
    Axe ax1 = new Axe("ax1", 10, 10);
    ArrayList<PlayerCharacter> party = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Weapons> inventory = new ArrayList<>();
    party.add(k1);
    enemies.add(e1);
    inventory.add(ax1);

    FinalReality game = new FinalReality(party, enemies, inventory);
    do {
      System.out.print(game);
    } while (!game.isOver());
  }
}
