package environment;
import java.util.Random;

public class SortingHat {
    public static int getRandom(){
        Random rand = new Random();
        int randInt = rand.nextInt(4);
        return randInt;
    }
}
