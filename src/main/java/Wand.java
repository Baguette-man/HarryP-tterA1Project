import java.util.Random;

public class Wand {
    public Core core;
    public Wood wood;
    public int size;

    public Wand(){
        Random rand = new Random();
        int randIntCore = rand.nextInt(3);
        int randIntWood = rand.nextInt(38);
        this.size = rand.nextInt(10,50);
        this.core = Core.values()[randIntCore];
        this.wood = Wood.values()[randIntWood];
    }

    public Core getCore() {
        return core;
    }

    public Wood getWood() {
        return wood;
    }

    public int getSize() {
        return size;
    }
}
