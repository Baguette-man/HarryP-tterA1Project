package characters;

import items.Weapon;
import spells.AbstractSpell;

public abstract class AbstractEnemy extends Character {
    protected int hitPower;
    protected AbstractSpell weakness;
    protected Weapon weakness2;

    public void setWeakness(AbstractSpell weakness) {
        this.weakness = weakness;
    }

    public void setWeakness2(Weapon weakness2) {
        this.weakness2 = weakness2;
    }

    public int getHitPower() {
        return hitPower;
    }
    public AbstractSpell getWeakness() {
        return weakness;
    }

    public Weapon getWeakness2() {
        return weakness2;
    }

}
