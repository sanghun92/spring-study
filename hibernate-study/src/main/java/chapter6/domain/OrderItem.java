package chapter6.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "BINARY(16)", foreignKey = @ForeignKey(name = "fk_order_item_order"))
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "BINARY(16)", foreignKey = @ForeignKey(name = "fk_order_item_item"))
    private Item item;
    private Long price;
    private Integer count;

    protected OrderItem() {}

    public OrderItem(Item item, Long price, Integer count) {
        this.item = item;
        this.price = price;
        this.count = count;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
