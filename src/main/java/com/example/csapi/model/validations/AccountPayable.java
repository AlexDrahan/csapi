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
@Table(name = "accountpayable")

public class AccountPayable {
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

    @Min(value = 1, message = "Terms should not be less than 1")
    @Max(value = 30, message = "Terms should not be greater than 30")
    int terms;

    @Positive(message = "Days to pay should be a positive number")
    private int transcreditDaysToPay;

    @Pattern(regexp = "^([1-9]|[1-8][0-9]|9[0-9]|100)$", message = "Credit score should be between 1 and 100")
    private String transcreditCreditScore;


}
