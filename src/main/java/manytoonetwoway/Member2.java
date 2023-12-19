package manytoonetwoway;

import javax.persistence.*;

@Entity
@Table(name = "many_to_one_twoway_member")
public class Member2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "Team_id")
    private Team2 team;


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

    public Team2 getTeam() {
        return team;
    }

    // 연관 관계 편의 메소드
    public void setTeam(Team2 team) {
        // 조건문을 걸어줘야하는 이유 확인(Main 클래스)
        if(this.team != null) {
            this.team.getMemberList().remove(this);
        }

        this.team = team;
        // 양방향에서 Member 테이블에는 추가했는데 Team 테이블에 추가하는것을 까먹거나 할 수 있기때문에
        // Member 테이블에 팀을 추가할때 해당 팀에 멤버까지 한번에 추가해주는 것이 나중에 누락되지 않는 방법이다.
        team.getMemberList().add(this);
    }
}
