package com.adarsh.jagati.SpringBootWebMVC.DTO;

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
    @Size(min = 5, max = 80, message = "give valid age, in range")
    private Integer age;

    @PastOrPresent(message = "Give valid date of joining")
    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private Boolean isActive;

}
