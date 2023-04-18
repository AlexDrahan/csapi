package com.example.csapi.model.validations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("account-payable")
public class AccountPayable {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

//    @NotBlank(message = "Contact name cannot be blank")
    String contactName;

//    @NotNull(message = "Phone cannot be null")
//    @Size(min = 10, max = 10, message = "Phone number must be 10 digits long")
//    @Pattern(regexp = "[0-9]+", message = "Phone number must contain only digits")
    String contactPhone;

//    @Email(message = "Invalid email format")
//    @NotBlank(message = "E-mail cannot be blank")
    String email;

//    @Min(value = 1, message = "Terms should not be less than 1")
//    @Max(value = 30, message = "Terms should not be greater than 30")
    int terms;

//    @Positive(message = "Days to pay should be a positive number")
    private int transcreditDaysToPay;

//    @Pattern(regexp = "^([1-9]|[1-8][0-9]|9[0-9]|100)$", message = "Credit score should be between 1 and 100")
    private String transcreditCreditScore;


}
