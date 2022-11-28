package cl.uchile.dcc.finalreality.driver.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidInputException;
import cl.uchile.dcc.finalreality.exceptions.InvalidSkillException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapons;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Player equip.
 */
public class PlayerEquip extends StateFinalReality {

  @Override
  public void playerIdle() {
    this.changeState(new PlayerIdle());
  }

  @Override
  public boolean isPlayerEquipping() {
    return true;
  }

  @Override
  public void execute(GameCharacter character)
      throws IOException, InvalidStatValueException, InvalidSkillException, InvalidTargetException,
      InvalidInputException {
    System.out.println("Select a weapon from the inventory. Type its name.");
    System.out.println("Type 'B' to go back.");
    System.out.println("Your inventory: ");
    for (Weapons weapon : finalReality.getInventory()) {
      System.out.println("* " + weapon.getName());
    }
    String line;
    line = finalReality.getPlayer().getIn2().readLine();
    if (line == null) {
      throw new IOException("End of input.");
    }
    if (line.equals("B")) {
      finalReality.playerIdle();
      finalReality.execute(character);
    }
    boolean found = false;
    ArrayList<Weapons> inventory = finalReality.getInventory();
    PlayerCharacter partyMember = (PlayerCharacter) character;
    for (Weapons weapon : inventory) {
      if (line.equals(weapon.getName())) {
        inventory.add(partyMember.getEquippedWeapon());
        partyMember.equip(weapon);
        inventory.remove(weapon);
        System.out.println(partyMember.getName() + " equips "
            + weapon.getName() + "!");
        System.out.println(partyMember.getEquippedWeapon().getName() + " is now in the inventory.");
        found = true;

      }
    }
    if (!found) {
      throw new InvalidTargetException("Weapon not found.");
    }
    finalReality.playerIdle();
    finalReality.execute(character);
  }

}
