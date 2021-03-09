package ru.mirea.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.dto.DtoConverter;
import ru.mirea.services.GroupService;

import java.util.Map;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    private final GroupService groupService;
    private final DtoConverter dtoConverter;

    @GetMapping
    public String index(Map<String, Object> model) {
        model.put(
                "groups",
                groupService.takeAllGroups(dtoConverter::toGroupResponseList)
        );
        return "home";
    }
}
