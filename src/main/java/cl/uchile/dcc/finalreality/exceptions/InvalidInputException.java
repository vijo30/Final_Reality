package cl.uchile.dcc.finalreality.exceptions;


/**
 * This error is used to represent an invalid input by the user.
 *
 * @author <a href="https://github.com/vijo30">V30</a>
 * @author ~José Videla~
 */

public class InvalidInputException extends Exception {

  /**
   * Creates a new {@code InvalidInputException} with a {@code description} of the
   * error.
   */
  public InvalidInputException(String description) {
    super("Invalid input. " + description);
  }
}
