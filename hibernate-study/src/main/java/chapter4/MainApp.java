package chapter4;

import chapter4.domain.Member;
import chapter4.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApp {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Member member = new Member("손상훈", "서울특별시", "강남로", "714116");
            em.persist(member);

            Order order = new Order(member.getId());
            em.persist(order);
            tx.commit();

            // -----------------
            tx.begin();
            Order findOrder = em.find(Order.class, order.getId());
            Member findMember = em.find(Member.class, findOrder.getMemberId());
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
