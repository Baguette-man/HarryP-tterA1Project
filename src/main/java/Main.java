import characters.AbstractEnemy;
import characters.Enemy;
import characters.Wizard;
import environment.House;
import environment.SortingHat;
import items.Potion;
import items.Wand;
import spells.Spell;

import java.util.Arrays;
import java.util.Scanner;
public class Main {

    /////////////////////// GAME PARTS //////////////////////////////////////

    public static Wizard initWizard() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi young wizard! To start the game, please enter your name :");
        String wizardName = scanner.nextLine();
        Wizard wizard = new Wizard(wizardName);
        System.out.println("Nice to meet you "+wizard.getName()+"!");

        Thread.sleep(3000);

        System.out.println("First, a wand will chose you...");
        Thread.sleep(3000);
        Wand wand = new Wand();
        wizard.setWand(wand);
        System.out.println("Nice! Your wand is made out of "+wand.getWood()+", has a "+wand.getCore()+" and a size of "+wand.getSize()+"cm.");

        Thread.sleep(3000);

        System.out.println("Now please sit down and put on the sorting hat : He will give you a house...");
        Thread.sleep(3000);
        House house = new House(SortingHat.getRandom());
        wizard.setHouse(house);
        System.out.println("You will be a "+house.getName()+"! Congratulations!");
        Thread.sleep(3000);
        wizard.applyAsset(house.getName());

        Thread.sleep(3000);

        wizard.getAPet();
        System.out.println("Finally, let me introduce you your pet : a "+wizard.getPet()+". It will follow you during this journey.");
        Thread.sleep(3000);
        return wizard;
    }

    public static void level1(Wizard wizard, AbstractEnemy enemy) throws InterruptedException {
        System.out.println("You are now entering the 1st year which is named 'The Philosopher's Stone'! Good luck!");
        Thread.sleep(3000);
        System.out.println("Oh, you are facing a Troll! Let's fight him!");
        while (enemy.isCharacterAlive(enemy)){
            wizard.defend(wizard,enemy);
            Scanner scanner = new Scanner(System.in);
            System.out.println("You currently know "+wizard.knownSpells.size()+ " spell(s) : "+ Arrays.toString(wizard.knownSpells.toArray())+". Which one do you want to use (indicate it by its index :0,1,2...)?");
            int choice = scanner.nextInt();
            wizard.attackWithSpell(wizard.knownSpells.get(choice),enemy);
            System.out.println("You currently have "+wizard.getHealPoints()+"HP.");
            if (yninput("Do you want to drink a potion and get more HP ?")){
                System.out.println("You currently have "+wizard.potions.size()+ " potion(s) : "+ Arrays.toString(wizard.potions.toArray())+" in your inventory. Which one do you want to drink (indicate it by its index :0,1,2...)?");
            }
        }
        System.out.println("Congratulations! You successfully passed the 1st level by beating the Troll!");
    }

    public static void level2(Wizard wizard){
        System.out.println("You are now entering the 2nd year which is named 'The Chamber of Secrets'! Good luck!");
        //TODO The chamber of secrets
    }

    public static void level3(Wizard wizard){
        System.out.println("You are now entering the 3rd year which is named 'The Prisonner of Azkaban'! Good luck!");
        //TODO The prisonner of Azkaban
    }

    public static void level4(Wizard wizard){
        System.out.println("You are now entering the 4th year which is named 'The Goblet of Fire'! Good luck!");
        //TODO The goblet of fire
    }

    public static void level5(Wizard wizard){
        System.out.println("You are now entering the 5th year which is named 'The order of the Phenix'! Good luck!");
        //TODO The order of the Phenix
    }

    public static void level6(Wizard wizard){
        System.out.println("You are now entering the 6th year which is named 'The Half-blood Prince'! Good luck!");
        //TODO The half-blood prince
    }

    public static void level7(Wizard wizard){
        System.out.println("You are now entering the 7th year which is named 'The Deathly Hallows'! Good luck!");
        //TODO The deathly hallows
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




    /////////////////////// RUN GAME ////////////////////////////////////////


    public static void main(String[] args) throws InterruptedException {
        Wizard wizard = initWizard();
        System.out.println("You are ready to begin your journey at Poudlard!");
        Potion water = new Potion("Water",30);
        Spell wl = new Spell("Wingardium Leviosa",50);
        wizard.getReward(water,wl);
        Enemy troll = new Enemy("Troll",10,wl);
        level1(wizard,troll);
        level2(wizard);
        level3(wizard);
        level4(wizard);
        level5(wizard);
        level6(wizard);
        level7(wizard);
        System.out.println("Congratulations, you have successfully validated your schooling at Poudlard!");
    }



}