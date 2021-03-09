package ru.mirea.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.mirea.dto.StudentToGroupRequest;
import ru.mirea.services.GroupService;
import ru.mirea.services.StudentService;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final GroupService groupService;
    private final StudentService studentService;

    @PostMapping("add")
    public RedirectView add(
            @Valid @ModelAttribute("addStudent") StudentToGroupRequest studentToGroupRequest,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            groupService.publish(studentToGroupRequest);
            studentService.publish(studentToGroupRequest);
        }
        return new RedirectView("/home");
    }

    @PostMapping("{studentId}/delete")
    public RedirectView delete(@PathVariable long studentId) {
        studentService.delete(studentId);
        return new RedirectView("/home");
    }
}
