package fitnessapp.model;

import javax.persistence.*;
import java.util.List;

//todo add workouts

@Entity
@Table()
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String password;

//    @ManyToOne
//    private List<WorkOut> workOuts;

    public User() {

    }

    public User(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, List<WorkOut> workOuts) {
        this.name = name;
        this.email = email;
        this.password = password;
//        this.workOuts = workOuts;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<WorkOut> getWorkOuts() {
//        return workOuts;
//    }
//
//    public void setWorkOuts(List<WorkOut> workOuts) {
//        this.workOuts = workOuts;
//    }
}
