package fitnessapp.model;

import javax.persistence.*;

@Entity
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Exercise exercise;

    private float weight;
    private int reps;

    public Set() {

    }

    public Set(long id, Exercise exercise, float weight, int reps) {
        this.id = id;
        this.exercise = exercise;
        this.weight = weight;
        this.reps = reps;
    }

    public Set(Exercise exercise, float weight, int reps) {
        this.exercise = exercise;
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

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
