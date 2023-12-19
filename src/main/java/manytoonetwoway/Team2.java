package manytoonetwoway;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "many_to_one_twoway_team")
public class Team2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member2> memberList = new ArrayList<>();

    public List<Member2> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member2> memberList) {
        this.memberList = memberList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}