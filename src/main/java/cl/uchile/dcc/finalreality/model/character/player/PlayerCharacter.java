package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */


import cl.uchile.dcc.finalreality.exceptions.InvalidSkillException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapons;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Axe;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Bow;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Knife;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Staff;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Sword;

/**
 * A {@link GameCharacter} that can equip a weapon.
 */
public interface PlayerCharacter extends GameCharacter {
  /**
   * Equips a weapon to the character.
   */
  void equip(Weapons weapon) throws InvalidStatValueException;

  /**
   * Equips an axe to the character.
   */
  void equipAxe(Axe axe) throws InvalidStatValueException;

  /**
   * Equips a bow to the character.
   */
  void equipBow(Bow bow) throws InvalidStatValueException;

  /**
   * Equips a knife to the character.
   */
  void equipKnife(Knife knife) throws InvalidStatValueException;

  /**
   * Equips a staff to the character.
   */
  void equipStaff(Staff staff) throws InvalidStatValueException;

  /**
   * Equips a sword to the character.
   */
  void equipSword(Sword sword) throws InvalidStatValueException;


  /**
   * Return this character's equipped weapon.
   */
  Weapon getEquippedWeapon();


  /**
   * Casts the spell Thunder.
   */
  void castThunder(GameCharacter gameCharacter)
      throws InvalidSkillException, InvalidStatValueException;

  /**
   * Casts the spell Thunder.
   */
  void castFire(GameCharacter gameCharacter) throws InvalidSkillException,
      InvalidStatValueException;

  /**
   * Casts the spell Fire.
   */
  void castHeal(GameCharacter gameCharacter) throws InvalidSkillException,
      InvalidStatValueException;

  /**
   * Casts the spell Poison.
   */
  void castPoison(GameCharacter gameCharacter) throws InvalidSkillException,
      InvalidStatValueException;

  /**
   * Casts the spell Paralysis.
   */
  void castParalysis(GameCharacter gameCharacter) throws InvalidSkillException,
      InvalidStatValueException;



}
