package cl.uchile.dcc.finalreality.model.character.states;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A poison state.
 */
public class Poison extends State {
  public void undo() {
    this.changeState(new Normal());
  }

  @Override
  public boolean isPoisoned() {
    return true;
  }

  @Override
  public void applyEffect(GameCharacter gameCharacter) throws InvalidStatValueException {
    int maxHp = gameCharacter.getMaxHp();
    int currHp = gameCharacter.getCurrentHp();
    int damage = (int) (maxHp / 3);
    gameCharacter.setCurrentHp(Math.max(0, currHp - damage));
    System.out.println(gameCharacter.getName() + " takes " + damage + " poison damage!");
  }
}
