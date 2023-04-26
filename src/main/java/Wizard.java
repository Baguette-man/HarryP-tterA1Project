import java.util.List;

public class Wizard extends Character{
    public Pet pet;
    public Wand wand;
    public House house;



    public List<Spell> knownSpells;
    public List<Potion> potions;
    public Wizard(String name){
        this.name = name;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void defend() {
        System.out.println("I'm defending myself");
    }
}
