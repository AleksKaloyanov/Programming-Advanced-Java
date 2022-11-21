package DefiningClassesEx.Google;

public class Pokemon {
    private String name;
    private String element;

    public Pokemon(String name, String element) {
        this.name = name;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getName(), this.getElement());
    }
}
