package fitnessapp.model;

import java.util.List;

public class Set {

    private long id;
    private List<Exercise> exercises;
    private float weight;
    private int reps;

    public Set() {
    }

    public Set(long id, List<Exercise> exercises, float weight, int reps) {
        this.id = id;
        this.exercises = exercises;
        this.weight = weight;
        this.reps = reps;
    }

    public Set(List<Exercise> exercises, float weight, int reps) {
        this.exercises = exercises;
        this.weight = weight;
        this.reps = reps;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
