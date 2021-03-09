package ru.mirea.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@ToString
public class GroupResponse {
    @NotNull
    private Long id;
    @NotBlank
    private String groupName;
    private List<StudentResponse> students;
}
