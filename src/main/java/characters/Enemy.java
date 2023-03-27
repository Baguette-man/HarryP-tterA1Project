package characters;

import spells.AbstractSpell;

public class Enemy extends AbstractEnemy{
    public Enemy(String name, int hitPower, AbstractSpell weakness){
        this.name = name;
        this.hitPower = hitPower;
        this.weakness = weakness;
    }
}
