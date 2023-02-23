package chapter6;

import chapter6.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Member member = new Member("손상훈", "서울특별시", "강남로", "714116");
            em.persist(member);

            Category 문구류 = new Category("문구류");
            문구류.addChildCategory("필기도구");
            em.persist(문구류);

            Item 공책 = new Item("공책", 1400L, 5);
            em.persist(공책);

            Order order = new Order(member);
            order.addOrderItem(new OrderItem(공책, 1400L, 1));
            order.startDelivery("서울특별시", "강남로", "714116");
            em.persist(order);

            tx.commit();

            // -----------------
            tx.begin();
            Order findOrder = em.find(Order.class, order.getId());
            Member findMember = findOrder.getMember();
            Delivery findDelivery = findOrder.getDelivery();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
