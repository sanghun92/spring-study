package chapter6.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;
    private String street;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    protected Delivery() {

    }
    public Delivery(Order order, String city, String street, String zipcode) {
        this.order = order;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.status = DeliveryStatus.READY;
    }
}
