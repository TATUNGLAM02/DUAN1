package com.example.duannhom10.model;

public class Order {
    private int orderId;
    private String date;
<<<<<<< HEAD
    private String address;
    private double total;

    public Order(int orderId, String date, String address, double total) {
        this.orderId = orderId;
        this.date = date;
        this.address = address;
        this.total = total;
    }
    // Getters và Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
=======
    private String status;
    private double total;
    private String address;
    private String name;

    public Order(int orderId, String date, String status, double total, String address, String name) {
        this.orderId = orderId;
        this.date = date;
        this.status = status;
        this.total = total;
        this.address = address;
        this.name = name;
    }

    // Getter và Setter
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
>>>>>>> 5fc002c472a9b4cb5f126ad5dfa85d4ab4d14417
}
