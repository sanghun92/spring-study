package chapter3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityEqualityExample {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Member member = new Member(1L, "홍길동");
            em.persist(member);
            tx.commit();

            // 1. 식별자가 같은 엔티티 조회
            Member findMember = em.find(Member.class, 1L);
            Member findMember2 = em.find(Member.class, 1L);

            // 2. 동일성 비교
            System.out.println(findMember == findMember2);
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
