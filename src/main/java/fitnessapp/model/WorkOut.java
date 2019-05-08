package fitnessapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class WorkOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private String name;
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Set> sets;

    public WorkOut() {

    }

    public WorkOut(long id, long userId, String name, Date date, List<Set> sets) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.date = date;
        this.sets = sets;
    }

    public WorkOut(long userId, String name, Date date, List<Set> sets) {
        this.userId = userId;
        this.name = name;
        this.date = date;
        this.sets = sets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }
}
