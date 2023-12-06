package pl.jbazil.javabase.classis.orm.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "category", uniqueConstraints = {
        @UniqueConstraint(name = "uc_category_name", columnNames = {"name"})
})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ProductEntity> products;
}
