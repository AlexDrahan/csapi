package com.example.csapi.model.validations;

import com.example.csapi.model.Bid;
import com.example.csapi.model.Dimensions;
import com.example.csapi.model.enums.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("loads")
public class LoadInformation {
    @MongoId(FieldType.OBJECT_ID)
    private String id;


//    @NotBlank(message = "Load type is required")
    private String loadType;

//    @Pattern(regexp = "^[0-9]{7}$", message = "Invalid ref. NO")
    private String refNo;

//    @Pattern(regexp = "^[0-9]{5}$", message = "Invalid order NO")
    private String orderNo;

//    @NotNull(message = "Total miles is required")
//    @Min(value = 0, message = "Total miles must be greater than or equal to 0")
//    @Max(value = 100000, message = "Total miles must be less than or equal to 999999")
    private Integer totalMiles;

//    @NotNull(message = "Total piece units is required")
//    @Min(value = 0, message = "Total piece units must be greater than or equal to 0")
//    @Max(value = 100000, message = "Total piece units must be less than or equal to 100000")
    private Integer totalPieceUnits;

//    @NotNull(message = "Total weight is required")
//    @DecimalMin(value = "0.01", message = "Total weight must be greater than or equal to 0.01")
//    @DecimalMax(value = "100000.00", message = "Total weight must be less than or equal to 100000.00")
    //load's weight
    private short payload;

//    @NotBlank(message = "Dims(LxWxH) are required")
//    @Pattern(regexp = "^\\d+(?:\\.\\d+)?x\\d+(?:\\.\\d+)?x\\d+(?:\\.\\d+)?$", message = "Dims(LxWxH) must be in the format of LxWxH")
    private Dimensions dims;
    private short amount;

    private Boolean hazMaterials;
    private Boolean isRotatable;

//    @NotNull(message = "Dock level is required")
     private Integer dockLevel;
     private CarType neededCarType;

//    @NotNull(message = "CSA load is required")
    private Boolean csaLoad;

    private String notes;
    protected List<Bid> currentBids;
}
