package ru.mirea.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mirea.models.Student;
import ru.mirea.repositories.GroupRepository;
import ru.mirea.repositories.StudentRepository;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private GroupRepository groupRepository;
    @Mock
    private StudentRepository studentRepository;

    @Test
    void getAllStudents() {
        Student student1 = new Student();
        student1.setFirstName("Mike");
        Student student2 = new Student();
        student2.setFirstName("Tom");
        Student student3 = new Student();
        student3.setFirstName("Alex");

        Mockito.when(studentRepository.findAll()).thenReturn(List.of(student1, student2, student3));
        StudentService studentService = new StudentService(groupRepository, studentRepository);
        Assertions.assertEquals(3, studentService.getAllStudents().size());
        Assertions.assertEquals("Alex", studentService.getAllStudents().get(2).getFirstName());
    }
}