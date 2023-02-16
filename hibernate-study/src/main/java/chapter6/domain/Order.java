package chapter6.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "BINARY(16)", foreignKey = @ForeignKey(name = "fk_orders_member"))
    private Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(columnDefinition = "BINARY(16)", foreignKey = @ForeignKey(name = "fk_orders_delivery"))
    private Delivery delivery;

    protected Order() {}

    public Order(Member member) {
        this.member = member;
        this.orderDate = LocalDateTime.now();
        this.orderStatus = OrderStatus.ORDER;
    }

    public UUID getId() {
        return this.id;
    }

    public void changeMember(Member member) {
        if(this.member != null) {
            this.member.getOrders().remove(this);
        }

        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem item) {
        this.orderItems.add(item);
        item.setOrder(this);
    }

    public Member getMember() {
        return this.member;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }


    public void startDelivery(String city, String street, String zipcode) {
        this.delivery = new Delivery(this, city, street, zipcode);
    }

    public Delivery getDelivery() {
        return this.delivery;
    }
}
