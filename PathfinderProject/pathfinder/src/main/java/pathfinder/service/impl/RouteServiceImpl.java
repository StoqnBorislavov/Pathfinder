package pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pathfinder.model.entity.Route;
import pathfinder.model.service.RouteDetailsViewModel;
import pathfinder.model.service.RouteSerivceModel;
import pathfinder.model.view.RouteViewModel;
import pathfinder.repository.RouteRepository;
import pathfinder.service.CategoryService;
import pathfinder.service.RouteService;
import pathfinder.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public List<RouteViewModel> findAllRoutesView() {
        return routeRepository.
                findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel = modelMapper.map(route, RouteViewModel.class);
                    if (route.getPictures().isEmpty()) {
                        routeViewModel.setPictureUrl("/images/pic4.jpg");
                    } else {
                        routeViewModel.setPictureUrl(route.getPictures().stream().findFirst().get().getUrl());
                    }
                    return routeViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public void addNewRoute(RouteSerivceModel routeSerivceModel) {
        Route route = modelMapper.map(routeSerivceModel, Route.class);
        route.setAuthor(userService.findCurrentLoginUserEntity());
        route.setCategories(routeSerivceModel
                .getCategories()
                .stream()
                .map(categoryNameEnum -> categoryService.findCategoryByName(categoryNameEnum))
                .collect(Collectors.toSet()));


        routeRepository.save(route);
    }

    @Override
    public RouteDetailsViewModel findRoutById(Long id) {
        return routeRepository
                .findById(id)
                .map(route -> modelMapper.map(route, RouteDetailsViewModel.class))
                .orElse(null);
    }
}
