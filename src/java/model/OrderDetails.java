/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author TNO
 */
public class OrderDetails {
    private int orderDetailsID;
    private int orderID;
    private int idDish;
    private int quantity;
    private BigDecimal price;
    private String dishName;

    public OrderDetails() {
    }

    public OrderDetails(int orderDetailsID, int orderID, int idDish, int quantity, BigDecimal price, String dishName) {
        this.orderDetailsID = orderDetailsID;
        this.orderID = orderID;
        this.idDish = idDish;
        this.quantity = quantity;
        this.price = price;
        this.dishName = dishName;
    }

    public int getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(int orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getIdDish() {
        return idDish;
    }

    public void setIdDish(int idDish) {
        this.idDish = idDish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "orderDetailsID=" + orderDetailsID + ", orderID=" + orderID + ", idDish=" + idDish + ", quantity=" + quantity + ", price=" + price + ", dishName=" + dishName + '}';
    }

    
}
