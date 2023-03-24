package cl.uchile.dcc.finalreality.driver.states;

import cl.uchile.dcc.finalreality.driver.Player;
import cl.uchile.dcc.finalreality.exceptions.InvalidInputException;
import cl.uchile.dcc.finalreality.exceptions.InvalidSkillException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.io.IOException;

/**
 * Player idle.
 */
public class PlayerIdle extends StateFinalReality {
  @Override
  public void playerAttack() {
    this.changeState(new PlayerAttack());
  }



  @Override
  public void playerEquip() {
    this.changeState(new PlayerEquip());
  }

  @Override
  public void playerCast() {
    this.changeState(new PlayerCast());
  }

  @Override
  public void playerIdle() {
    this.changeState(new PlayerIdle());
  }

  @Override
  public boolean isPlayerIdling() {
    return true;
  }


  /**
   * Executes an action depending on the input. Write 'A' to attack,
   * write 'E' to equip a weapon, write 'S' to cast a spell.
   */

  @Override
  public void execute(GameCharacter character)
      throws IOException, InvalidStatValueException, InvalidSkillException, InvalidInputException,
      InvalidTargetException {

    PlayerCharacter partyMember = (PlayerCharacter) character;
    System.out.println("It's " + character.getName() + " turn!");
    System.out.println("Your HP : " + character.getCurrentHp());
    System.out.println("Your Weapon : " + partyMember.getEquippedWeapon());
    System.out.println("Type 'A' to attack. Type 'E' to equip. "
        + "Type 'S' to cast a spell.");
    String line;
    Player player = finalReality.getPlayer();
    line = player.getIn().readLine();

    if (line == null) {
      throw new IOException("End of input.");
    }
    try {
      switch (line) {
        case "A" -> {
          finalReality.playerAttack();
          finalReality.execute(character);
        }
        case "E" -> {
          finalReality.playerEquip();
          finalReality.execute(character);
        }
        case "S" -> {
          finalReality.playerCast();
          finalReality.execute(character);
        }
        default -> throw new InvalidInputException("Invalid command.");
      }
    } catch (InvalidStatValueException | AssertionError | InvalidSkillException
             | InvalidInputException | InvalidTargetException e) {
      System.err.println(e.getMessage());
      finalReality.playerIdle();
      finalReality.execute(character);
    }

  }

}
