package fitnessapp.model;

public class Exercise {

    private long id;
    private Set set;
    private String name;

    public Exercise() {

    }

    public Exercise(long id, Set set, String name) {
        this.id = id;
        this.set = set;
        this.name = name;
    }

    public Exercise(Set set, String name) {
        this.set = set;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
