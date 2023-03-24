package cl.uchile.dcc.finalreality.model.character.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

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

  public void error() {
    throw new AssertionError("Wrong state.");
  }

  public void paralyze() {
    error();
  }

  public void burn() {
    error();
  }

  public void poison() {
    error();
  }

  public void undo() {
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

  /**
   * Applies an effect depending on the state.
   */

  public void applyEffect(GameCharacter gameCharacter) throws InvalidStatValueException {
    error();
  }



}
