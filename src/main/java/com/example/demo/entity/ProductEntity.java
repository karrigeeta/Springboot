package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity {
	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String name;
private String brand;
private String madeIn;
private double price;
private int quantity;
private double discountRate;
private double discountprice;
private double offerprice;
private double finalprice;
private double stockvalue;
private double taxprice;
}