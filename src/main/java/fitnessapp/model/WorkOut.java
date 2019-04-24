package fitnessapp.model;

import java.util.Date;

public class WorkOut {

    private long id;
    private long userId;
    private String name;
    private Date date;

    public WorkOut() {
    }

    public WorkOut(long userId, String name, Date date) {
        this.userId = userId;
        this.name = name;
        this.date = date;
    }

    public WorkOut(long id, long userId, String name, Date date) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.date = date;
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
}
