package cl.uchile.dcc.finalreality.driver.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidSkillException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.io.IOException;

/**
 * Enemy idle.
 */
public class EnemyIdle extends State {



  @Override
  public void enemyAttack() {
    this.changeState(new EnemyAttack());
  }

  @Override
  public boolean isEnemyIdling() {
    return true;
  }

  @Override
  public void execute(GameCharacter character)
      throws InvalidStatValueException, IOException, InvalidSkillException {
    finalReality.enemyAttack();
    finalReality.execute(character);
  }

}
