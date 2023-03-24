package cl.uchile.dcc.finalreality.driver;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Manage interaction with user.
 *
 * @author <a href="https://github.com/vijo30">V30</a>
 * @author ~José Videla~
 */
public class Player {
  private final String name;
  private final BufferedReader in;
  private final BufferedReader in2;
  private final BufferedReader in3;



  /**
   * Constructor to specify an alternative source of moves.
   *
   * @param name The name of the user.
   * @param in  An input from the player, in this case, what action is going to make.
   * @param in2 A second input from the player, in this case, what spell is going to cast.
   * @param in3 A thrid input which reffers to which enemy is going to attack or
   *              what weapon is going to equip.
   */
  public Player(String name, BufferedReader in, BufferedReader in2, BufferedReader in3) {
    this.name = name;
    this.in = in;
    this.in2 = in2;
    this.in3 = in3;
  }

  /**
   * The normal constructor to use.
   *
   * @param name The name of the user.
   */
  public Player(String name) {
    this(name, new BufferedReader(new InputStreamReader(System.in)),
        new BufferedReader(new InputStreamReader(System.in)),
        new BufferedReader(new InputStreamReader(System.in)));
  }

  /**
   * Special constructor meant for testing. Player that plays a premade action from a move1,
   * and selects a target from a move2.
   */

  public Player(String name, String move1, String move2) {
    this(name, new BufferedReader(new StringReader(move1)),
        new BufferedReader(new StringReader(move2)),
        new BufferedReader(new StringReader("default")));
  }

  /**
   * Special constructor meant for testing. Player that plays a premade action from a move1,
   * and selects a spell from a move2, and select a character from move3.
   */

  public Player(String name, String move1, String move2, String move3) {
    this(name, new BufferedReader(new StringReader(move1)),
        new BufferedReader(new StringReader(move2)),
        new BufferedReader(new StringReader(move3)));
  }

  /**
   * Returns the players' name.
   */
  public String getName() {
    return name;
  }

  public BufferedReader getIn() {
    return in;
  }

  public BufferedReader getIn2() {
    return in2;
  }

  public BufferedReader getIn3() {
    return in3;
  }


}
