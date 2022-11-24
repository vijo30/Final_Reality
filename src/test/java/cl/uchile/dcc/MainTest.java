package cl.uchile.dcc;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.finalreality.driver.FinalReality;
import cl.uchile.dcc.finalreality.driver.Player;
import cl.uchile.dcc.finalreality.exceptions.InvalidSkillException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.states.State;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapons;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Axe;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Bow;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Knife;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Staff;
import cl.uchile.dcc.finalreality.model.object.weapon.types.Sword;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
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
  private LinkedBlockingQueue<GameCharacter> queue;
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
  private FinalReality finalReality;
  private ArrayList<PlayerCharacter> party;
  private ArrayList<Enemy> enemies;
  private ArrayList<Weapons> inventory;
  private Player player;



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
    party = new ArrayList<>();
    enemies = new ArrayList<>();
    inventory = new ArrayList<>();
    player = new Player("Tete");


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
  public void testWeaponGetMagicDamage() {
    assertEquals(ax1.getMagicDamage(), 0);
    assertEquals(sf1.getMagicDamage(),10);
  }

  @Test
  public void testMageGetCurrentMp() {
    assertEquals(bm1.getCurrentMp(), 100);
  }

  @Test
  public void testMageSetCurrentMp() throws InvalidStatValueException {
    bm1.setCurrentMp(50);
    assertEquals(bm1.getCurrentMp(), 50);
  }

  @Test
  public void testGetQueue() throws InvalidStatValueException {
    t1.equip(kf1);
    t1.setWaitTurn();
    assertEquals(t1.getQueue(), queue);
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
    Thread.sleep(7000);
    assertEquals(Objects.requireNonNull(queue.poll()), c1);
    System.out.println(queue);
    //while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      //System.out.println(queue.poll().toString());
    //}
  }

    @Test
    public void testEquip() throws InvalidStatValueException {
      en1.equip(ax1);
      assertEquals(en1.getEquippedWeapon(),ax1);
      k1.equip(ax1);
      assertEquals(k1.getEquippedWeapon(),ax1);
      t1.equip(kf1);
      assertEquals(t1.getEquippedWeapon(),kf1);
      bm1.equip(sf1);
      assertEquals(bm1.getEquippedWeapon(),sf1);
      wm1.equip(sf1);
      assertEquals(wm1.getEquippedWeapon(),sf1);
    }

    @Test
    public void testEquip2() throws InvalidStatValueException {
      // Engineer
      en1.equip(ax1);
      assertEquals(en1.getEquippedWeapon(),ax1);
      en1.equip(bw1);
      assertEquals(en1.getEquippedWeapon(),bw1);
      assertThrows(InvalidStatValueException.class, () -> en1.equip(kf1));
      assertThrows(InvalidStatValueException.class, () -> en1.equip(sf1));
      assertThrows(InvalidStatValueException.class, () -> en1.equip(sw1));
      // Knight
      k1.equip(sw1);
      assertEquals(k1.getEquippedWeapon(),sw1);
      k1.equip(ax1);
      assertEquals(k1.getEquippedWeapon(),ax1);
      k1.equip(kf1);
      assertEquals(k1.getEquippedWeapon(),kf1);
      assertThrows(InvalidStatValueException.class, () -> k1.equip(sf1));
      assertThrows(InvalidStatValueException.class, () -> k1.equip(bw1));
      // Thief
      t1.equip(sw1);
      assertEquals(t1.getEquippedWeapon(),sw1);
      t1.equip(kf1);
      assertEquals(t1.getEquippedWeapon(),kf1);
      t1.equip(bw1);
      assertEquals(t1.getEquippedWeapon(),bw1);
      assertThrows(InvalidStatValueException.class, () -> t1.equip(sf1));
      assertThrows(InvalidStatValueException.class, () -> t1.equip(ax1));
      // Black Mage
      bm1.equip(kf1);
      assertEquals(bm1.getEquippedWeapon(),kf1);
      bm1.equip(sf1);
      assertEquals(bm1.getEquippedWeapon(),sf1);
      assertThrows(InvalidStatValueException.class, () -> bm1.equip(ax1));
      assertThrows(InvalidStatValueException.class, () -> bm1.equip(bw1));
      assertThrows(InvalidStatValueException.class, () -> bm1.equip(sw1));
      // White Mage
      wm1.equip(sf1);
      assertEquals(bm1.getEquippedWeapon(),sf1);
      assertThrows(InvalidStatValueException.class, () -> wm1.equip(kf1));
      assertThrows(InvalidStatValueException.class, () -> wm1.equip(ax1));
      assertThrows(InvalidStatValueException.class, () -> wm1.equip(bw1));
      assertThrows(InvalidStatValueException.class, () -> wm1.equip(sw1));
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

  @DisplayName("An invalid stat value exception can be thrown with a message.")
  @Test
  public void InvalidSkillExceptionTest() {
    final String PREFIX = "You don't have that skill. ";
    String generatedString = RandomStringUtils.randomAlphabetic(10);
    InvalidSkillException exception = assertThrows(InvalidSkillException.class, () -> {
      throw new InvalidSkillException(generatedString);
    });
    assertEquals(PREFIX + generatedString, exception.getMessage());
  }

  @Test
  public void finalRealityInit() throws InvalidStatValueException, InterruptedException {
    k1.equip(ax1);
    party.add(k1);


    enemies.add(e1);
    enemies.add(e2);
    enemies.add(e3);

    inventory.add(ax1);
    inventory.add(sf1);
    Player player = new Player("A");
    finalReality = new FinalReality(party, enemies, inventory, player);

    assertNotNull(finalReality);
    assertNotNull(finalReality.getParty());
    assertNotNull(finalReality.getEnemies());
    assertNotNull(finalReality.getInventory());
  }

  @Test
  public void finalRealityIsOver1() throws InvalidStatValueException, InterruptedException {
    Knight knight = new Knight("Knight", 100, 10, queue);
    knight.equip(ax1);
    Enemy enemy = new Enemy("Enemy", 10, 100, 10, queue);
    enemy.setCurrentHp(0);
    e1.setCurrentHp(0);
    party.add(knight);
    enemies.add(enemy);
    enemies.add(e1);
    Player player = new Player("A");
    finalReality = new FinalReality(party, enemies, inventory, player);
    assertTrue(finalReality.isOver());
    assertTrue(finalReality.deadEnemy());
    assertFalse(finalReality.deadPlayer());
  }

  @Test
  public void finalRealityIsOver2() throws InvalidStatValueException, InterruptedException {
    Knight knight = new Knight("Knight", 100, 10, queue);
    Enemy enemy = new Enemy("Enemy", 10, 100, 10, queue);
    knight.equip(ax1);
    t1.equip(kf1);
    knight.setCurrentHp(0);
    t1.setCurrentHp(0);
    party.add(knight);
    party.add(t1);
    enemies.add(enemy);
    Player player = new Player("A");
    finalReality = new FinalReality(party, enemies, inventory, player);
    assertTrue(finalReality.isOver());
    assertTrue(finalReality.deadPlayer());
    assertFalse(finalReality.deadEnemy());
  }

  @Test
  public void finalRealityIsOver3() throws InvalidStatValueException, InterruptedException {
    var knight = new Knight("Knight", 100, 10, queue);
    Enemy enemy = new Enemy("Enemy", 10, 100, 10, queue);
    knight.equip(ax1);
    t1.equip(kf1);
    party.add(knight);
    t1.setCurrentHp(0);
    party.add(t1);
    enemies.add(enemy);
    enemies.add(e1);
    Player player = new Player("A");

    finalReality = new FinalReality(party, enemies, inventory, player);
    assertFalse(finalReality.isOver());
    assertFalse(finalReality.deadPlayer());
    assertFalse(finalReality.deadEnemy());
  }

  @Test
  public void finalRealityUpdate()
      throws InvalidStatValueException, IOException, InterruptedException, InvalidSkillException {
    Knight knight = new Knight("Knight", 100, 10, queue);
    Enemy enemy = new Enemy("Enemy", 10, 100, 10, queue);
    Axe ax1 = new Axe("Elacha2000", 10, 20);
    knight.equip(ax1);
    party.add(knight);
    enemies.add(enemy);
    finalReality = new FinalReality(party, enemies, inventory, player);
    finalReality.update();

  }

  @Test
  public void finalRealityUpdate2()
      throws InvalidStatValueException, IOException, InterruptedException, InvalidSkillException {

    Knight knight = new Knight("Knight", 100, 10, queue);
    Enemy enemy = new Enemy("Enemy", 20, 100, 10, queue);
    Axe ax1 = new Axe("Elacha2000", 50, 10);
    knight.equip(ax1);
    knight.waitTurn();
    enemy.waitTurn();
    party.add(knight);
    enemies.add(enemy);
    Player player2 = new Player("A", "A", "Enemy");
    finalReality = new FinalReality(party, enemies, inventory, player2);
    finalReality.update();
    assertEquals(enemy.getCurrentHp(), 60);

  }

  @Test
  public void finalRealityUpdate3()
      throws InvalidStatValueException, IOException, InterruptedException, InvalidSkillException {

    Knight knight = new Knight("Knight", 100, 10, queue);
    Enemy enemy = new Enemy("Enemy", 20, 100, 10, queue);
    Axe ax1 = new Axe("Elacha2000", 50, 10);
    Knife kf1 = new Knife("El'kucharon", 50, 10);
    knight.equip(ax1);
    knight.waitTurn();
    enemy.waitTurn();
    party.add(knight);
    enemies.add(enemy);
    inventory.add(kf1);
    Player player2 = new Player("A", "E", "El'kucharon");
    finalReality = new FinalReality(party, enemies, inventory, player2);
    finalReality.update();
    assertEquals(knight.getEquippedWeapon(), kf1);
    assertEquals(inventory.get(0), ax1);

  }

  @Test
  public void finalRealityUpdate4()
      throws InvalidStatValueException, IOException, InterruptedException, InvalidSkillException {

    Random random = new Random();
    WhiteMage benedictus = new WhiteMage("Brother Benedictus", 100, 2,
        100, queue);
    BlackMage marcellus = new BlackMage("Dark Lord Marcellus", 100, 2,
        100, queue);
    Staff purifier = new Staff("The Purifier", 10, 12, 50);
    Staff soul = new Staff("The Soulripper", 10, 2, 60);
    Staff rod = new Staff("Wisdom Rod", 10, 1, 40);
    marcellus.equip(soul);
    benedictus.equip(purifier);
    party.add(marcellus);
    party.add(benedictus);
    inventory.add(rod);
    int r = random.nextInt(5 - 1) + 1;
    for (int i = 0; i < r; i++) {
      Enemy enemy = new Enemy("Mindless Ghoul " + i,
          10, 100, 3, queue);
      enemies.add(enemy);
    }
    Player n_player = new Player("Vijo30", "S", "T", "Mindless Ghoul 0");
    FinalReality fr = new FinalReality(party, enemies, inventory, n_player);
    fr.update();
    for (Enemy enemy : enemies) {
      if (enemy.getName().equals("Mindless Ghoul 0")) {
        assertEquals(enemy.getCurrentHp(), enemy.getMaxHp()
            - marcellus.getEquippedWeapon().getMagicDamage() + enemy.getDefense());
      }
    }
  }

  @Test
  public void finalRealityUpdate5()
      throws InvalidStatValueException, IOException, InterruptedException, InvalidSkillException {

    Random random = new Random();
    WhiteMage benedictus = new WhiteMage("Brother Benedictus", 100, 2,
        100, queue);
    BlackMage marcellus = new BlackMage("Dark Lord Marcellus", 100, 2,
        100, queue);
    Staff purifier = new Staff("The Purifier", 10, 12, 50);
    Staff soul = new Staff("The Soulripper", 10, 2, 60);
    Staff rod = new Staff("Wisdom Rod", 10, 1, 40);
    marcellus.equip(soul);
    benedictus.equip(purifier);
    party.add(marcellus);
    party.add(benedictus);
    inventory.add(rod);
    int r = random.nextInt(5 - 1) + 1;
    for (int i = 0; i < r; i++) {
      Enemy enemy = new Enemy("Mindless Ghoul " + i,
          10, 100, 3, queue);
      enemies.add(enemy);
    }
    Player n_player = new Player("Vijo30", "S", "F", "Mindless Ghoul 0");
    FinalReality fr = new FinalReality(party, enemies, inventory, n_player);
    fr.update();
    for (Enemy enemy : enemies) {
      if (enemy.getName().equals("Mindless Ghoul 0")) {
        assertEquals(enemy.getCurrentHp(), enemy.getMaxHp()
            - marcellus.getEquippedWeapon().getMagicDamage() + enemy.getDefense());
      }
    }
  }

  @Test
  public void finalRealityUpdate6()
      throws InvalidStatValueException, IOException, InterruptedException, InvalidSkillException {

    Random random = new Random();
    WhiteMage benedictus = new WhiteMage("Brother Benedictus", 100, 2,
        100, queue);
    BlackMage marcellus = new BlackMage("Dark Lord Marcellus", 100, 2,
        100, queue);
    Staff purifier = new Staff("The Purifier", 10, 2, 50);
    Staff soul = new Staff("The Soulripper", 10, 12, 60);
    Staff rod = new Staff("Wisdom Rod", 10, 1, 40);
    marcellus.equip(soul);
    benedictus.equip(purifier);
    party.add(marcellus);
    party.add(benedictus);
    inventory.add(rod);
    int r = random.nextInt(5 - 1) + 1;
    for (int i = 0; i < r; i++) {
      Enemy enemy = new Enemy("Mindless Ghoul " + i,
          10, 100, 3, queue);
      enemies.add(enemy);
    }
    Player n_player = new Player("Vijo30", "S", "Po", "Mindless Ghoul 0");
    FinalReality fr = new FinalReality(party, enemies, inventory, n_player);
    fr.update();
    for (Enemy enemy : enemies) {
      if (enemy.getName().equals("Mindless Ghoul 0")) {
        assertTrue(enemy.isPoisoned());
      }
    }
  }

  @Test
  public void finalRealityUpdate7()
      throws InvalidStatValueException, IOException, InterruptedException, InvalidSkillException {

    Random random = new Random();
    WhiteMage benedictus = new WhiteMage("Brother Benedictus", 100, 2,
        100, queue);
    BlackMage marcellus = new BlackMage("Dark Lord Marcellus", 100, 2,
        100, queue);
    Staff purifier = new Staff("The Purifier", 10, 2, 50);
    Staff soul = new Staff("The Soulripper", 10, 12, 60);
    Staff rod = new Staff("Wisdom Rod", 10, 1, 40);
    marcellus.equip(soul);
    benedictus.equip(purifier);
    party.add(marcellus);
    party.add(benedictus);
    inventory.add(rod);
    int r = random.nextInt(5 - 1) + 1;
    for (int i = 0; i < r; i++) {
      Enemy enemy = new Enemy("Mindless Ghoul " + i,
          10, 100, 3, queue);
      enemies.add(enemy);
    }
    Player n_player = new Player("Vijo30", "S", "Pa", "Mindless Ghoul 0");
    FinalReality fr = new FinalReality(party, enemies, inventory, n_player);
    fr.update();
    for (Enemy enemy : enemies) {
      if (enemy.getName().equals("Mindless Ghoul 0")) {
        assertTrue(enemy.isParalyzed());
      }
    }
  }

  @Test
  public void finalRealityUpdate8()
      throws InvalidStatValueException, IOException, InterruptedException, InvalidSkillException {

    Random random = new Random();
    WhiteMage benedictus = new WhiteMage("Brother Benedictus", 100, 2,
        100, queue);
    BlackMage marcellus = new BlackMage("Dark Lord Marcellus", 100, 2,
        100, queue);
    Staff purifier = new Staff("The Purifier", 10, 2, 50);
    Staff soul = new Staff("The Soulripper", 10, 12, 60);
    Staff rod = new Staff("Wisdom Rod", 10, 1, 40);
    marcellus.equip(soul);
    benedictus.equip(purifier);
    party.add(marcellus);
    party.add(benedictus);
    inventory.add(rod);
    int r = random.nextInt(5 - 1) + 1;
    for (int i = 0; i < r; i++) {
      Enemy enemy = new Enemy("Mindless Ghoul " + i,
          10, 100, 3, queue);
      enemies.add(enemy);
    }
    Player n_player = new Player("Vijo30", "S", "H", "Brother Benedictus");
    FinalReality fr = new FinalReality(party, enemies, inventory, n_player);
    fr.update();
    for (PlayerCharacter ally : party) {
      if (ally.getName().equals("Brother Benedictus")) {
        assertEquals(ally.getMaxHp(), 100);
      }
    }
  }
  @Test
  public void finalRealityUpdateBig()
      throws InvalidStatValueException, InterruptedException, IOException, InvalidSkillException {
    Random random = new Random();
    Knight roderick = new Knight("Sir Roderick", 100, 30, queue);
    Thief jorge = new Thief("Don Jorge", 100, 10, queue);
    Engineer marcus = new Engineer("Chief Engineer Marcus", 100, 5, queue);
    Sword coldbringer = new Sword("The Coldbringer", 50, 20);
    Knife gutsripper = new Knife("The Gutsripper", 30, 5);
    Axe mech = new Axe("Engineer Battle Axe", 40, 10);
    Staff rod = new Staff("Wisdom Rod", 10, 10, 40);
    roderick.equip(coldbringer);
    jorge.equip(gutsripper);
    marcus.equip(mech);
    party.add(roderick);
    party.add(jorge);
    party.add(marcus);
    inventory.add(rod);
    int r = random.nextInt(5 - 1) + 1;
    for (int i = 0; i < r; i++) {
      Enemy enemy = new Enemy("Mindless Ghoul " + i,
          10, 100, 3, queue);
      enemies.add(enemy);
    }
    Player n_player = new Player("Vijo30", "A", "Mindless Ghoul 0");
    FinalReality fr = new FinalReality(party, enemies, inventory, n_player);
    fr.update();
    for (Enemy enemy : enemies) {
      if (enemy.getName().equals("Mindless Ghoul 0")) {
        assertEquals(enemy.getCurrentHp(), enemy.getMaxHp()
            - jorge.getEquippedWeapon().getDamage() + enemy.getDefense());
      }
    }
  }

  @Test
  public void stateNormalTest() throws InvalidStatValueException {
    assertTrue(bm1.isNormal());
    bm1.applyEffect(); // does nothing
    assertThrows(AssertionError.class, () -> bm1.undo());
  }

  @Test
  public void stateParalyzeTest() throws InvalidStatValueException {
    bm1.paralyze();
    assertTrue(bm1.isParalyzed());
    bm1.applyEffect(); // does nothing just prints a message
    assertThrows(AssertionError.class, () -> bm1.paralyze());
    assertThrows(AssertionError.class, () -> bm1.burn());
    assertThrows(AssertionError.class, () -> bm1.poison());
    bm1.undo();
    assertTrue(bm1.isNormal());
  }

  @Test
  public void stateBurnTest() throws InvalidStatValueException {
    bm1.burn();
    assertTrue(bm1.isBurned());
    bm1.applyEffect();
    assertEquals(bm1.getCurrentHp(), bm1.getMaxHp() - ( (bm1.getMaxHp() / 2)));
    assertThrows(AssertionError.class, () -> bm1.paralyze());
    assertThrows(AssertionError.class, () -> bm1.burn());
    assertThrows(AssertionError.class, () -> bm1.poison());
    bm1.undo();
    assertTrue(bm1.isNormal());
  }

  @Test
  public void statePoisonTest() throws InvalidStatValueException {
    bm1.poison();
    assertTrue(bm1.isPoisoned());
    bm1.applyEffect();
    assertEquals(bm1.getCurrentHp(), bm1.getMaxHp() - ( (bm1.getMaxHp() / 3)));
    assertThrows(AssertionError.class, () -> bm1.paralyze());
    assertThrows(AssertionError.class, () -> bm1.burn());
    assertThrows(AssertionError.class, () -> bm1.poison());
    bm1.undo();
    assertTrue(bm1.isNormal());
  }

  @Test
  public void testState() {
    State state = new State();
    assertFalse(state.isParalyzed());
    assertFalse(state.isBurned());
    assertFalse(state.isParalyzed());
    assertFalse(state.isNormal());
    assertThrows(AssertionError.class, () -> state.applyEffect(bm1));
  }

  @Test
  public void testTurn() {
    assertEquals(bm1.getTurn(), 0);
    bm1.setTurn(1);
    assertEquals(bm1.getTurn(), 1);
    bm1.setTurnEffect(bm1.getTurn());
    assertEquals(bm1.getTurnEffect(), 1);
  }

  @Test
  public void testCastThunder() throws InvalidStatValueException {
    wm1.equip(sf1);
    assertThrows(InvalidSkillException.class, () -> wm1.castThunder(bm1));
    bm1.equip(sf1);
    bm1.castThunder(wm1);
    int hp = wm1.getCurrentHp();
    int weaponDamage = bm1.getEquippedWeapon().getMagicDamage();
    int defense = wm1.getDefense();
    int realDamage = Math.max(0, weaponDamage - defense);
    int newHp = Math.max(0, hp - realDamage);
    assertEquals(hp, newHp);
    bm1.setCurrentMp(0);
    assertThrows(AssertionError.class, () -> bm1.castThunder(wm1));
  }

  @Test
  public void testCastFire() throws InvalidStatValueException {
    wm1.equip(sf1);
    assertThrows(InvalidSkillException.class, () -> wm1.castFire(bm1));
    bm1.equip(sf1);
    bm1.castFire(wm1);
    int hp = wm1.getCurrentHp();
    int weaponDamage = bm1.getEquippedWeapon().getMagicDamage();
    int defense = wm1.getDefense();
    int realDamage = Math.max(0, weaponDamage - defense);
    int newHp = Math.max(0, hp - realDamage);
    assertEquals(hp, newHp);
    bm1.setCurrentMp(0);
    assertThrows(AssertionError.class, () -> bm1.castFire(wm1));
  }



  @Test
  public void testCastHeal() throws InvalidStatValueException {
    bm1.equip(sf1);
    assertThrows(InvalidSkillException.class, () -> bm1.castHeal(wm1));
    wm1.equip(sf1);
    wm1.castHeal(bm1);
    int hp = bm1.getCurrentHp();
    int newHp = Math.min(hp + (int) (0.3 * bm1.getMaxHp()), bm1.getMaxHp());
    bm1.setCurrentHp(Math.min(hp + (int) (0.3 * bm1.getMaxHp()), bm1.getMaxHp()));
    assertEquals(hp, newHp);
    wm1.setCurrentMp(0);
    assertThrows(AssertionError.class, () -> wm1.castHeal(bm1));
  }

  @Test
  public void testCastPoison() throws InvalidStatValueException {
    bm1.equip(sf1);
    assertThrows(InvalidSkillException.class, () -> bm1.castPoison(wm1));
    wm1.equip(sf1);
    wm1.castPoison(bm1);
    assertTrue(bm1.isPoisoned());
    wm1.setCurrentMp(0);
    assertThrows(AssertionError.class, () -> wm1.castPoison(bm1));
  }

  @Test
  public void testCastParalysis() throws InvalidStatValueException {
    bm1.equip(sf1);
    assertThrows(InvalidSkillException.class, () -> bm1.castParalysis(wm1));
    wm1.equip(sf1);
    wm1.castParalysis(bm1);
    assertTrue(bm1.isParalyzed());
    wm1.setCurrentMp(0);
    assertThrows(AssertionError.class, () -> wm1.castParalysis(bm1));
  }

  @Test
  public void testGetPlayerName() {
    assertEquals(player.getName(), "Tete");
  }

  @Test
  public void testFinalRealityEqualsHashCode() throws InterruptedException {
    Player p1 = new Player("A");
    Player p2 = new Player("B");
    FinalReality fr1 = new FinalReality(party, enemies, inventory, p1);
    FinalReality fr2 = new FinalReality(party, enemies, inventory, p2);
    FinalReality fr3 = new FinalReality(party, enemies, inventory, p1);
    assertNotEquals(fr1,fr2);
    assertEquals(fr1,fr3);
    assertNotEquals(fr1.hashCode(), fr2.hashCode());
    assertEquals(fr1.hashCode(), fr3.hashCode());
  }



  @Test
  public void testFinalRealityRefillQueue()
      throws InterruptedException, InvalidSkillException, InvalidStatValueException, IOException {
    Player p1 = new Player("A");
    enemies.add(e1);
    bm1.equip(sf1);
    party.add(bm1);
    bm1.setCurrentHp(0);
    e1.setCurrentHp(0);
    FinalReality fr1 = new FinalReality(party, enemies, inventory, p1);
    e1.getQueue().poll();
    fr1.update();
    assertFalse(bm1.getQueue().isEmpty());

  }








}
