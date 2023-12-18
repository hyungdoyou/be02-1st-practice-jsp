import model.Category;
import model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateMain {
    public static void main(String[] args) {

        // 이것을 실행될때 DB랑 연결이 시작됨
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        // Insert
//        tx.begin();
//        Product product = new Product();
//        product.setName("test01");
//        em.persist(product);   // 여기서 SQL 쿼리가 생성되고
//        tx.commit();           // 여기서 SQL 쿼리가 실행되며, DB에 적용된다. 즉, 이전까지 여러개의 SQL 쿼리문을 생성한뒤 커밋해주는 시점에 생성한 모든 SQL이 적용된다.
//

        // 관계 형성 후
        // 상품에 카테고리 id 까지 포함해서 한번에 넣어주고 싶을떄
//        tx.begin();
//        for(int i=0; i<10; i++) {
//            Category category = new Category();
//            category.setType("카테고리"+(i+1));
//            for (int j=1; j<=10; j++) {
//                Product product = new Product();
//                product.setName("상품"+(i*10 + j));
//                product.setCategory(category);
//                em.persist(product);
//            }
//            em.persist(category);
//        }
//        tx.commit();


        // 상품의 id가 1인 카테고리의 타입을 출력
        //Product product = em.find(Product.class, 1);
        //System.out.println(product.getCategory().getType());

        // 카테고리 id가 1인 상품의 목록을 출력
        Category category = em.find(Category.class, 1);

        for (Product product1 : category.getProductList()) {
            System.out.println(category.getType() + " " + product1.getName());
        }


        // Select
//        tx.begin();
//        Product product = em.find(Product.class, 1);
//        tx.commit();
//        System.out.println(product.getId());
//        System.out.println(product.getName());

        // Update
        tx.begin();
        Product product = em.find(Product.class, 3);
        product.setName("test04");
        tx.commit();
        System.out.println("test03");

        // Delete
//        tx.begin();
//        Product product = em.find(Product.class,2);
//        em.remove(product);
//        tx.commit();

    }
}
