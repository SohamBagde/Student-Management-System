package sms.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    @NotEmpty(message = "first name cannot be empty")
    private String firstName;
    @NotEmpty(message = "last name cannot be empty")
    private String lastName;
    @Email
    @NotEmpty(message = "last name cannot be empty")
    private String email;
}
