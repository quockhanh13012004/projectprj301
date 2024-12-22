/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author TNO
 */
public class OrderResponse extends Order{
    private String nameStaff;

    public OrderResponse() {
    }

    public OrderResponse(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public OrderResponse(String nameStaff, int orderID, Timestamp orderDate, int tableNum, String nameCustomer, String phoneNum, BigDecimal totalAmount, int createdBy, int status) {
        super(orderID, orderDate, tableNum, nameCustomer, phoneNum, totalAmount, createdBy, status);
        this.nameStaff = nameStaff;
    }

    

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    @Override
    public String toString() {
        return "OrderResponse{" + "nameStaff=" + nameStaff + '}';
    }
    
    
    
}
