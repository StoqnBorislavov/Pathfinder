package pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pathfinder.model.entity.Category;
import pathfinder.model.entity.enums.CategoryNameEnum;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryNameEnum categoryNameEnum);
}
