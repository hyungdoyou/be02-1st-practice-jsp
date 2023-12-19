package practice01;

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

//        for (int i = 0; i < 5; i++) {
//            Grade grade = new Grade();
//            grade.setGrade("등급"+(i+1));
//            for (int j = 1; j <= 10; j++) {
//                User user = new User();
//                user.setName("회원"+(i*10+j));
//                user.setPw("비밀번호" + (i*10+j));
//                user.setGrade(grade);
//                em.persist(user);
//
//                for (int k=1; k<=3; k++) {
//                    Order order = new Order();
//                    order.setProductName("상품" + (i*10+k));
//                    em.persist(order);
//                    user.getOrderList().add(order);
//                }
//            }
//            em.persist(grade);
//        }

        User user1 = em.find(User.class, 30);
        System.out.println("회원명 : " + user1.getName());
        System.out.println("비밀번호 : " + user1.getPw());
        System.out.println("등급 : " + user1.getGrade().getGrade());

        User user2 = em.find(User.class, 2);
        System.out.println("회원명 : " + user2.getName());
        System.out.println("비밀번호 : " + user2.getPw());
        System.out.println("등급 : " + user2.getGrade().getGrade());

        System.out.print("주문목록 : ");
        for(Order order : user2.getOrderList()) {
            System.out.print(order.getProductName() + " ");
        }

        tx.commit();
    }
}
