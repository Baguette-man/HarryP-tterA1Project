package items;

import java.util.Random;

public class Wand {
    public Core core;
    public Wood wood;
    public int size;

    public Wand(){
        Random rand = new Random();
        int randIntCore = rand.nextInt(Core.values().length);
        int randIntWood = rand.nextInt(Wood.values().length);
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
