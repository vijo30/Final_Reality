package cl.uchile.dcc.finalreality.model.character;


/**
 * A poison state.
 */
public class Poison extends State {
  void undo() {
    this.changeState(new Normal());
  }

  @Override
  public boolean isPoisoned() {
    return true;
  }
}
