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
public class ItemDishes {
    private String id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private BigDecimal total;

    public ItemDishes() {
    }

    public ItemDishes(String id, String name, BigDecimal price, int quantity, BigDecimal total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ItemDishes{" + "id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", total=" + total + '}';
    }
    
    
    
    
    
}
