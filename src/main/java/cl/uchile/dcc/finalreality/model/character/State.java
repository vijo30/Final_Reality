package cl.uchile.dcc.finalreality.model.character;

/**
 * This class represents a state of a GameCharacter.
 */
public class State {
  private GameCharacter gameCharacter;

  public void setGameCharacter(GameCharacter gameCharacter) {
    this.gameCharacter = gameCharacter;
  }

  protected void changeState(State state) {
    gameCharacter.setState(state);
  }

  void error() {
    throw new AssertionError("Wrong state.");
  }

  void paralyze() {
    error();
  }

  void burn() {
    error();
  }

  void poison() {
    error();
  }

  void undo() {
    error();
  }

  public boolean isParalyzed() {
    return false;
  }

  public boolean isBurned() {
    return false;
  }

  public boolean isPoisoned() {
    return false;
  }

  public boolean isNormal() {
    return false;
  }


}
