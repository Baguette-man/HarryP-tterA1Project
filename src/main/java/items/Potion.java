package items;

public class Potion {
    public String name;
    public int heal;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public Potion(String name, int heal){
        this.name = name;
        this.heal = heal;
    }
}
