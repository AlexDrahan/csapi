package com.example.csapi.model.validations;

import com.example.csapi.model.enums.WorkDocuments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("brokers")
public class Broker {


    @MongoId(value = FieldType.OBJECT_ID)
    String id;

//    @NotBlank(message = "Broker name cannot be blank")
    String brokerName;

//    @NotBlank(message = "Company name cannot be blank")
    String companyName;

//    @NotNull(message = "Alliance member since is required")
//    @Min(value = 1900, message = "Alliance member since year must be greater than or equal to 1900")
//    @Max(value = 2023, message = "Alliance member since year must be less than or equal to 2023")
    Integer allianceMemberSince;

//    @NotBlank(message = "Posted by cannot be blank")
    String postedBy;

//    @NotNull(message = "Posted by phone cannot be null")
//    @Size(min = 10, max = 10, message = "Phone number must be 10 digits long")
//    @Pattern(regexp = "[0-9]+", message = "Phone number must contain only digits")
    String postedByPhone;

//    @Email(message = "Invalid email format")
//    @NotBlank(message = "E-mail cannot be blank")
    String email;

//    @NotBlank(message = "Posted by title cannot be blank")
    String postedByTitle;

//    @NotNull(message = "Phone cannot be null")
//    @Size(min = 10, max = 10, message = "Phone number must be 10 digits long")
//    @Pattern(regexp = "[0-9]+", message = "Phone number must contain only digits")
    String phone;

//    @Size(max = 10, message = "Fax number cannot be more than 10 digits long")
//    @Pattern(regexp = "[0-9]+", message = "Fax number must contain only digits")
    String fax;

    String authority;
//    @Pattern(regexp = "^[0-9]{2}-[0-9]{7}$", message = "Invalid U.S Dot reference format")
    String usDotReference;

//    @Pattern(regexp = "^[0-9]{8}$", message = "Invalid MC number format")
    String mcNumber1;

//    @Pattern(regexp = "^([A-Z]{2})?[0-9]{7}$", message = "Invalid MC number format")
    String mcNumber2;

//    @Pattern(regexp = "^[0-9]{7}$", message = "Invalid Broker MC number format")
    String brokerMcNumber;

//    @Pattern(regexp = "^[0-9]{9}$", message = "Invalid CVOR number format")
    String cvorNumber;

//    @NotNull(message = "Cargo insurance is required")
//    @DecimalMin(value = "0.01", message = "Cargo insurance value must be greater than or equal to 0.01")
    BigDecimal cargoInsurance;
    WorkDocuments workDocuments;

}
