package cl.uchile.dcc.finalreality.main;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.object.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.object.weapon.WeaponType;
import cl.uchile.dcc.finalreality.model.user.player.Player;

import java.util.Arrays;
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
        System.out.println(weapon);
        System.out.println(engineer);
        System.out.println(enemy);
        Weapon[] Lweapon = {weapon, weapon};
        System.out.println(Arrays.toString(Lweapon));
        PlayerCharacter[] Lplc = {engineer,engineer,engineer};
        System.out.println(Arrays.toString(Lplc));
        Enemy[] en = {enemy};
        Player player0 = new Player(Lplc, en, Lweapon);
        System.out.println(player0);
        System.out.println(engineer.getEquippedWeapon());
        engineer.equip(weapon);
        System.out.println(engineer.getEquippedWeapon());
        PlayerCharacter mage = new WhiteMage("ty", 100, 100, 100, 100, queue);
        System.out.println(weapon.getType().equals(WeaponType.STAFF));
        System.out.println(engineer.getEquippedWeapon().getType());
        /*mage.equip(weapon); throws an exception
        System.out.println(mage.getEquippedWeapon().getType().equals(WeaponType.STAFF));
        System.out.println(mage.getEquippedWeapon());*/

    }
}
