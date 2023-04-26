package characters;

public abstract class Character {
    protected String name;
    protected double healPoints = 100;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(double healPoints) {
        this.healPoints = healPoints;
    }

    public boolean isCharacterAlive(Character character){
        if (character.getHealPoints()>0) {
            System.out.println(character.getName()+" is alive with "+character.getHealPoints()+" HP!");
            return true;
        } else {
            System.out.println(character.getName()+" is dead!");
            return false;
        }
    }

    public boolean isCharacterAliveWithoutPrint(Character character){
        if (character.getHealPoints()>0) {
            return true;
        } else {
            return false;
        }
    }
}
