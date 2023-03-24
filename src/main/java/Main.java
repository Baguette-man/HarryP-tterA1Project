import characters.Wizard;
import environment.House;
import environment.SortingHat;
import items.Wand;
import java.util.Scanner;
public class Main {

    /////////////////////// GAME PARTS //////////////////////////////////////

    public static void initWizard() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi young wizard! To start the game, please enter your name :");
        String wizardName = scanner.nextLine();
        Wizard wizard = new Wizard(wizardName);
        System.out.println("Nice to meet you " + wizard.getName() + "!");

        Thread.sleep(3000);

        System.out.println("First, a wand will chose you...");
        Thread.sleep(3000);
        Wand wand = new Wand();
        wizard.setWand(wand);
        System.out.println("Nice! Your wand is made out of " + wand.getWood() + ", has a " + wand.getCore() + " and a size of " + wand.getSize() + "cm.");

        Thread.sleep(3000);

        System.out.println("Now please sit down and put on the sorting hat : He will give you a environment.House...");
        Thread.sleep(3000);
        House house = new House(SortingHat.getRandom());
        wizard.setHouse(house);
        System.out.println("You will be a " + house.getName() + "! Congratulations!");
    }


    /////////////////////// RUN GAME ////////////////////////////////////////


    public static void main(String[] args) throws InterruptedException {
        initWizard();
    }





}