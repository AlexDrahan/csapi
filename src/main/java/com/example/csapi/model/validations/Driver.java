package com.example.csapi.model.validations;


import com.example.csapi.model.enums.WorkDocuments;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Min(value = 0)
    private Short id;
    @Max(value = 30, message = "Max length of a first name should be less than 30 letters")
    @Column(name = "first_name")
    String driverFirstName;
    @Max(value = 30, message = "Max length of a last name should be less than 30 letters")
    @Column(name = "last_name")
    String driverLastName;
    @Column(name = "phone_number")
    String driverPhoneNumber;
    @Column(name = "email_address")
    String driverEmail;
    @Column(name = "home_location")
    String homeLocation;
    @Column(name = "isTeam")
    boolean isTeam;
    @Column(name = "isTracked")
    boolean isTracked;
    @Column(name = "canadaFreights")
    boolean canadaFreights;
    @Column(name = "details")
    String details;
    @Column(name = "workDocuments")
    WorkDocuments workDocuments;

}
