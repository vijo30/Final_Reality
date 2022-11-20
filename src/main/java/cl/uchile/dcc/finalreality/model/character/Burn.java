package cl.uchile.dcc.finalreality.model.character;


/**
 * A burn state.
 */
public class Burn extends State {
  void undo() {
    this.changeState(new Normal());
  }

  @Override
  public boolean isBurned() {
    return true;
  }
}
