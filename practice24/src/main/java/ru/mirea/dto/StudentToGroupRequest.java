package ru.mirea.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class StudentToGroupRequest {
    @NotBlank
    private final String studentFirstName;
    @NotBlank
    private final String studentLastName;
    private final String studentMiddleName;
    @NotBlank
    private final String groupName;
}
