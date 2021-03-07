package ru.mirea.repositories;

import ru.mirea.models.Student;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StudentFilter {
    List<Student> findStudentsByGroupName(String groupName);
    List<Student> findStudentsByFirstNameAndLastName(String fName, String lName);
}
