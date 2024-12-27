package com.example.demo.model;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
private String name;
private String brand;
private double price;
private String madeIn;
private int quantity;
private double discountRate;
private double taxprice;
}
