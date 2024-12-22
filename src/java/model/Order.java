/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {

    private int orderID;
    private Timestamp orderDate;
    private int tableNum;
    private String nameCustomer;
    private String phoneNum;
    private BigDecimal totalAmount;
    private int createdBy;
    private int status;
        
    public Order() {
    }

    public Order(int orderID, Timestamp orderDate, int tableNum, String nameCustomer, String phoneNum, BigDecimal totalAmount, int createdBy, int status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.tableNum = tableNum;
        this.nameCustomer = nameCustomer;
        this.phoneNum = phoneNum;
        this.totalAmount = totalAmount;
        this.createdBy = createdBy;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", tableNum=" + tableNum + ", nameCustomer=" + nameCustomer + ", phoneNum=" + phoneNum + ", totalAmount=" + totalAmount + ", createdBy=" + createdBy + ", status=" + status + '}';
    }

    

}
