package cl.uchile.dcc.finalreality.exceptions;


/**
 * This error is used to represent an invalid target.
 *
 * @author <a href="https://github.com/vijo30">V30</a>
 * @author ~José Videla~
 */
public class InvalidTargetException extends Exception {

  /**
   * Creates a new {@code InvalidTargetException} with a {@code description} of the
   * error.
   */
  public InvalidTargetException(String description) {
    super("Invalid target. " + description);
  }
}
