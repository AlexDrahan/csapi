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
@Document("complaint")
public class Complaint {
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
}
