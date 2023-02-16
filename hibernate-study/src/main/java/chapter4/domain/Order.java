package chapter4.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(columnDefinition = "BINARY(16)")
    private UUID memberId;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    protected Order() {}

    public Order(UUID memberId) {
        this.memberId = memberId;
        this.orderDate = LocalDateTime.now();
        this.orderStatus = OrderStatus.ORDER;
    }

    public UUID getId() {
        return this.id;
    }

    public UUID getMemberId() {
        return this.memberId;
    }
}
