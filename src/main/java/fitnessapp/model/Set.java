package fitnessapp.model;

public class Set {

    private long id;
    private long workOutId;
    private float weight;
    private int reps;

    public Set() {
    }

    public Set(long workOutId, float weight, int reps) {
        this.workOutId = workOutId;
        this.weight = weight;
        this.reps = reps;
    }

    public Set(long id, long workOutId, float weight, int reps) {
        this.id = id;
        this.workOutId = workOutId;
        this.weight = weight;
        this.reps = reps;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWorkOutId() {
        return workOutId;
    }

    public void setWorkOutId(long workOutId) {
        this.workOutId = workOutId;
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
