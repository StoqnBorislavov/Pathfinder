package pathfinder.web;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pathfinder.model.binding.RouteAddBindingModel;
import pathfinder.model.service.RouteSerivceModel;
import pathfinder.model.view.RouteViewModel;
import pathfinder.service.RouteService;
import pathfinder.util.CurrentUser;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/all")
    private String allRoutes(Model model){
        List<RouteViewModel> routeViewModels = routeService.findAllRoutesView();
        model.addAttribute("routes", routeViewModels);
        return "routes";
    }

    @GetMapping("/add")
    public String add(){
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        return "add-route";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid RouteAddBindingModel routeAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws IOException {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("routeAddBindingModel", routeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel",
                    bindingResult);

            return "redirect:add";
        }
        RouteSerivceModel routeSerivceModel = modelMapper.map(routeAddBindingModel, RouteSerivceModel.class);
        routeSerivceModel.setGpxCoordinates(new String(routeAddBindingModel.getGpxCoordinates().getBytes()));
        routeService.addNewRoute(routeSerivceModel);

        return "redirect:all";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
        model.addAttribute("route", routeService.findRoutById(id));



        return "route-details";
    }




    @ModelAttribute
    public RouteAddBindingModel routeAddBindingModel(){
        return new RouteAddBindingModel();
    }


}
