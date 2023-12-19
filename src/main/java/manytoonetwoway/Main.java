package manytoonetwoway;

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
        Team2 team1 = new Team2();
        team1.setName("1팀");
        em.persist(team1);

        Team2 team2 = new Team2();
        team1.setName("2팀");
        em.persist(team2);

        Member2 member1 = new Member2();
        member1.setUsername("1유저");
        member1.setTeam(team1);
        // 커밋하기 전에 커밋할 내용을 바꿀 때 문제가 발생할 수 있다.
        // 1유저의 팀이 1팀에서 1유저의 팀을 2팀으로 다시 설정하면 1유저, 1팀인 데이터가 그대로 남아있는 상태에서 1유저, 2팀 데이터가 추가되기 때문
        // 따라서 추가할때 조건문을 걸어준다.(Member2 클래스 확인)
        member1.setTeam(team2);
        em.persist(member1);

        Member2 member2 = new Member2();
        member2.setUsername("2유저");
        member2.setTeam(team1);
        em.persist(member2);


        // 기존 코드 삭제
//        team1.getMemberList().add(member1);
//        team1.getMemberList().add(member2);

        tx.commit();

    }
}
