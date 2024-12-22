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
public class Dishes {

    private int idDishes;
    private String name;
    private String description;
    private BigDecimal price;
    private String image;
    private int status;

    public Dishes() {
    }

    public Dishes(int idDishes, String name, String description, BigDecimal price, String image, int status) {
        this.idDishes = idDishes;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.status = status;
    }

    public int getIdDishes() {
        return idDishes;
    }

    public void setIdDishes(int idDishes) {
        this.idDishes = idDishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Dishes{" + "idDishes=" + idDishes + ", name=" + name + ", description=" + description + ", price=" + price + ", image=" + image + ", status=" + status + '}';
    }

}
