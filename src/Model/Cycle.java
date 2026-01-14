/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author khadk
 */
public class Cycle {
    private int id;
    private String model;
    private double price;
    private String status;

    // Constructor and Getters...
    public Cycle(int id, String model, double price, String status) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.status = status;
    }

    public static ArrayList<Cycle> getInitialData() {
        ArrayList<Cycle> list = new ArrayList<>();
    
    list.add(new Cycle(101, "Mountain Bike", 500.0, "Available"));
    list.add(new Cycle(102, "Road Bike", 450.0, "In Use"));
    list.add(new Cycle(103, "Electric Cycle", 800.0, "Available"));
    list.add(new Cycle(104, "BMX Stunt Bike", 600.0, "Available"));
    list.add(new Cycle(105, "Hybrid Commuter", 550.0, "Maintenance"));
    list.add(new Cycle(106, "Kids Mini-Bike", 300.0, "Available"));
    list.add(new Cycle(107, "Fat Tire Sand Bike", 750.0, "Available"));
    list.add(new Cycle(108, "Folding Urban Bike", 400.0, "Available"));
    list.add(new Cycle(109, "Tandem Double Bike", 900.0, "In Use"));
    list.add(new Cycle(110, "Carbon Fiber Racer", 1200.0, "Available"));
    list.add(new Cycle(111, "Vintage Cruiser", 350.0, "Maintenance"));
    list.add(new Cycle(112, "Electric Scooter", 250.0, "Available"));
    return list;
    }

    public int getId() { return id; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }
    public void setStatus(String status) {this.status = status;}
}