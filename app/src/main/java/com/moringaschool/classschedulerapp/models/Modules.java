package com.moringaschool.classschedulerapp.models;

import java.util.Objects;

public class Modules {
    private int id;
    private String name;

    public Modules(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modules modules = (Modules) o;
        return id == modules.id && name.equals(modules.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
