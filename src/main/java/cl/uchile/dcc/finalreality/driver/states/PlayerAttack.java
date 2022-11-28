package cl.uchile.dcc.finalreality.driver.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Player attack.
 */
public class PlayerAttack extends StateFinalReality {

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
  public void execute(GameCharacter character)
      throws InvalidStatValueException, IOException, InvalidTargetException {
    System.out.println("Select an enemy to attack. Type its name.");
    System.out.println("Your enemies: ");
    for (Enemy enemy : finalReality.getEnemies()) {
      if (enemy.getCurrentHp() > 0) {
        System.out.println("* Enemy name: " + enemy.getName() + " | HP : " + enemy.getCurrentHp());
      } else {
        System.out.println("* Enemy name: " + enemy.getName() + " | HP : " + enemy.getCurrentHp()
            + " (dead)");
      }
    }
    String line = finalReality.getPlayer().getIn2().readLine();
    if (line == null) {
      throw new IOException("End of input.");
    }
    ArrayList<Enemy> enemies = finalReality.getEnemies();
    boolean found = false;
    for (Enemy enemy : enemies) {
      if (line.equals(enemy.getName())) {
        if (enemy.getCurrentHp() > 0) {
          System.out.print(character.getName() + " attacks "
              + enemy.getName() + " dealing ");
          character.attack(enemy);
          found = true;
        } else {
          throw new InvalidTargetException("This target is dead.");
        }
      }
    }
    if (!found) {
      throw new InvalidTargetException("Enemy not found.");
    }
  }
}
