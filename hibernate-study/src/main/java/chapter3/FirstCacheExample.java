package chapter3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FirstCacheExample {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            // 1. 엔티티를 생성한 상태(비영속)
            Member member = new Member(1L, "홍길동");
            // 2.엔티티 영속
            em.persist(member);
            tx.commit();

            // 3. 엔티티 조회
            Member findMember = em.find(Member.class, 1L);
            // 4. 다른 엔티티 매니저로 엔티티 조회
            Member findMemberByOtherManager = em2.find(Member.class, 1L);
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
            em2.close();
        }
        emf.close();
    }
}
