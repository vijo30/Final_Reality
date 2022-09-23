package cl.uchile.dcc.finalreality.main;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.object.weapon.WeaponType;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    /**
     * A class that is meant for testing.
     *
     * @author <a href="https://www.github.com/vijo30">V30</a>
     * @author ~José Videla~
     */
    public static void main(String[] args) throws InvalidStatValueException {
        System.out.println("Este es un test :D");
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Weapon weapon = new Weapon("Destructor", 100, 10, WeaponType.AXE);
        PlayerCharacter engineer = new Engineer("Io", 100, 100, queue);
        Enemy enemy = new Enemy("Oi", 100, 100, 100, queue);
        System.out.println(weapon.toString());
        System.out.println(engineer.toString());
        System.out.println(enemy.toString());
    }
}
