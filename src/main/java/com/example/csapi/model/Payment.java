package com.example.csapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("payments")
public class Payment {

    @MongoId(FieldType.OBJECT_ID)
    private Long id;

    private Double amount;

    private Date paymentDate;

    private PaymentMethod paymentMethod;


}
