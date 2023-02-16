package chapter6.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Category {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "BINARY(16)", foreignKey = @ForeignKey(name = "fk_category_parent"))
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
    private List<Category> child = new ArrayList<>();

    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(
                    name = "category_id",
                    columnDefinition = "BINARY(16)",
                    foreignKey = @ForeignKey(name = "fk_category_item_category")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "item_id",
                    columnDefinition = "BINARY(16)",
                    foreignKey = @ForeignKey(name = "fk_category_item_item")
            )
    )
    private List<Item> items = new ArrayList<>();

    protected Category() {}

    public Category(String name) {
        this.name = name;
    }

    private Category(Category parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public void addChildCategory(String name) {
        Category child = new Category(this, name);
        this.child.add(child);
    }
}
