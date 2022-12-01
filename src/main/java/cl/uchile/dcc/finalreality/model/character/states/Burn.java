package cl.uchile.dcc.finalreality.model.character.states;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A burn state.
 */
public class Burn extends State {

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
  public boolean isBurned() {
    return true;
  }

  @Override
  public void applyEffect(GameCharacter gameCharacter) throws InvalidStatValueException {
    int maxHp = gameCharacter.getMaxHp();
    int currHp = gameCharacter.getCurrentHp();
    int damage = (int) (maxHp / 2);
    gameCharacter.setCurrentHp(Math.max(0, currHp - damage));
    System.out.println(gameCharacter.getName() + " takes " + damage + " fire damage!");
  }
}
