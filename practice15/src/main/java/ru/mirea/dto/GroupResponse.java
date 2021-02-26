package ru.mirea.dto;

import com.sun.istack.NotNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
public class GroupResponse {
    @NotNull
    private Long id;
    @NotBlank
    private String groupName;
    private List<StudentResponse> students;
}
