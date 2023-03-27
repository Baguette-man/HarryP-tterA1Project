package characters;

import spells.AbstractSpell;

public abstract class AbstractEnemy extends Character {
    public int hitPower;
    public AbstractSpell weakness;

    public int getHitPower() {
        return hitPower;
    }

    public void setHitPower(int hitPower) {
        this.hitPower = hitPower;
    }
}
