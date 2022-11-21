package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.driver.FinalReality;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public class Enemy extends AbstractCharacter {

  private final int weight;




  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight, int maxHp, int defense,
               @NotNull final LinkedBlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Enemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
        && name.equals(enemy.name)
        && weight == enemy.weight
        && maxHp == enemy.maxHp
        && defense == enemy.defense;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, name, weight, maxHp, defense);
  }

  @Override
  public String toString() {
    return "Enemy{name=%s, weight=%d, maxHp='%d', defense='%d'}"
        .formatted(name, weight, maxHp, defense);
  }

  /**
   Sets waitTurn depending on the class.
   */
  @Override
  public void setWaitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
        /* command = */ this::addToQueue,
        /* delay = */ this.getWeight() / 10,
        /* unit = */ TimeUnit.SECONDS);
  }


  /**
   * An enemy attacks a random member of the party.
   */
  public void execute(FinalReality finalReality, GameCharacter character)
      throws InvalidStatValueException {
    finalReality.attackParty(character);

  }

  /**
   * Attacks a PlayerCharacter.
   */
  public void attack(GameCharacter gameCharacter) throws InvalidStatValueException {
    Random random = new Random();
    int hp = gameCharacter.getCurrentHp();
    int enemyDamage = random.nextInt(30 - 10) + 10;
    int memberDefense = gameCharacter.getDefense();
    int realDamage = Math.max(0, (enemyDamage - memberDefense));
    int newHp = (hp - realDamage);
    gameCharacter.setCurrentHp(newHp);
    System.out.print(realDamage + " damage!\n");
  }
}
