import characters.AbstractEnemy;
import characters.Boss;
import characters.Enemy;
import characters.Wizard;
import environment.House;
import environment.SortingHat;
import items.Potion;
import items.Wand;
import items.Weapon;
import spells.ForbiddenSpell;
import spells.Spell;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private final Wizard wizard;

    public Game() throws InterruptedException {
        this.wizard = initWizard();
    }

    public void playGame() throws InterruptedException {
        System.out.println("You are ready to begin your journey at Poudlard!");

        Potion water = new Potion("Water",30);
        Spell wl = new Spell("Wingardium Leviosa",50);
        this.wizard.getReward(water,wl);
        Enemy troll = new Enemy("Troll",10,wl);
        level1(troll);

        Potion coca = new Potion("Coca",50);
        Spell accio = new Spell("Accio",60);
        Weapon sword = new Weapon("Gryffindor Sword",100);
        if (wizard.getHouse().getName()=="Gryffindor") {
            wizard.getNewWeapon(sword);
        }
        this.wizard.getReward(coca,accio);
        Enemy basilic = new Enemy("Basilic",15,accio,sword);
        level2(basilic);

        Potion biereAuBeurre = new Potion("Butter beer",60);
        Spell expectoPatronum = new Spell("Expecto Patronum",100);
        this.wizard.getReward(biereAuBeurre,expectoPatronum);
        Enemy dementor = new Enemy("Dementor",20, expectoPatronum);
        level3(dementor);

        Enemy vAndPp = new Enemy("Voldemort & Peter Pettigrow",25, accio);
        level4(vAndPp);

        Enemy dolores = new Enemy("Dolores Ombrage",30,accio);
        level5(dolores);

        Potion wine = new Potion("Wine",45);
        ForbiddenSpell sectumSempra = new ForbiddenSpell("SectumSempra",75);
        this.wizard.getReward(wine,sectumSempra);
        Enemy mangemorts = new Enemy("Mangemorts",75, sectumSempra);
        level6(mangemorts);

        Potion courage = new Potion("Potion de courage",50);
        Spell expelliarmus = new Spell("Expelliarmus",50);
        this.wizard.getReward(courage,expelliarmus);
        Wand wand = new Wand();
        Boss voldemortAndBeatrix = new Boss("Voldemort",100, expelliarmus, wand);
        level7(voldemortAndBeatrix);

        Thread.sleep(Main.timer);
        System.out.println("Congratulations, you have successfully validated your schooling at Poudlard!");
    }

    public static Wizard initWizard() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi young wizard! To start the game, please enter your name :");
        String wizardName = scanner.nextLine();
        Wizard wizard = new Wizard(wizardName);
        System.out.println("Nice to meet you "+wizard.getName()+"!");

        Thread.sleep(Main.timer);

        System.out.println("First, a wand will chose you...");
        Thread.sleep(Main.timer);
        Wand wand = new Wand();
        wizard.setWand(wand);
        System.out.println("Nice! Your wand is made out of "+wand.getWood()+", has a "+wand.getCore()+" and a size of "+wand.getSize()+"cm.");

        Thread.sleep(Main.timer);

        System.out.println("Now please sit down and put on the sorting hat : He will give you a house...");
        Thread.sleep(Main.timer);
        House house = new House(SortingHat.getRandom());
        wizard.setHouse(house);
        System.out.println("You will be a "+house.getName()+"! Congratulations!");
        Thread.sleep(Main.timer);
        wizard.applyAsset(house.getName());

        Thread.sleep(Main.timer);

        wizard.getAPet();
        System.out.println("Finally, let me introduce you your pet : a "+wizard.getPet()+". It will follow you during this journey.");
        Thread.sleep(Main.timer);
        return wizard;
    }

    public void level1(AbstractEnemy enemy) throws InterruptedException {
        System.out.println("You are now entering the 1st year which is named 'The Philosopher's Stone'! Good luck!");
        Thread.sleep(Main.timer);
        System.out.println("Oh, you are facing a Troll in the toilets! Let's fight him!");
        fightWithSpell(wizard,enemy);
        System.out.println("Congratulations! You successfully passed the 1st level by beating the Troll!");
        wizard.lvlUp();
    }

    public void level2(AbstractEnemy enemy) throws InterruptedException {
        System.out.println("You are now entering the 2nd year which is named 'The Chamber of Secrets'! Good luck!");
        Thread.sleep(Main.timer);
        System.out.println("Oh, you are facing Basilic in the Chamber! Let's fight him!");
        if (wizard.getHouse().getName().equals("Gryffindor")) {
            fightWithWeapon(wizard,enemy);
        } else {
            fightWithSpell(wizard,enemy);
        }
        System.out.println("Congratulations! You successfully passed the 2nd level by beating Basilic!");
        this.wizard.lvlUp();
    }

    public void level3(AbstractEnemy enemy) throws InterruptedException {
        System.out.println("You are now entering the 3rd year which is named 'The Prisonner of Azkaban'! Good luck!");
        Thread.sleep(Main.timer);
        System.out.println("Oh, you are facing Dementors in the Forbidden Forest! They are coming and you can't run away.");
        fightWithSpell(wizard,enemy);
        System.out.println("Congratulations! You successfully passed the 3rd level by beating Dementors!");
        this.wizard.lvlUp();
    }

    public void level4(AbstractEnemy enemy) throws InterruptedException {
        System.out.println("You are now entering the 4th year which is named 'The Goblet of Fire'! Good luck!");
        Thread.sleep(Main.timer);
        System.out.println("Oh, you are facing Voldemort and Peter Pettigrow in the Cemetery! Let's fight them!");
        int spellChoice = choiceInList(wizard,"Spells");
        wizard.attackWithSpell(wizard.knownSpells.get(spellChoice),enemy);
        while (!yninput("You should run away, you have not chance to win this fight! Do you wanna run away ?")){
            wizard.defend(wizard,enemy);
            System.out.println("You currently have "+wizard.getHealPoints()+"HP.");
            if (wizard.potions.size()!=0 && yninput("Do you want to drink a potion and get more HP ?") ){
                int potionChoice = choiceInList(wizard,"Potions");
                wizard.drinkPotion(wizard.potions.get(potionChoice),wizard);
            }
        }
        System.out.println("Congratulations! You successfully passed the 5th level by escaping Voldemort and Peter Pettigrow!");
        this.wizard.lvlUp();
    }

    public void level5(AbstractEnemy enemy) throws InterruptedException {
        System.out.println("You are now entering the 5th year which is named 'The order of the Phenix'! Good luck!");
        Thread.sleep(Main.timer);
        System.out.println("Oh, you are facing Dolores Ombrage in the Exams room! Let's fight her!");
        int spellChoice = choiceInList(wizard,"Spells");
        wizard.attackWithSpell(wizard.knownSpells.get(spellChoice),enemy);
        Weapon fireworks = new Weapon("Fireworks",100);
        wizard.getNewWeapon(fireworks);
        System.out.println("I think you should use those fireworks to win the fight");
        enemy.setWeakness2(fireworks);
        fightWithWeapon(wizard,enemy);
        System.out.println("Congratulations! You successfully passed the 5th level by beating Dolores Ombrage!");
        this.wizard.lvlUp();
    }

    public void level6(AbstractEnemy enemy) throws InterruptedException {
        System.out.println("You are now entering the 6th year which is named 'The Half-blood Prince'! Good luck!");
        Thread.sleep(Main.timer);
        System.out.println("Oh, you are facing a group of Mangemorts");
        if (wizard.getHouse().getName().equals("Slytherin")) {
            boolean isYes = yninput("Would you like to let down the good side and join the mangemorts ?");
            if (isYes) {
                System.out.println("You are now a Mangemort, with you and the voldemort powers, the good side didn't have a chance. It's the apocalypse.");
                System.exit(0);
            }
        }
        fightWithSpell(wizard,enemy);
        System.out.println("Congratulations! You successfully passed the 6th level by beating this vicious group of Mangemorts!");
        this.wizard.lvlUp();
    }

    public void level7(Boss boss) throws InterruptedException {
        System.out.println("You are now entering the 7th year which is named 'The Deathly Hallows'! Good luck!");
        Thread.sleep(Main.timer);
        System.out.println("Oh, you are facing Voldemort, the leader of the mangemorts! It's time for the final fight which will determine whether the evil or the good will persist!");
        if (boss.getWand().getCore()==wizard.getWand().getCore()){
            System.out.println("Oh, you have the same core of wand than Voldemort! What is happening ???");
            boss.setHealPoints(1);
            System.out.println("Voldemort has been hit by lightning, he has only 1HP remaining! Don't miss this opportunity to kill him!");
        }
        fightWithSpell(wizard,boss);
        System.out.println("Congratulations! The evil has been defeated and the good has prevailed! You are the winner of the game!");
    }

    public static void fightWithWeapon(Wizard wizard, AbstractEnemy enemy) throws InterruptedException {
        while (enemy.isCharacterAliveWithoutPrint(enemy)){
            wizard.defend(wizard,enemy);
            int weaponChoice = choiceInList(wizard,"Weapons");
            wizard.attackWithWeapon(wizard.weapons.get(weaponChoice),enemy);
            System.out.println("You currently have "+wizard.getHealPoints()+"HP.");
            if (wizard.potions.size()!=0 && yninput("Do you want to drink a potion and get more HP ?") ){
                int potionChoice = choiceInList(wizard,"Potions");
                wizard.drinkPotion(wizard.potions.get(potionChoice),wizard);
            }
        }
    }

    public static void fightWithSpell(Wizard wizard, AbstractEnemy enemy) throws InterruptedException {
        while (enemy.isCharacterAliveWithoutPrint(enemy)){
            wizard.defend(wizard,enemy);
            int spellChoice = choiceInList(wizard,"Spells");
            wizard.attackWithSpell(wizard.knownSpells.get(spellChoice),enemy);
            System.out.println("You currently have "+wizard.getHealPoints()+"HP.");
            if (wizard.potions.size()!=0 && yninput("Do you want to drink a potion and get more HP ?") ){
                int potionChoice = choiceInList(wizard,"Potions");
                wizard.drinkPotion(wizard.potions.get(potionChoice),wizard);
            }
        }
    }

    public static boolean yninput(String question){
        Scanner scanner = new Scanner (System.in);
        System.out.println(question+" Answer by typing yes or no :");
        String decision = scanner.nextLine();
        boolean answer = true;
        switch(decision) {
            case "yes":
                answer = true;
                break;

            case "no":
                answer = false;
                break;

            default:
                boolean repeat = true;
                while (repeat) {
                    System.out.println("Error, please enter again (yes or no) :");
                    decision = scanner.nextLine();
                    switch (decision) {
                        case "yes":
                            answer = true;
                            repeat = false;
                            break;

                        case "no":
                            answer = false;
                            repeat = false;
                            break;
                        default:
                            repeat = true;
                    }
                }
                break;
        }
        return answer;
    }

    public static int choiceInList(Wizard wizard,String type){
        Scanner scanner = new Scanner(System.in);
        switch (type){
            case ("Spells"):
                System.out.println("You currently know "+wizard.knownSpells.size()+ " spell(s) : "+ Arrays.toString(wizard.knownSpells.stream().map((spell) -> spell.name).toArray())+". Which one do you want to use (indicate it by its index :0,1,2...)?");
                break;
            case ("Potions"):
                System.out.println("You currently have "+wizard.potions.size()+ " potion(s) : "+ Arrays.toString(wizard.potions.stream().map((potion) -> potion.name).toArray())+" in your inventory. Which one do you want to drink (indicate it by its index :0,1,2...)?");
                break;
            case ("Weapons"):
                System.out.println("You currently have "+wizard.weapons.size()+ " weapon(s) : "+ Arrays.toString(wizard.weapons.stream().map((weapon) -> weapon.name).toArray())+". Which one do you want to use (indicate it by its index :0,1,2...)?");
                break;
        }
        int choice = scanner.nextInt();
        if (type.equals("Spells") && choice<wizard.knownSpells.size() || type.equals("Potions") && choice<wizard.potions.size() || type.equals("Weapons") && choice<wizard.weapons.size()) {
            return choice;
        } else {
            while (type.equals("Spells") && choice>=wizard.knownSpells.size() || type.equals("Potions") && choice>=wizard.potions.size() || type.equals("Weapons") && choice>=wizard.weapons.size()) {
                System.out.println("Error, please enter again (the int value needs to be smaller than the list length) :");
                choice = scanner.nextInt();
            }
            return choice;
        }
    }
}
