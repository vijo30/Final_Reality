package cl.uchile.dcc.finalreality.driver.states;


import cl.uchile.dcc.finalreality.driver.FinalReality;
import cl.uchile.dcc.finalreality.exceptions.InvalidInputException;
import cl.uchile.dcc.finalreality.exceptions.InvalidSkillException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.io.IOException;

/**
 * Generic state.
 */
public class StateFinalReality {

  protected FinalReality finalReality;

  public void setFinalReality(FinalReality finalReality) {
    this.finalReality = finalReality;
  }

  protected void changeState(StateFinalReality state) {
    finalReality.setState(state);
  }

  public void error() {
    throw new AssertionError("Wrong state.");
  }

  public void init() {
    error();
  }

  public void playerIdle() {
    error();
  }

  public void enemyIdle() {
    error();
  }

  public void playerAttack() {
    error();
  }

  public void enemyAttack() {
    error();
  }

  public void playerEquip() {
    error();
  }

  public void playerCast() {
    error();
  }

  public boolean isInit() {
    return false;
  }

  public boolean isPlayerIdling() {
    return false;
  }


  public boolean isEnemyIdling() {
    return false;
  }

  public boolean isPlayerAttacking() {
    return false;
  }

  public boolean isEnemyAttacking() {
    return false;
  }

  public boolean isPlayerEquipping() {
    return false;
  }

  public boolean isPlayerCasting() {
    return false;
  }

  public void execute(GameCharacter character)
      throws IOException, InvalidStatValueException, InvalidSkillException, InvalidTargetException,
      InvalidInputException {
    error();
  }


}
