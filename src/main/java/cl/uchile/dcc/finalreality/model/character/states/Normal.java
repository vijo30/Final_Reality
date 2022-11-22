package cl.uchile.dcc.finalreality.model.character.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A state without effects.
 */
public class Normal extends State {
  public void paralyze() {
    this.changeState(new Paralyze());
  }

  public void burn() {
    this.changeState(new Burn());
  }

  public void poison() {
    this.changeState(new Poison());
  }

  @Override
  public boolean isNormal() {
    return true;
  }

  @Override
  public void applyEffect(GameCharacter gameCharacter) throws InvalidStatValueException {

  }
}
