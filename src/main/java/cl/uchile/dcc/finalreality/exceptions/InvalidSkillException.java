package cl.uchile.dcc.finalreality.exceptions;


/**
 * This error is used to represent an invalid stat value.
 *
 * @author <a href="https://github.com/vijo30">V30</a>
 * @author ~José Videla~
 */
public class InvalidSkillException extends Exception {

  /**
   * Creates a new {@code InvalidSkillException} with a {@code description} of the
   * error.
   */
  public InvalidSkillException(String description) {
    super("You don't have that skill. " + description);
  }
}
