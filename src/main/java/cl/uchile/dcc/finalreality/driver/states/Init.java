package cl.uchile.dcc.finalreality.driver.states;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * Init state.
 */
public class Init extends StateFinalReality {
  @Override
  public void playerIdle() {
    this.changeState(new PlayerIdle());
  }

  @Override
  public void enemyIdle() {
    this.changeState(new EnemyIdle());
  }

  @Override
  public boolean isInit() {
    return true;
  }

  @Override
  public void execute(GameCharacter gameCharacter) {

  }

}
