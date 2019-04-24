package fitnessapp.model;

public class Set {

    private long id;
    private WorkOut workOut;
    private float weight;
    private int reps;

    public Set() {
    }

    public Set(WorkOut workOut, float weight, int reps) {
        this.workOut = workOut;
        this.weight = weight;
        this.reps = reps;
    }

    public Set(long id, WorkOut workOut, float weight, int reps) {
        this.id = id;
        this.workOut = workOut;
        this.weight = weight;
        this.reps = reps;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WorkOut getWorkOut() {
        return workOut;
    }

    public void setWorkOut(WorkOut workOut) {
        this.workOut = workOut;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
