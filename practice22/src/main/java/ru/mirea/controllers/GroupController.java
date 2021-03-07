package ru.mirea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.mirea.dto.DtoConverter;
import ru.mirea.services.GroupService;

import java.util.Map;

@Controller
@RequestMapping("groups")
public class GroupController {
    @Autowired
    private DtoConverter dtoConverter;
    @Autowired
    private GroupService groupService;

    @GetMapping
    public String getGroups(Map<String, Object> model) {
        model.put(
                "groups",
                groupService.takeAllGroups(dtoConverter::toGroupResponseList)
        );
        return "home";
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
        return new RedirectView("/groups");
    }
}
