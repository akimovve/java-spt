package ru.mirea.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mirea.dto.DtoConverter;
import ru.mirea.dto.StudentToGroupRequest;
import ru.mirea.models.Group;
import ru.mirea.repositories.GroupRepository;
import ru.mirea.repositories.StudentRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GroupServiceTest {
    @Mock
    private GroupRepository groupRepository;
    @Mock
    private StudentRepository studentRepository;
    @Autowired
    private DtoConverter dtoConverter;
    @Captor
    private ArgumentCaptor<Group> argumentCaptor;

    @Test
    void publish() {
        GroupService groupService = new GroupService(groupRepository, studentRepository);
        groupService.publish(
                StudentToGroupRequest.builder()
                        .studentFirstName("Matt")
                        .studentLastName("Black")
                        .groupName("IKBO-01-19")
                        .build()
        );
        Mockito.verify(groupRepository).save(argumentCaptor.capture());
        Group captured = argumentCaptor.getValue();
        assertEquals("IKBO-01-19", captured.getGroupName());
    }

    @Test
    void getAllGroups() {
        Group group = new Group();
        group.setGroupName("Group 1");
        Group group2 = new Group();
        group2.setGroupName("Group 2");

        Mockito.when(groupRepository.findAll()).thenReturn(List.of(group, group2));
        GroupService groupService = new GroupService(groupRepository, studentRepository);
        Assertions.assertEquals(2, groupService.getAllGroups().size());
        Assertions.assertEquals("Group 1", groupService.getAllGroups().get(0).getGroupName());
    }

    @Test
    void takeGroupById() {
        Group group1 = new Group();
        group1.setId(3L);
        group1.setGroupName("Group 1");
        group1.setStudents(Collections.emptyList());

        Mockito.when(groupRepository.findById(3L)).thenReturn(Optional.of(group1));
        GroupService groupService = new GroupService(groupRepository, studentRepository);
        Assertions.assertEquals("Group 1", groupService.takeGroupById(3L, dtoConverter::toGroupResponse).getGroupName());
    }
}