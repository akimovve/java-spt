package ru.mirea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.dao.StudentDao;
import ru.mirea.models.Group;
import ru.mirea.models.Student;

import java.util.Map;

@Controller
@RequestMapping("/home")
public class StudentsController {
    @Autowired
    private StudentDao studentDao;

    @GetMapping
    public String home(Map<String, Object> model) {
        model.put("groups", studentDao.getAll());
        return "home";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam String studentFirstName,
            @RequestParam String studentLastName,
            @RequestParam String studentMiddleName,
            @RequestParam String groupName,
            Map<String, Object> model
    ) {
        if (studentFirstName.isEmpty() || studentLastName.isEmpty() || studentMiddleName.isEmpty() || groupName.isEmpty()) {
            model.put("groups", studentDao.getAll());
            return "home";
        }
        Student student = new Student();
        student.setFirstName(studentFirstName);
        student.setLastName(studentLastName);
        student.setMiddleName(studentMiddleName);
        Group group = new Group(groupName);
        studentDao.save(group, student);
        model.put("groups", studentDao.getAll());
        return "home";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam int studentId, Map<String, Object> model) {
        studentDao.remove(studentId);
        model.put("groups", studentDao.getAll());
        return "home";
    }
}
