package ru.mirea.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.dto.SignUpRequest;
import ru.mirea.exceptions.UserAlreadyExistsException;
import ru.mirea.services.UserService;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/sign-up")
@RequiredArgsConstructor
public class SignUpController {
    private final UserService userService;

    @GetMapping
    public String index() {
        return "sign_up";
    }

    @PostMapping
    public String addUser(
            @Valid @ModelAttribute("signUpUser") SignUpRequest signUpRequest,
            BindingResult result,
            Map<String, Object> model
    ) {
        if (!result.hasErrors()) {
            if (!signUpRequest.getPassword().equals(signUpRequest.getMatchingPassword())) {
                model.put("notMatched", true);
                return "sign_up";
            }
            try {
                userService.addNewUser(signUpRequest);
                return "redirect:/login";
            } catch (UserAlreadyExistsException exp) {
                model.put("alreadyExists", true);
                return "sign_up";
            }
        }
        return "sign_up";
    }
}
