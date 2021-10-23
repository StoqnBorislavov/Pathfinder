package pathfinder.service;

import pathfinder.model.service.RouteDetailsViewModel;
import pathfinder.model.service.RouteSerivceModel;
import pathfinder.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();

    void addNewRoute(RouteSerivceModel routeSerivceModel);

    RouteDetailsViewModel findRoutById(Long id);
}

