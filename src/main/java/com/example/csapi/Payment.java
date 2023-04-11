package com.example.csapi;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private String paymentMethod;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;*/

    public Payment(Double amount, Date paymentDate, PaymentMethod paymentMethod, Order order) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = String.valueOf(paymentMethod);
        /*this.order = order;*/
    }


}
