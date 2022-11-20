package cl.uchile.dcc.finalreality.model.character;

/**
 * A state without effects.
 */
public class Normal extends State {
  void paralyze() {
    this.changeState(new Paralyze());
  }

  void burn() {
    this.changeState(new Burn());
  }

  void poison() {
    this.changeState(new Poison());
  }

  @Override
  public boolean isNormal() {
    return true;
  }
}
