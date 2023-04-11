package com.example.csapi.model.validations;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "complaint")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @NotBlank(message = "Contact name cannot be blank")
    String contactName;

    @NotNull(message = "Phone cannot be null")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits long")
    @Pattern(regexp = "[0-9]+", message = "Phone number must contain only digits")
    String contactPhone;

    @Email(message = "Invalid email format")
    @NotBlank(message = "E-mail cannot be blank")
    String email;
}
