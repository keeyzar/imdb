package de.keeyzar.checkimdb.imdbclone.view;

import de.keeyzar.checkimdb.imdbclone.errors.UserAlreadyExistsException;
import de.keeyzar.checkimdb.imdbclone.model.UserDTO;
import de.keeyzar.checkimdb.imdbclone.services.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

//todo das hier funktioniert nicht so wie gewünscht.
@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRegisterService userRegisterService;

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/registration")
    public String userRegistration(final UserDTO userDTO, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userDTO);
            return "/registration";
        }
        try {
            userRegisterService.register(userDTO);
        }catch (UserAlreadyExistsException e){
            bindingResult.rejectValue("username", "userDTO.username","An account already exists for this name.");
            model.addAttribute("registrationForm", userDTO);
            return "/registration";
        }
        return "redirect:/login";
    }
}
