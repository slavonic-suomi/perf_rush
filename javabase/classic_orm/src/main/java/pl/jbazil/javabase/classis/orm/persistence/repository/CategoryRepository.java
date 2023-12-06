package pl.jbazil.javabase.classis.orm.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jbazil.javabase.classis.orm.persistence.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
