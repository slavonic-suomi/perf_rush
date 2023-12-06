package pl.jbazil.javabase.classis.orm.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
@Table(name = "product", uniqueConstraints = {
        @UniqueConstraint(name = "uc_product_name", columnNames = {"name"}),
        @UniqueConstraint(name = "uc_product_code", columnNames = {"code"})
})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String code; //UUID

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal rating;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;
}
