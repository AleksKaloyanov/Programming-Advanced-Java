package DefiningClassesEx.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private Car car;
    private List<Child> children;
    private List<Parent> parents;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void addParents(Parent parent) {
        this.parents.add(parent);
    }

}
