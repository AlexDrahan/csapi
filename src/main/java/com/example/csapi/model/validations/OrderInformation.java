package com.example.csapi.model.validations;

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
@Document("order-information")
public class OrderInformation {
    @MongoId(FieldType.OBJECT_ID)
    Short id;


//    @NotBlank(message = "Load type is required")
    String loadType;

//    @Pattern(regexp = "^[0-9]{7}$", message = "Invalid ref. NO")
    String refNo;

//    @Pattern(regexp = "^[0-9]{5}$", message = "Invalid order NO")
    String orderNo;

//    @NotNull(message = "Total miles is required")
//    @Min(value = 0, message = "Total miles must be greater than or equal to 0")
//    @Max(value = 100000, message = "Total miles must be less than or equal to 999999")
    Integer totalMiles;

//    @NotNull(message = "Total piece units is required")
//    @Min(value = 0, message = "Total piece units must be greater than or equal to 0")
//    @Max(value = 100000, message = "Total piece units must be less than or equal to 100000")
    Integer totalPieceUnits;

//    @NotNull(message = "Total weight is required")
//    @DecimalMin(value = "0.01", message = "Total weight must be greater than or equal to 0.01")
//    @DecimalMax(value = "100000.00", message = "Total weight must be less than or equal to 100000.00")
    BigDecimal totalWeight;

//    @NotBlank(message = "Dims(LxWxH) are required")
//    @Pattern(regexp = "^\\d+(?:\\.\\d+)?x\\d+(?:\\.\\d+)?x\\d+(?:\\.\\d+)?$", message = "Dims(LxWxH) must be in the format of LxWxH")
    String dims;

    Boolean hazMaterials;

//    @NotNull(message = "Dock level is required")
     Integer dockLevel;

//    @NotNull(message = "CSA load is required")
    Boolean csaLoad;

    String notes;
}
