package pl.jbazil.javabase.classis.orm.persistence.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.jbazil.javabase.classis.orm.persistence.entity.ProductEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByCategoryIdOrderByRatingDesc(Long categoryId, Pageable pageable);
}
