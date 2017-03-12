package ua.litovka.model;

/**
 * Created by SergLion on 24.02.2017.
 */
public class Role extends Entity<Integer> {
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
