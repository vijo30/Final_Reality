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
 */
public class Player {
  private final String name;
  private final BufferedReader in;

  /**
   * Constructor to specify an alternative source of moves.
   *
   * @param name The name of the user.
   * @param in An input from the player.
   */
  public Player(String name, BufferedReader in) {
    this.name = name;
    this.in = in;
  }

  /**
   * The normal constructor to use.
   */
  public Player(String name) {
    this(name, new BufferedReader(new InputStreamReader((System.in))));
  }

  /**
   * Special constructor meant for testing. Player that plays a fixed
   * set of moves from a String.
   */
  public Player(String name, String moves) {
    this(name, new BufferedReader(new StringReader((moves))));
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
    System.out.println("HP = " + character.getCurrentHp());
    System.out.println("Weapon = " + partyMember.getEquippedWeapon());
    System.out.println("Type 'A' to attack. Type 'E' to equip. "
        + "Type 'S' to cast a spell");
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
      System.err.println("Invalid move!");
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
      System.out.println(weapon.getName());
    }
    String line;
    line = in.readLine();
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
    line = in.readLine();
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
      System.out.println(enemy.getName() + " HP = " + enemy.getCurrentHp());
    }
    String line;
    line = in.readLine();
    if (line == null) {
      throw new IOException("End of input.");
    }
    finalReality.attackEnemy(line, partyMember);
  }
}
