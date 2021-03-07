package ru.mirea.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.dto.StudentToGroupRequest;
import ru.mirea.models.Group;
import ru.mirea.models.Student;
import ru.mirea.repositories.GroupRepository;
import ru.mirea.repositories.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final EmailService emailService;

    @Transactional
    public void publish(StudentToGroupRequest request) {
        String groupName = request.getGroupName();
        Group group = groupRepository.findByGroupName(groupName);
        if (group == null) {
            return;
        }
        Student student = new Student();
        student.setFirstName(request.getStudentFirstName());
        student.setLastName(request.getStudentLastName());
        student.setMiddleName(request.getStudentMiddleName());
        student.setGroup(group);
        studentRepository.save(student);

        // Testing Criteria API
        log.info("*****Criteria API*****");
        List<Student> studentsByGroupName = studentRepository.findStudentsByGroupName("IKBO-01-19");
        log.info("-Students by group name:");
        studentsByGroupName
                .forEach(st ->
                        log.info(st.getLastName() + " " + st.getFirstName() + " " + st.getMiddleName() + " -- " + st.getGroup().getGroupName())
                );

        List<Student> studentsByFirstAndLastName = studentRepository.findStudentsByFirstNameAndLastName("Jack", "Dorsey");
        log.info("-Students by first and last name:");
        studentsByFirstAndLastName
                .forEach(st ->
                        log.info(st.getLastName() + " " + st.getFirstName() + " " + st.getMiddleName() + " -- " + st.getGroup().getGroupName())
                );

        emailService.send(
                "Student save",
                student.getFirstName() + " from group " + student.getGroup().getGroupName() + " has been saved to the database."
        );
    }

    public void delete(long id) {
        studentRepository.deleteById(id);
    }
}
