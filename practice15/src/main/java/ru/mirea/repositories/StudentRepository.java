package ru.mirea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.models.Group;
import ru.mirea.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteAllByGroup(Group group);
}
