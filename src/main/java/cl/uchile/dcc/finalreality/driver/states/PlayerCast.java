package cl.uchile.dcc.finalreality.driver.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidInputException;
import cl.uchile.dcc.finalreality.exceptions.InvalidSkillException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * PLayer cast.
 */
public class PlayerCast extends StateFinalReality {

  @Override
  public void enemyIdle() {
    this.changeState(new EnemyIdle());
  }

  @Override
  public void playerIdle() {
    this.changeState(new PlayerIdle());
  }

  @Override
  public boolean isPlayerCasting() {
    return true;
  }

  @Override
  public void execute(GameCharacter character)
      throws IOException, InvalidStatValueException, InvalidSkillException, InvalidInputException,
      InvalidTargetException {

    System.out.println("Casters can cast the following spells: ");
    System.out.println("* Thunder (Black Mage) (Type 'T')");
    System.out.println("* Fire (Black Mage) (Type 'F')");
    System.out.println("* Heal (White Mage) (Type 'H')");
    System.out.println("* Poison (White Mage) (Type 'Po')");
    System.out.println("* Paralysis (White Mage) (Type 'Pa')");
    System.out.println("Type 'B' to go back.");
    String line;
    line = finalReality.getPlayer().getIn2().readLine();
    if (line == null) {
      throw new IOException("End of input.");
    }
    if (line.equals("B")) {
      finalReality.playerIdle();
      finalReality.execute(character);
    }
    System.out.println("Select an enemy or ally to cast a spell. Type its name. "
        + "Type 'B' to go back.");
    System.out.println("Your enemies: ");
    for (Enemy enemy : finalReality.getEnemies()) {
      if (enemy.getCurrentHp() > 0) {
        System.out.println("* Enemy name: " + enemy.getName() + " | HP : " + enemy.getCurrentHp());
      } else {
        System.out.println("* Enemy name: " + enemy.getName() + " | HP : " + enemy.getCurrentHp()
            + " (dead)");
      }
    }
    System.out.println("Your allies: ");
    for (PlayerCharacter ally : finalReality.getParty()) {
      if (ally.getCurrentHp() > 0) {
        System.out.println("* Ally name: " + ally.getName() + " | HP : " + ally.getCurrentHp());
      } else {
        System.out.println("* Ally name: " + ally.getName() + " | HP : " + ally.getCurrentHp()
            + " (dead)");
      }
    }
    String line2;
    line2 = finalReality.getPlayer().getIn3().readLine();
    if (line2.equals("B")) {
      finalReality.execute(character);
    }
    PlayerCharacter partyMember = (PlayerCharacter) character;
    switch (line) {
      case "T" -> castSpellThunder(line2, partyMember);
      case "F" -> castSpellFire(line2, partyMember);
      case "H" -> castSpellHeal(line2, partyMember);
      case "Po" -> castSpellPoison(line2, partyMember);
      case "Pa" -> castSpellParalysis(line2, partyMember);
      default -> throw new InvalidInputException("Invalid spell name.");
    }

  }

  private void castSpellThunder(String line2, PlayerCharacter partyMember)
      throws InvalidSkillException, InvalidStatValueException, InvalidTargetException {
    boolean found = false;
    ArrayList<Enemy> enemies = finalReality.getEnemies();
    for (Enemy enemy : enemies) {
      if (line2.equals(enemy.getName())) {
        if (enemy.getCurrentHp() > 0) {
          found = true;
          partyMember.castThunder(enemy);
        } else {
          throw new InvalidTargetException("This target is dead.");
        }
      }
    }
    if (!found) {
      throw new InvalidTargetException("Enemy not found.");
    }
  }

  private void castSpellFire(String line2, PlayerCharacter partyMember)
      throws InvalidSkillException, InvalidStatValueException, InvalidTargetException {
    boolean found = false;
    ArrayList<Enemy> enemies = finalReality.getEnemies();
    for (Enemy enemy : enemies) {
      if (line2.equals(enemy.getName())) {
        if (enemy.getCurrentHp() > 0) {
          found = true;
          partyMember.castFire(enemy);
        } else {
          throw new InvalidTargetException("This target is dead.");
        }
      }
    }
    if (!found) {
      throw new InvalidTargetException("Enemy not found.");
    }
  }

  private void castSpellHeal(String line2, PlayerCharacter partyMember)
      throws InvalidSkillException, InvalidStatValueException, InvalidTargetException {
    boolean found = false;
    ArrayList<PlayerCharacter> party = finalReality.getParty();
    for (PlayerCharacter ally : party) {
      if (line2.equals(ally.getName())) {
        if (ally.getCurrentHp() > 0) {
          found = true;
          partyMember.castHeal(ally);
        } else {
          throw new InvalidTargetException("This target is dead.");
        }
      }
    }
    if (!found) {
      throw new InvalidTargetException("Ally not found.");
    }

  }

  private void castSpellPoison(String line2, PlayerCharacter partyMember)
      throws InvalidSkillException, InvalidStatValueException, InvalidTargetException {
    boolean found = false;
    ArrayList<Enemy> enemies = finalReality.getEnemies();
    for (Enemy enemy : enemies) {
      if (line2.equals(enemy.getName())) {
        if (enemy.getCurrentHp() > 0) {
          found = true;
          partyMember.castPoison(enemy);
        } else {
          throw new InvalidTargetException("This target is dead.");
        }
      }
    }
    if (!found) {
      throw new InvalidTargetException("Enemy not found.");
    }
  }

  private void castSpellParalysis(String line2, PlayerCharacter partyMember)
      throws InvalidSkillException, InvalidStatValueException, InvalidTargetException {
    boolean found = false;
    ArrayList<Enemy> enemies = finalReality.getEnemies();
    for (Enemy enemy : enemies) {
      if (line2.equals(enemy.getName())) {
        if (enemy.getCurrentHp() > 0) {
          found = true;
          partyMember.castParalysis(enemy);
        } else {
          throw new InvalidTargetException("This target is dead.");
        }
      }
    }
    if (!found) {
      throw new InvalidTargetException("Enemy not found.");
    }
  }


}
