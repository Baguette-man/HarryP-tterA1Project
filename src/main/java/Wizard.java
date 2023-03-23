import java.util.List;

public class Wizard extends Character{
    public Pet pet;
    public Wand wand;
    public House house;
    public List<Spell> knownSpells;
    public List<Potion> potions;
    public void defend() {
        System.out.println("I'm defending myself");
    }
}
