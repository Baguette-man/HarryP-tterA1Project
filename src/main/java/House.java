import java.util.Arrays;
import java.util.List;

public class House {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    List<String> housesNamesList = Arrays.asList("Hufflepuff","Slytherin","Gryffindor","Ravenclaw");
    public House(int randInt){
        this.name = housesNamesList.get(randInt);
    }
}
