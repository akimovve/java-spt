package ru.mirea.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "university_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20, unique = true)
    private String groupName;
    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private List<Student> students;
}
