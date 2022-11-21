package DefiningClassesEx.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String date;
    private List<Child> children;
    private List<Parent> parents;

    public Person(String name, String date) {
        this.name = name;
        this.date = date;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }


}
