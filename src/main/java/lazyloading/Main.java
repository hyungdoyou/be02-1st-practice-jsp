package lazyloading;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "hibernateproject");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();


        Member4 member4 = em.find(Member4.class, 1);
        System.out.println(member4.getId());
        System.out.println(member4.getUsername());
        System.out.println(member4.getTeam().getName());




//        for (int i = 0; i < 10; i++) {
//            Team4 team4 = new Team4();
//            team4.setName("팀"+(i+1));
//            for (int j = 1; j <= 10; j++) {
//                Member4 member4 = new Member4();
//                member4.setUsername("사람"+(i*10+j));
//                member4.setTeam(team4);
//                em.persist(member4);
//            }
//            em.persist(team4);
//        }

        tx.commit();

    }
}
