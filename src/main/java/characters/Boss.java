package characters;

import spells.AbstractSpell;

public class Boss extends AbstractEnemy {
    public Boss(String name, int hitPower, AbstractSpell weakness){
        this.name = name;
        this.hitPower = hitPower;
        this.weakness = weakness;
        this.healPoints = 200;
    }
}
