package pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pathfinder.model.binding.UserRegisterBindingModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {


    //When we redirect for the first time we will use brand new Binding model.
    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/register")
    public String register(Model model) {
//        if(!model.containsAttribute("userRegisterBindingModel")){
//            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
//        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        //Binding result object for hibernate validator to store the faults, it's need to be injected after Valid annotation object
        //Redirect attributes with flash attributes for redirecting and save the attributes
        if (bindingResult.hasErrors()) {
            redirectAttributes.
                    addFlashAttribute("userRegisterBindingModel",
                            userRegisterBindingModel);
            redirectAttributes.
                    addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);

            return "redirect:register";

        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
