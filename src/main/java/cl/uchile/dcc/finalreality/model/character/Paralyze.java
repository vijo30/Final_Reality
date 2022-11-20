package cl.uchile.dcc.finalreality.model.character;

/**
 * A paralyze state.
 */
public class Paralyze extends State {
  void undo() {
    this.changeState(new Normal());
  }

  @Override
  public boolean isParalyzed() {
    return true;
  }
}
