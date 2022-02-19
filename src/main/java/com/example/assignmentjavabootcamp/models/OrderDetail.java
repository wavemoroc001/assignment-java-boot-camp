package com.example.assignmentjavabootcamp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;

    @NotBlank
    private String productName;

    @NotBlank
    private String color;

    @NotBlank
    private Integer amount;

    @NotBlank
    private Double price;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Order order;

    public OrderDetail(String productName, String color, Integer amount, Double price, Order order) {
        this.productName = productName;
        this.color = color;
        this.amount = amount;
        this.price = price;
        this.order = order;
    }
}
