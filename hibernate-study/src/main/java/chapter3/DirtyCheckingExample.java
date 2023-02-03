package chapter3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DirtyCheckingExample {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Member member = new Member(1L, "홍길동");
            em.persist(member);
            tx.commit();

            tx.begin();
            // 1. 엔티티 조회
            Member findMember = em.find(Member.class, 1L);
            // 2. 영속 엔티티 수정
            findMember.changeUserName("둘리");
            // 3. 트랜잭션 커밋
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
