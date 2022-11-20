package cl.uchile.dcc.finalreality.driver;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapons;
import java.io.BufferedReader;
import java.io.IOException;
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

  /**
   * Constructor to specify an alternative source of moves.
   *
   * @param name The name of the user.
   * @param in  An input from the player, in this case, what action is going to make.
   * @param in2 A second input which reffers to which enemy is going to attack or
   *            what weapon is going to equip
   */
  public Player(String name, BufferedReader in, BufferedReader in2) {
    this.name = name;
    this.in = in;
    this.in2 = in2;
  }

  /**
   * The normal constructor to use.
   *
   * @param name The name of the user.
   */
  public Player(String name) {
    this(name, new BufferedReader(new InputStreamReader(System.in)),
        new BufferedReader(new InputStreamReader(System.in)));
  }

  /**
   * Special constructor meant for testing. Player that plays a premade action from a move1,
   * and selects a target from a move2.
   */
  public Player(String name, String move1, String move2) {
    this(name, new BufferedReader(new StringReader(move1)),
        new BufferedReader(new StringReader(move2)));
  }

  /**
   * Returns the players' name.
   */
  public String getName() {
    return name;
  }

  /**
   * Executes an action depending on the input. Write 'A' for attacking,
   * write 'E' for equipping.
   */
  public void action(FinalReality finalReality, GameCharacter character) throws
      InvalidStatValueException, IOException {
    PlayerCharacter partyMember = (PlayerCharacter) character;
    System.out.println("It's " + character.getName() + " turn!");
    System.out.println("Your HP : " + character.getCurrentHp());
    System.out.println("Your Weapon : " + partyMember.getEquippedWeapon());
    System.out.println("Type 'A' to attack. Type 'E' to equip. "
        + "Type 'S' to cast a spell.");
    String line;
    line = in.readLine();

    if (line == null) {
      throw new IOException("end of input");
    }
    try {
      switch (line) {
        case "A" -> attackE(finalReality, partyMember);
        case "E" -> equipW(finalReality, partyMember);
        case "S" -> castS(finalReality, partyMember);
        default -> throw new InvalidStatValueException("Invalid command.");
      }
    } catch (InvalidStatValueException e) {
      System.err.println("Invalid command.");
      action(finalReality, character);
    }
  }

  /**
   * Decides which weapon to equip.
   */
  public void equipW(FinalReality finalReality,
                      PlayerCharacter partyMember) throws IOException, InvalidStatValueException {
    System.out.println("Select a weapon from the inventory. Type its name.");
    System.out.println("Your inventory: ");
    for (Weapons weapon : finalReality.getInventory()) {
      System.out.println("* " + weapon.getName());
    }
    String line;
    line = in2.readLine();
    if (line == null) {
      throw new IOException("End of input.");
    }
    finalReality.equip(line, partyMember);
  }

  /**
   * Decides which spell will be cast.
   */

  public void castS(FinalReality finalReality,
                     PlayerCharacter partyMember) throws IOException {
    String line;
    line = in2.readLine();
    if (line == null) {
      throw new IOException("End of input.");
    }
    finalReality.castSpell(line, partyMember);


  }

  /**
   * Decides which enemy will be attacked.
   */
  public void attackE(FinalReality finalReality,
                          PlayerCharacter partyMember) throws IOException,
      InvalidStatValueException {
    System.out.println("Select an enemy to attack. Type its name.");
    System.out.println("Your enemies: ");
    for (Enemy enemy : finalReality.getEnemies()) {
      System.out.println("* Enemy name: " + enemy.getName() + " | HP : " + enemy.getCurrentHp());
    }
    String line;
    line = in2.readLine();
    if (line == null) {
      throw new IOException("End of input.");
    }
    finalReality.attackEnemy(line, partyMember);
  }
}
