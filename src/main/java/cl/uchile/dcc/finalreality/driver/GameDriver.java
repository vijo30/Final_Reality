package cl.uchile.dcc.finalreality.driver;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapons;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Axe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that drives the game.
 */
public class GameDriver {



  /**
   * The main loop.
   */
  public static void main(String[] args) throws InvalidStatValueException, InterruptedException {
    LinkedBlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    Enemy e1 = new Enemy("e1", 15, 20, 2, queue);
    Knight k1 = new Knight("k1", 100, 3, queue);
    Axe ax1 = new Axe("ax1", 15, 10);
    k1.equip(ax1);
    ArrayList<PlayerCharacter> party = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Weapons> inventory = new ArrayList<>();
    party.add(k1);
    enemies.add(e1);
    inventory.add(ax1);
    Player player = new Player("A");

    FinalReality game = new FinalReality(party, enemies, inventory, player);
    playGame(game);
  }

  /**
   * Plays the game.
   */
  public static void playGame(FinalReality game) {
    try {
      do {
        System.out.print(game);
        game.update();
        System.out.println(!game.isOver());
      } while (!game.isOver());
      System.out.print(game);
      System.out.println("GAME OVER");
      if (game.deadPlayer()) {
        System.out.println(("YOU LOSE"));
      } else {
        System.out.println("YOU WIN");
      }
    } catch (IOException err) {
      System.out.println("Game Terminated!");
    } catch (InvalidStatValueException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
