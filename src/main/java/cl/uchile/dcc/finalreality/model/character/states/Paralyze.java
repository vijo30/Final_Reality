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
    if (gameCharacter.getCurrentHp() < 0) {
      this.undo();
    } else if (gameCharacter.getTurn() - gameCharacter.getTurnEffect() == 2) {
      this.undo();
      System.out.println(gameCharacter.getName() + " is no longer paralyzed.");
    } else {
      System.out.println(gameCharacter.getName() + " is paralyzed. " + gameCharacter.getName()
          + " can't attack in this turn!");
    }
  }
}
