package cl.uchile.dcc.finalreality.model.object.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

/**
 * Handles a PlayerCharacter in order to determinate if it can be equipped by a valid character.
 */

public interface Equip {

  /**
   * Handles the type of player.
   */
  void handle(PlayerCharacter playerCharacter) throws InvalidStatValueException;
}
