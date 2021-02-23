package ru.mirea.dao;

import org.springframework.stereotype.Component;
import ru.mirea.models.Group;
import ru.mirea.models.Student;

import java.util.*;

@Component
public class StudentDao {
    private static int ID_INCR = 0;
    private final Map<Group, List<Student>> groups = new HashMap<>();

    public void save(Group group, Student student) {
        Optional<Group> currGroup = groups
                .keySet()
                .stream()
                .filter(key ->
                        key.getGroupName()
                                .equals(group.getGroupName()))
                .findFirst();
        student.setId(ID_INCR++);
        if (currGroup.isPresent()) {
            groups.get(currGroup.get()).add(student);
        } else {
            List<Student> students = new ArrayList<Student>() {{
                add(student);
            }};
            groups.put(group, students);
        }
    }

    public void remove(int id) {
        groups.values().forEach(v -> v.removeIf(st -> st.getId() == id));
        groups.entrySet().removeIf(el -> el.getValue().size() == 0);
        ID_INCR--;
    }

    public Map<Group, List<Student>> getAll() {
        return groups;
    }
}
