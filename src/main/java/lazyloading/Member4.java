package lazyloading;

import javax.persistence.*;

@Entity
@Table(name="lazy_loading_member")
public class Member4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "Team_id")
    private Team4 team;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team4 getTeam() {
        return team;
    }

    public void setTeam(Team4 team) {
        this.team = team;
    }
}
