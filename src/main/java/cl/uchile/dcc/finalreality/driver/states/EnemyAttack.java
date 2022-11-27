package cl.uchile.dcc.finalreality.driver.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.ArrayList;

/**
 * Enemy attack.
 */
public class EnemyAttack extends State {

  @Override
  public void playerIdle() {
    this.changeState(new PlayerIdle());
  }

  @Override
  public void enemyIdle() {
    this.changeState(new EnemyIdle());
  }

  @Override
  public boolean isEnemyAttacking() {
    return true;
  }

  /**
   * An enemy attacks a random party member.
   */
  @Override
  public void execute(GameCharacter character) throws InvalidStatValueException {
    ArrayList<PlayerCharacter> party = finalReality.getParty();
    int index = (int) (Math.random() * party.size());
    PlayerCharacter partyMember = party.get(index);
    System.out.print(character.getName() + " attacks "
        + partyMember.getName() + " dealing ");
    character.attack(partyMember);
  }
}
