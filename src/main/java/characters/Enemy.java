package characters;

import spells.AbstractSpell;
import items.Weapon;

public class Enemy extends AbstractEnemy{
    public Enemy(String name, int hitPower, AbstractSpell weakness){
        this.name = name;
        this.hitPower = hitPower;
        this.weakness = weakness;
    }

    public Enemy(String name, int hitPower, AbstractSpell weakness, Weapon weakness2){
        this.name = name;
        this.hitPower = hitPower;
        this.weakness = weakness;
        this.weakness2 = weakness2;
    }
}
