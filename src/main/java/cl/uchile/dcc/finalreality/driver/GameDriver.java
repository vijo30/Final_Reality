package cl.uchile.dcc.finalreality.driver;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapons;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Axe;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Knife;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Staff;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Sword;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that drives the game.
 */
public class GameDriver {



  /**
   * The main loop.
   */
  @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
  public static void main(String[] args) throws InvalidStatValueException, InterruptedException {
    LinkedBlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    ArrayList<PlayerCharacter> party = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Weapons> inventory = new ArrayList<>();
    Knight roderick = new Knight("Sir Roderick", 100, 30, queue);
    Thief jorge = new Thief("Don Jorge", 100, 10, queue);
    Engineer marcus = new Engineer("Chief Engineer Marcus", 100, 5, queue);
    Sword coldbringer = new Sword("The Coldbringer", 50, 20);
    Knife gutsripper = new Knife("The Gutsripper", 30, 5);
    Axe mech = new Axe("Engineer Battle Axe", 40, 10);
    roderick.equip(coldbringer);
    jorge.equip(gutsripper);
    marcus.equip(mech);
    party.add(roderick);
    party.add(jorge);
    party.add(marcus);
    Staff rod = new Staff("Wisdom Rod", 10, 10, 40);
    inventory.add(rod);

    Random random = new Random();
    int r = random.nextInt(5 - 1) + 1;
    for (int i = 0; i < r; i++) {
      Enemy enemy = new Enemy("Mindless Ghoul " + Integer.toString(i),
          10, 100, 3, queue);
      enemies.add(enemy);
    }
    Player player = new Player("Vijo30");
    FinalReality game = new FinalReality(party, enemies, inventory, player);
    playGame(game);
  }

  /**
   * Plays the game.
   */
  public static void playGame(FinalReality game) {
    try {
      do {
        game.update();
      } while (!game.isOver());
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
