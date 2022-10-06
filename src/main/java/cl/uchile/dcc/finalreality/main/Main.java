package cl.uchile.dcc.finalreality.main;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Axe;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Bow;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Knife;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Staff;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Sword;
import cl.uchile.dcc.finalreality.model.user.player.Player;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that is meant for testing.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */
public class Main {

  /**
   * Testing.
   */

  public static void main(String[] args) throws InvalidStatValueException {

    System.out.println("Este es un test :D");
    // queue
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    // model
    // OBJECT
    Axe w1 = new Axe("w1", 100, 10);
    Sword w2 = new Sword("w2", 100, 10);
    Knife w3 = new Knife("w3", 100, 10);
    Bow w4 = new Bow("w4", 100, 10);
    Staff w5 = new Staff("w5", 100, 10, 10);
    System.out.println(w1.getName());
    System.out.println(w1.getDamage());
    System.out.println(w1.getWeight());
    System.out.println(w1.hashCode());
    System.out.println(w1);
    System.out.println(w2);
    System.out.println(w3);
    System.out.println(w4);
    System.out.println(w5);
    // PLAYER
    // enemy
    Enemy e1 = new Enemy("e1", 10, 100, 100, queue);
    Enemy e2 = new Enemy("e1", 10, 100, 100, queue);
    Enemy e3 = new Enemy("e3", 10, 50, 50, queue);
    System.out.println(e1.getWeight());
    System.out.println(e1.equals(e2));
    System.out.println(e1.equals(e3));
    System.out.println(e1.hashCode());
    System.out.println(e1);
    // engineer
    Engineer en1 = new Engineer("en1", 100, 100, queue);
    Engineer en2 = new Engineer("en1", 100, 100, queue);
    Engineer en3 = new Engineer("en3", 50, 50, queue);
    System.out.println(en1);
    System.out.println(en1.hashCode());
    System.out.println(en1.equals(en2));
    System.out.println(en1.equals(en3));
    System.out.println(en1.getEquippedWeapon());
    en1.equip(w1);
    System.out.println(en1.getEquippedWeapon());
    // knight
    Knight k1 = new Knight("k1", 100, 100, queue);
    Knight k2 = new Knight("k1", 100, 100, queue);
    Knight k3 = new Knight("k3", 50, 50, queue);
    System.out.println(k1.getName());
    System.out.println(k1.getCurrentHp());
    System.out.println(k1);
    System.out.println(k1.hashCode());
    System.out.println(k1.equals(k2));
    System.out.println(k1.equals(k3));
    // k1.equip()
    // thief
    Thief t1 = new Thief("t1", 100, 100, queue);
    Thief t2 = new Thief("t1", 100, 100, queue);
    Thief t3 = new Thief("t3", 50, 50, queue);
    System.out.println(t1);
    System.out.println(t1.hashCode());
    System.out.println(t1.equals(t2));
    System.out.println(t1.equals(t3));
    // t1.equip()
    // black mage
    BlackMage b1 = new BlackMage("b1", 100, 100, 100, queue);
    BlackMage b2 = new BlackMage("b1", 100, 100, 100, queue);
    BlackMage b3 = new BlackMage("b3", 50, 50, 100, queue);
    System.out.println(b1.getMaxHp());
    System.out.println(b1.equals(b2));
    System.out.println(b1.equals(b3));
    System.out.println(b1.hashCode());
    System.out.println(b1);
    // b1.equip()
    // white mage
    WhiteMage wh1 = new WhiteMage("wh1", 100, 100, 100, queue);
    WhiteMage wh2 = new WhiteMage("wh1", 100, 100, 100, queue);
    WhiteMage wh3 = new WhiteMage("wh3", 50, 50, 100, queue);
    System.out.println(wh1.equals(wh2));
    System.out.println(wh1.equals(wh3));
    System.out.println(wh1.hashCode());
    System.out.println(wh1);
    // w1.equip()
    // USER
    GameCharacter[] party = {en1, wh1, b1};
    Enemy[] enemies = {e1, e2, e3};
    Weapon[] inventory = {w1, w2, w3};
    Player p1 = new Player(party, enemies, inventory);
    Player p2 = new Player(party, enemies, inventory);
    System.out.println(p1.hashCode());
    System.out.println(p1.equals(p2));
    System.out.println(p1);
    System.out.println(Arrays.toString(p1.getParty()));
    System.out.println(Arrays.toString(p1.getEnemies()));
    System.out.println(Arrays.toString(p1.getInventory()));

  }
}
