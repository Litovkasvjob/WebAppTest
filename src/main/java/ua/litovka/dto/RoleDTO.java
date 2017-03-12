package ua.litovka.dto;

import ua.litovka.model.Entity;

/**
 * Created by SergLion on 24.02.2017.
 */
public class RoleDTO extends Entity<Integer> {
    private String name;

    public RoleDTO() {
    }

    public RoleDTO(String name) {
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
        return "RoleDTO{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
