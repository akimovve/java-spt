package ru.mirea.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.mirea.dto.DtoConverter;
import ru.mirea.services.GroupService;

import java.util.Map;

@Controller
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
    private final DtoConverter dtoConverter;
    private final GroupService groupService;

    @GetMapping
    public String getGroups(Map<String, Object> model) {
        model.put(
                "groups",
                groupService.takeAllGroups(dtoConverter::toGroupResponseList)
        );
        return "group";
    }

    @PostMapping("{groupId}")
    public String getGroup(
            @PathVariable long groupId,
            Map<String, Object> model
    ) {
        model.put(
                "group",
                groupService.takeGroupById(groupId, dtoConverter::toGroupResponse)
        );
        return "group";
    }

    @PostMapping("{groupId}/delete")
    public RedirectView delete(@PathVariable long groupId) {
        groupService.delete(groupId);
        return new RedirectView("/home");
    }

    @GetMapping("add")
    public String add() {
        return "add";
    }
}
