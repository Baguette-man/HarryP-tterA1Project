package characters;

import items.Wand;
import spells.AbstractSpell;

public class Boss extends AbstractEnemy {
    private Wand wand;
    public Boss(String name, int hitPower, AbstractSpell weakness, Wand wand){
        this.name = name;
        this.hitPower = hitPower;
        this.weakness = weakness;
        this.healPoints = 200;
        this.wand = wand;
    }

    public Wand getWand() {
        return wand;
    }
}
