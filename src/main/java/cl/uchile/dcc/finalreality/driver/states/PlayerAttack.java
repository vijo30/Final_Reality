package cl.uchile.dcc.finalreality.driver.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Player attack.
 */
public class PlayerAttack extends State {

  @Override
  public void playerIdle() {
    this.changeState(new PlayerIdle());
  }

  @Override
  public void enemyIdle() {
    this.changeState(new EnemyIdle());
  }

  @Override
  public boolean isPlayerAttacking() {
    return true;
  }

  @Override
  public void execute(GameCharacter character) throws InvalidStatValueException, IOException {
    System.out.println("Select an enemy to attack. Type its name.");
    System.out.println("Your enemies: ");
    for (Enemy enemy : finalReality.getEnemies()) {
      System.out.println("* Enemy name: " + enemy.getName() + " | HP : " + enemy.getCurrentHp());
    }
    String line = finalReality.getPlayer().getIn2().readLine();
    if (line == null) {
      throw new IOException("end of input");
    }
    ArrayList<Enemy> enemies = finalReality.getEnemies();
    boolean found = false;
    for (Enemy enemy : enemies) {
      if (line.equals(enemy.getName())) {
        System.out.print(character.getName() + " attacks "
            + enemy.getName() + " dealing ");
        character.attack(enemy);
        found = true;
      }
    }
    if (!found) {
      throw new InvalidStatValueException("Enemy not found.");
    }
  }
}
