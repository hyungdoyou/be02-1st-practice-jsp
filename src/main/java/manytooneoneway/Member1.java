package manytooneoneway;

import javax.persistence.*;

@Entity
@Table(name = "many_to_one_oneway_member")
public class Member1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "Team_id")
    private Team1 team;


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

    public Team1 getTeam() {
        return team;
    }

    public void setTeam(Team1 team) {
        this.team = team;
    }
}
