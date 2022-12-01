package cl.uchile.dcc.finalreality.driver.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidInputException;
import cl.uchile.dcc.finalreality.exceptions.InvalidSkillException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.io.IOException;

/**
 * Enemy idle.
 */
public class EnemyIdle extends StateFinalReality {



  @Override
  public void enemyAttack() {
    this.changeState(new EnemyAttack());
  }

  @Override
  public void enemyIdle() {
    this.changeState(new EnemyIdle());
  }

  @Override
  public boolean isEnemyIdling() {
    return true;
  }

  @Override
  public void execute(GameCharacter character)
      throws InvalidStatValueException, IOException, InvalidSkillException, InvalidInputException,
      InvalidTargetException {
    finalReality.enemyAttack();
    finalReality.execute(character);
  }

}
