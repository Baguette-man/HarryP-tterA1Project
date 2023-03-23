public abstract class Character {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attack(Character character) {
        System.out.println("I'm attacking xxxxxx");
    }
}
