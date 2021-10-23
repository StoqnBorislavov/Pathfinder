package pathfinder.service;

import pathfinder.model.entity.Category;
import pathfinder.model.entity.enums.CategoryNameEnum;

import java.util.Optional;

public interface CategoryService {

    Category findCategoryByName(CategoryNameEnum categoryNameEnum);
}
