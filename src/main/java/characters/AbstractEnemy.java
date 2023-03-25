package characters;

public abstract class AbstractEnemy extends Character {
    public int hitPower;

    public int getHitPower() {
        return hitPower;
    }

    public void setHitPower(int hitPower) {
        this.hitPower = hitPower;
    }
}
