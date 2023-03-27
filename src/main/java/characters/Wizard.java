package characters;
import spells.*;
import items.*;
import environment.*;

import java.util.*;

public class Wizard extends Character{
    public Pet pet;
    public Wand wand;
    public House house;
    public List<AbstractSpell> knownSpells = new ArrayList<>();
    public List<Potion> potions = new ArrayList<>();
    public Map<String, Double> stats = new HashMap<>();
    public Wizard(String name){
        this.name = name;
        stats.put("Potions Efficiency", 1.0);
        stats.put("Spells Damages", 1.0);
        stats.put("Shield", 1.0);
        stats.put("Spells Precision", 0.5);
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void applyAsset(String houseName){
        switch (houseName){
            case "Hufflepuff":
                stats.put("Potions Efficiency",stats.get("Potions Efficiency")+0.5);
                System.out.println("As a member of Hufflepuff, you get a 50% bonus on Potions efficiency!");
                break;

            case "Slytherin":
                stats.put("Spells Damages",stats.get("Spells Damages")+0.5);
                System.out.println("As a member of Slytherin, you get a 50% bonus on Spells damages!");
                break;

            case "Gryffindor":
                stats.put("Shield",stats.get("Shield")+0.5);
                System.out.println("As a member of Gryffindor, you get a 50% bonus on your damage resistance!");
                break;

            case "Ravenclaw":
                stats.put("Spells Precision",stats.get("Spells Precision")+0.25);
                System.out.println("As a member of Ravenclaw, you get a 50% bonus on Spells Precision!");
                break;
        }
    }

    public void defend(Wizard wizard,AbstractEnemy enemy) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are getting attacked by "+enemy.getName()+"! You have 2 choices : either you try to dodge the attack (it may fail), other you chose to take the hit and lose less HP. What do you wanna do (type 'dodge' or 'take')?  :");
        String choice = scanner.nextLine();
        while (!choice.equals("dodge") && !choice.equals("take")) {
            System.out.println("Error : Please type 'dodge' or 'take'");
            choice = scanner.nextLine();
        }
        Thread.sleep(3000);
        switch (choice){
            case "dodge":
                Random rand = new Random();
                int randInt = rand.nextInt(2);
                if (randInt==0){
                    System.out.println("Dodge failed, you are taking the full hit!");
                    wizard.setHealPoints(wizard.getHealPoints()-(enemy.getHitPower()/stats.get("Shield")));
                } else {
                    System.out.println("You are lucky, you dodged his attack!");
                }
                break;

            case "take":
                System.out.println("You are taking the hit!");
                wizard.setHealPoints(wizard.getHealPoints()-((enemy.getHitPower()/2)/stats.get("Shield")));
                break;
        }
        isCharacterAlive(wizard);
    }

    public void drinkPotion(Potion potion, Wizard wizard) throws InterruptedException {
        System.out.println("Drinking "+potion.getName()+"...");
        Thread.sleep(3000);
        wizard.setHealPoints(potion.getHeal()*stats.get("Potions Efficiency")+wizard.getHealPoints());
        potions.remove(potion);
        System.out.println("You have now "+wizard.getHealPoints()+"HP!");
    }

    public void attackWithSpell(AbstractSpell spell, AbstractEnemy enemy) throws InterruptedException {
        System.out.println("Using "+spell.getName()+" against "+enemy.getName()+"...");
        Thread.sleep(3000);
        Random rand = new Random();
        int randInt = rand.nextInt(100);
        if (randInt>100*stats.get("Spells Precision")){
            System.out.println("Attack failed, you lacked precision!");
        } else {
            System.out.println("Nice hit!");
            enemy.setHealPoints(enemy.getHealPoints()-spell.getDamage()*stats.get("Spells Damages"));
            enemy.isCharacterAlive(enemy);
        }
    }

    public void getAPet(){
        Random rand = new Random();
        int randIntPet = rand.nextInt(Pet.values().length);
        this.pet = Pet.values()[randIntPet];
    }

    @Override
    public boolean isCharacterAlive(Character character){
        if (character.getHealPoints()>=0) {
            System.out.println("You are still alive with "+character.getHealPoints()+" HP!");
            return true;
        } else {
            System.out.println("You are dead!");
            System.exit(0);
            return false;
        }
    }

    public void getReward(Potion potion, AbstractSpell abstractSpell){
        potions.add(potion);
        knownSpells.add(abstractSpell);
        System.out.println("You received "+potion.getName()+" ("+potion.getHeal()+"HP) & "+abstractSpell.getName()+" ("+abstractSpell.getDamage()+"DMG) in your inventory");
    }
}
