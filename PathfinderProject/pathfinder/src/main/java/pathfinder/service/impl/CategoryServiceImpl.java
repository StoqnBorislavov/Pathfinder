package pathfinder.service.impl;

import org.springframework.stereotype.Service;
import pathfinder.model.entity.Category;
import pathfinder.model.entity.enums.CategoryNameEnum;
import pathfinder.repository.CategoryRepository;
import pathfinder.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category findCategoryByName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
