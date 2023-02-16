package chapter5;

import chapter5.domain.Item;
import chapter5.domain.Member;
import chapter5.domain.Order;
import chapter5.domain.OrderItem;

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

            Item 공책 = new Item("공책", 1400L, 5);
            em.persist(공책);

            Order order = new Order(member);
            order.addOrderItem(new OrderItem(공책, 1400L, 1));
            em.persist(order);
            tx.commit();

            // -----------------
            tx.begin();
            Order findOrder = em.find(Order.class, order.getId());
            Member findMember = findOrder.getMember();
            List<OrderItem> orderItems = findOrder.getOrderItems();
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
