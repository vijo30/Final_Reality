package cl.uchile.dcc.finalreality.model.character.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A paralyze state.
 */
public class Paralyze extends State {

  @Override
  public void paralyze() {
    this.changeState(new Paralyze());
  }

  @Override
  public void burn() {
    this.changeState(new Burn());
  }

  @Override
  public void poison() {
    this.changeState(new Poison());
  }

  @Override
  public void undo() {
    this.changeState(new Normal());
  }

  @Override
  public boolean isParalyzed() {
    return true;
  }

  @Override
  public void applyEffect(GameCharacter gameCharacter) throws InvalidStatValueException {
    System.out.println(gameCharacter.getName() + " is paralyzed. " + gameCharacter.getName()
        + " can't attack in this turn!");
  }
}
