package chapter3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LazyWritingExample {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // 1. 엔티티 생성 (비영속 상태)
            Member member = new Member(1L, "홍길동");
            Member member2 = new Member(2L, "홍길동");

            // 2. 트랜잭션 시작
            tx.begin();

            // 3. 엔티티 영속화
            em.persist(member);
            em.persist(member2);

            // 4. 트랜잭션 커밋
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
