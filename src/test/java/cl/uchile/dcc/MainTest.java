package cl.uchile.dcc;


import static junit.framework.TestCase.assertNotNull;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Axe;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Bow;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Knife;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Staff;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Sword;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;

/**
 * A class that tests all classes in the package character.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */


public class MainTest {

  private Enemy e1;
  private Enemy e2;
  private Enemy e3;
  private Engineer en1;
  private Engineer en2;
  private Engineer en3;
  private Knight k1;
  private Knight k2;
  private Knight k3;
  private Thief t1;
  private Thief t2;
  private Thief t3;
  private BlackMage bm1;
  private BlackMage bm2;
  private BlackMage bm3;
  private WhiteMage wm1;
  private WhiteMage wm2;
  private WhiteMage wm3;
  private Axe ax1;
  private Axe ax2;
  private Axe ax3;
  private Bow bw1;
  private Bow bw2;
  private Bow bw3;
  private Knife kf1;
  private Knife kf2;
  private Knife kf3;
  private Staff sf1;
  private Staff sf2;
  private Staff sf3;
  private Sword sw1;
  private Sword sw2;
  private Sword sw3;


  @Before
  public void setUp() throws InvalidStatValueException {
    // Queue
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    // Enemy
    e1 = new Enemy("e1", 100, 100, 100, queue);
    e2 = new Enemy("e1", 100, 100, 100, queue);
    e3 = new Enemy("e3", 100, 100, 100, queue);
    // Engineer
    en1 = new Engineer("en1", 100, 100, queue);
    en2 = new Engineer("en1", 100, 100, queue);
    en3 = new Engineer("en3", 100, 100, queue);
    // Knight
    k1 = new Knight("k1", 100, 100, queue);
    k2 = new Knight("k1", 100, 100, queue);
    k3 = new Knight("k3", 100, 100, queue);
    // Thief
    t1 = new Thief("t1", 100, 100, queue);
    t2 = new Thief("t1", 100, 100, queue);
    t3 = new Thief("t3", 100, 100, queue);
    // Black Mage
    bm1 = new BlackMage("bm1", 100, 100, 100, queue);
    bm2 = new BlackMage("bm1", 100, 100, 100, queue);
    bm3 = new BlackMage("bm3", 100, 100, 100, queue);
    // White Mage
    wm1 = new WhiteMage("wm1", 100, 100, 100, queue);
    wm2 = new WhiteMage("wm1", 100, 100, 100, queue);
    wm3 = new WhiteMage("wm3", 100, 100, 100, queue);
    // Weapons
    // Axe
    ax1 = new Axe("ax1", 10, 10);
    ax2 = new Axe("ax1", 10, 10);
    ax3 = new Axe("ax3", 10, 10);
    // Bow
    bw1 = new Bow("bw1", 10, 10);
    bw2 = new Bow("bw1", 10, 10);
    bw3 = new Bow("bw3", 10, 10);
    // Knife
    kf1 = new Knife("kf1", 10, 10);
    kf2 = new Knife("kf1", 10, 10);
    kf3 = new Knife("kf3", 10, 10);
    // Staff
    sf1 = new Staff("sf1", 10, 10, 10);
    sf2 = new Staff("sf1", 10, 10, 10);
    sf3 = new Staff("sf3", 10, 10, 10);
    // Sword
    sw1 = new Sword("sw1", 10, 10);
    sw2 = new Sword("sw1", 10, 10);
    sw3 = new Sword("sw3", 10, 10);

  }

  @Test
  public void testNotNull() {
    assertNotNull(e1);
    assertNotNull(en1);
    assertNotNull(k1);
    assertNotNull(t1);
    assertNotNull(wm1);
    assertNotNull(ax1);
    assertNotNull(bw1);
    assertNotNull(kf1);
    assertNotNull(sf1);
    assertNotNull(sw1);
  }



}
