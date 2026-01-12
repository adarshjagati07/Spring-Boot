package com.adarsh.jagati.SpringBootWebMVC.DTO;

import com.adarsh.jagati.SpringBootWebMVC.Annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name cannot be left blank")
    @Size(min = 3, max = 15, message = "Name should be in range [3,15]")
    private String name;

    @Email(message = "Give proper email")
    private String email;

    @Positive(message = "Write valid age")
    @Min(value = 18, message = "Age must be greater than 18")
    @Max(value = 80, message = "Age must be less than 80")
    private Integer age;

    @NotNull(message = "Role cannot be null")
    @EmployeeRoleValidation
    private String role;

    @PastOrPresent(message = "Give valid date of joining")
    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private Boolean isActive;

}
