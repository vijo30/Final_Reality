package cl.uchile.dcc.finalreality.model.character.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A paralyze state.
 */
public class Paralyze extends State {
  public void undo() {
    this.changeState(new Normal());
  }

  @Override
  public boolean isParalyzed() {
    return true;
  }

  @Override
  public void applyEffect(GameCharacter gameCharacter) throws InvalidStatValueException {
    System.out.println(gameCharacter.getName() + " is paralized. " + gameCharacter.getName()
        + " can't attack in this turn!");
  }
}
