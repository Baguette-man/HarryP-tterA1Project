import characters.Wizard;
import environment.House;
import environment.SortingHat;
import items.Wand;
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

    public static void level1(Wizard wizard){
        //TODO The philosopher's stone
    }

    public static void level2(Wizard wizard){
        //TODO The chamber of secrets
    }

    public static void level3(Wizard wizard){
        //TODO The prisonner of Azkaban
    }

    public static void level4(Wizard wizard){
        //TODO The goblet of fire
    }

    public static void level5(Wizard wizard){
        //TODO The order of the Phenix
    }

    public static void level6(Wizard wizard){
        //TODO The half-blood prince
    }

    public static void level7(Wizard wizard){
        //TODO The deathly hallows
    }




    /////////////////////// RUN GAME ////////////////////////////////////////


    public static void main(String[] args) throws InterruptedException {
        Wizard wizard = initWizard();
        System.out.println("You are ready to begin your journey at Poudlard!");
        level1(wizard);
        level2(wizard);
        level3(wizard);
        level4(wizard);
        level5(wizard);
        level6(wizard);
        level7(wizard);
        System.out.println("Congratulations, you have successfully validated your scolarity at Poudlard!");
    }



}