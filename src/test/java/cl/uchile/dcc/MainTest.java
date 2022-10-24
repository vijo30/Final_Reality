package cl.uchile.dcc;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
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
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * A class which has all the tests of the project.
 *
 * @author <a href="https://www.github.com/vijo30">V30</a>
 * @author ~José Videla~
 */


public class MainTest {
  private BlockingQueue<GameCharacter> queue;
  private GameCharacter gc1;
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
  private Random rng;


  @Before
  public void setUp() throws InvalidStatValueException {
    // Queue
    queue = new LinkedBlockingQueue<>();
    // GameCharacter
    gc1 = new Enemy("e1", 100, 100, 100, queue);
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
    //
    rng = new Random();

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

  @Test
  public void testEquals() {
    // Enemy
    assertEquals(e1,e1);
    assertEquals(e1,e2);
    assertNotEquals(e3,ax1);
    assertNotEquals(e1,e3);
    // Engineer
    assertEquals(en1,en1);
    assertEquals(en1,en2);
    assertNotEquals(en1,gc1);
    assertNotEquals(en1,en3);
    // Knight
    assertEquals(k1,k1);
    assertEquals(k1,k2);
    assertNotEquals(k1,gc1);
    assertNotEquals(k1,k3);
    // Thief
    assertEquals(t1,t1);
    assertEquals(t1,t2);
    assertNotEquals(t1,gc1);
    assertNotEquals(t1,t3);
    // Black Mage
    assertEquals(bm1,bm1);
    assertEquals(bm1,bm2);
    assertNotEquals(bm1,gc1);
    assertNotEquals(bm1,bm3);
    // White Mage
    assertEquals(wm1,wm1);
    assertEquals(wm1,wm2);
    assertNotEquals(wm1,gc1);
    assertNotEquals(wm1,wm3);
    // Axe
    assertEquals(ax1,ax1);
    assertEquals(ax1,ax2);
    assertNotEquals(ax3,e1);
    assertNotEquals(ax1,ax3);
    // Bow
    assertEquals(bw1,bw1);
    assertEquals(bw1,bw2);
    assertNotEquals(bw1,e1);
    assertNotEquals(bw1,bw3);
    // Knife
    assertEquals(kf1,kf1);
    assertEquals(kf1,kf2);
    assertNotEquals(kf1,e1);
    assertNotEquals(kf1,kf3);
    // Staff
    assertEquals(sf1,sf1);
    assertEquals(sf1,sf2);
    assertNotEquals(sf1,e1);
    assertNotEquals(sf1,sf3);
    // Sword
    assertEquals(sw1,sw1);
    assertEquals(sw1,sw2);
    assertNotEquals(sw1,e1);
    assertNotEquals(sw1,sw3);
  }

  @Test
  public void testToString() {
    assertNotNull(e1.toString());
    assertNotNull(en1.toString());
    assertNotNull(k1.toString());
    assertNotNull(t1.toString());
    assertNotNull(bm1.toString());
    assertNotNull(wm1.toString());
    assertNotNull(ax1.toString());
    assertNotNull(bw1.toString());
    assertNotNull(kf1.toString());
    assertNotNull(sf1.toString());
    assertNotNull(sw1.toString());
    assertEquals(e1.toString(), "Enemy{name=e1, weight=100, maxHp='100', defense='100'}");
    assertEquals(en1.toString(), "Engineer{name='en1', maxHp='100', defense='100'}");
    assertEquals(k1.toString(), "Knight{name='k1', maxHp='100', defense='100'}");
    assertEquals(t1.toString(), "Thief{name='t1', maxHp='100', defense='100'}");
    assertEquals(bm1.toString(), "BlackMage{name='bm1', maxHp='100', defense='100', maxMp='100'}");
    assertEquals(wm1.toString(), "WhiteMage{name='wm1', maxHp='100', defense='100', maxMp='100'}");
    assertEquals(ax1.toString(), "Axe{name='ax1', damage=10, weight=10}");
    assertEquals(bw1.toString(), "Bow{name='bw1', damage=10, weight=10}");
    assertEquals(kf1.toString(), "Knife{name='kf1', damage=10, weight=10}");
    assertEquals(sf1.toString(), "Staff{name='sf1', damage=10, weight=10, magicDamage=10}");
    assertEquals(sw1.toString(), "Sword{name='sw1', damage=10, weight=10}");
  }

  @Test
  public void testHashCode() {
    // Enemy
    assertEquals(e1.hashCode(),e1.hashCode());
    assertEquals(e1.hashCode(),e2.hashCode());
    assertNotEquals(e3.hashCode(),ax1.hashCode());
    assertNotEquals(e1.hashCode(),e3.hashCode());
    // Engineer
    assertEquals(en1.hashCode(),en1.hashCode());
    assertEquals(en1.hashCode(),en2.hashCode());
    assertNotEquals(en1.hashCode(),gc1.hashCode());
    assertNotEquals(en1,en3);
    // Knight
    assertEquals(k1.hashCode(),k1.hashCode());
    assertEquals(k1.hashCode(),k2.hashCode());
    assertNotEquals(k1.hashCode(),gc1.hashCode());
    assertNotEquals(k1.hashCode(),k3.hashCode());
    // Thief
    assertEquals(t1.hashCode(),t1.hashCode());
    assertEquals(t1.hashCode(),t2.hashCode());
    assertNotEquals(t1.hashCode(),gc1.hashCode());
    assertNotEquals(t1.hashCode(),t3.hashCode());
    // Black Mage
    assertEquals(bm1.hashCode(),bm1.hashCode());
    assertEquals(bm1.hashCode(),bm2.hashCode());
    assertNotEquals(bm1.hashCode(),gc1.hashCode());
    assertNotEquals(bm1.hashCode(),bm3.hashCode());
    // White Mage
    assertEquals(wm1.hashCode(),wm1.hashCode());
    assertEquals(wm1.hashCode(),wm2.hashCode());
    assertNotEquals(wm1.hashCode(),gc1.hashCode());
    assertNotEquals(wm1.hashCode(),wm3.hashCode());
    // Axe
    assertEquals(ax1.hashCode(),ax1.hashCode());
    assertEquals(ax1.hashCode(),ax2.hashCode());
    assertNotEquals(ax3.hashCode(),e1.hashCode());
    assertNotEquals(ax1.hashCode(),ax3.hashCode());
    // Bow
    assertEquals(bw1.hashCode(),bw1.hashCode());
    assertEquals(bw1.hashCode(),bw2.hashCode());
    assertNotEquals(bw1.hashCode(),e1.hashCode());
    assertNotEquals(bw1.hashCode(),bw3.hashCode());
    // Knife
    assertEquals(kf1.hashCode(),kf1.hashCode());
    assertEquals(kf1.hashCode(),kf2.hashCode());
    assertNotEquals(kf1.hashCode(),e1.hashCode());
    assertNotEquals(kf1.hashCode(),kf3.hashCode());
    // Staff
    assertEquals(sf1.hashCode(),sf1.hashCode());
    assertEquals(sf1.hashCode(),sf2.hashCode());
    assertNotEquals(sf1.hashCode(),e1.hashCode());
    assertNotEquals(sf1.hashCode(),sf3.hashCode());
    // Sword
    assertEquals(sw1.hashCode(),sw1.hashCode());
    assertEquals(sw1.hashCode(),sw2.hashCode());
    assertNotEquals(sw1.hashCode(),e1.hashCode());
    assertNotEquals(sw1.hashCode(),sw3.hashCode());

  }
  @Test
  public void testSetCurrentHp() throws InvalidStatValueException {
    e1.setCurrentHp(50);
    assertEquals(e1.getCurrentHp(), 50);
  }

  @Test
  public void testGetName() {
    assertEquals(e1.getName(),"e1");
  }

  @Test
  public void testGetMaxHp() {
    assertEquals(e1.getMaxHp(), 100);
  }

  @Test
  public void testGetDefense() {
    assertEquals(e1.getDefense(), 100);
  }

  @Test
  public void testEnemyGetWeight() {
    assertEquals(e1.getWeight(), 100);
  }

  @Test
  public void testWeaponGetWeight() {
    assertEquals(ax1.getWeight(), 10);
  }

  @Test
  public void testMageGetCurrentMp() {
    assertEquals(bm1.getCurrentMp(), 100);
  }

  @Test
  public void testMageSetCurrentMp() throws InvalidStatValueException{
    bm1.setCurrentMp(50);
    assertEquals(bm1.getCurrentMp(), 50);
  }

  @Test
  public void testTimer() throws InterruptedException, InvalidStatValueException {
    var c1 = new Knight("c1", 10, 10, queue);
    var w1 = new Sword("w1", 0, 1);
    c1.equip(w1);
    c1.waitTurn();
    for (int i = 0; i < 10; i++) {
      // Gives a random speed to each character to generate different waiting times
      var weapon = new Knife("", 0, rng.nextInt(2,50));
      var character = new Thief(Integer.toString(i), 10, 10, queue);
      var enemy = new Enemy(Integer.toString(i), rng.nextInt(2,50), 10, 10, queue);
      character.equip(weapon);
      character.waitTurn();
      enemy.waitTurn();
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    assertEquals(Objects.requireNonNull(queue.poll()).toString(), c1.toString());
    //while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      //System.out.println(queue.poll().toString());
    //}
  }

    @Test
    public void testEquip() {
      en1.equip(ax1);
      assertEquals(en1.getEquippedWeapon(),ax1);
      k1.equip(ax1);
      assertEquals(k1.getEquippedWeapon(),ax1);
      t1.equip(ax1);
      assertEquals(t1.getEquippedWeapon(),ax1);
      bm1.equip(ax1);
      assertEquals(bm1.getEquippedWeapon(),ax1);
      wm1.equip(ax1);
      assertEquals(wm1.getEquippedWeapon(),ax1);
    }

    @DisplayName("Require.statValueAtLeast() throws InvalidStatValueException if the actualStat is "
        + "less than least")
    @Test
    public void requireTest1() {
      int least = rng.nextInt(51, 100);
      int actualStat = rng.nextInt(50);
      assertThrows(InvalidStatValueException.class,
          () -> Require.statValueAtLeast(least, actualStat, "test"));
    }
    @DisplayName(
      "Require.statValueAtLeast() does not throw InvalidStatValueException if the "
          + "actualStat is greater than least")
    @Test
    public void requireTest2() {
      int least =  rng.nextInt(50);
      int actualStat = rng.nextInt(51, 100);
      assertDoesNotThrow(() -> Require.statValueAtLeast(least, actualStat, "test"));
    }

    @DisplayName(
        "Require.statValueAtLeast() does not throw InvalidStatValueException if the "
            + "actualStat is equal to least")
    @Test
    public void requireTest3() {
      int least =  rng.nextInt(50);
      assertDoesNotThrow(() -> Require.statValueAtLeast(least, least, "test"));
    }

  @DisplayName("An invalid stat value exception can be thrown with a message.")
  @Test
  public void InvalidStatValueExceptionTest() {
    final String PREFIX = "The provided value is not a valid stat value. ";
    String generatedString = RandomStringUtils.randomAlphabetic(10);
    InvalidStatValueException exception = assertThrows(InvalidStatValueException.class, () -> {
      throw new InvalidStatValueException(generatedString);
    });
    assertEquals(PREFIX + generatedString, exception.getMessage());
  }

}
