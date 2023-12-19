package manytooneoneway;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "hibernateproject");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Team1 team1 = new Team1();
        team1.setName("1팀");
        em.persist(team1);

        Member1 member1 = new Member1();
        member1.setUsername("1유저");
        member1.setTeam(team1);
        em.persist(member1);

        Member1 member2 = new Member1();
        member2.setUsername("2유저");
        member2.setTeam(team1);
        em.persist(member2);

        tx.commit();
    }
}
