package ru.mirea.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.dto.StudentToGroupRequest;
import ru.mirea.models.Group;
import ru.mirea.repositories.GroupRepository;
import ru.mirea.repositories.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    // private final EmailService emailService;

    @Transactional
    public void publish(StudentToGroupRequest request) {
        String groupName = request.getGroupName();
        Group group = groupRepository.findByGroupName(groupName);
        if (group != null) {
            return;
        }
        group = new Group();
        group.setGroupName(request.getGroupName());
        groupRepository.save(group);
        /*
        emailService.send(
                "Group save",
                group.getGroupName() + " has been saved to the database."
        );
        */
    }

    @Transactional
    public <T> T takeAllGroups(Function<List<Group>, T> toDto) {
        List<Group> groups = groupRepository.findAll();
        return toDto.apply(groups);
    }

    @Transactional
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Transactional
    public <T> T takeGroupById(long id, Function<Group, T> toDto) {
        Optional<Group> group = groupRepository.findById(id);
        if (group.isEmpty()) {
            return null;
        }
        return toDto.apply(group.get());
    }

    @Transactional
    public void delete(long id) {
        Optional<Group> group = groupRepository.findById(id);
        if (group.isEmpty()) {
            return;
        }
        studentRepository.deleteAllByGroup(group.get());
        groupRepository.deleteById(id);
    }
}
