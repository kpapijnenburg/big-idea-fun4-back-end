package fitnessapp.model;

import java.util.List;

public class Exercise {

    private long id;
    private String name;
    private List<Category> categories;

    public Exercise() {

    }

    public Exercise(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Exercise(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
