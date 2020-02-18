/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.neifi.model;

/**
 *
 * @author neifi
 */
public class Components {

    private int id;
    private String brand;
    private String modelName;
    private String description;
    private String memType;
    private String resolution;
    private String outputType;
    private double price;
    private double memSpeed;
    private double capacity;
    private double clockVelocity;
    private double powerConsumption;
    private double tdp;
    private double width;
    private double height;
    private double depth;
    private double weight;

    public Components() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getClockVelocity() {
        return clockVelocity;
    }

    public void setClockVelocity(double clockVelocity) {
        this.clockVelocity = clockVelocity;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMemSpeed() {
        return memSpeed;
    }

    public void setMemSpeed(double memSpeed) {
        this.memSpeed = memSpeed;
    }

    public String getMemType() {
        return memType;
    }

    public void setMemType(String memType) {
        this.memType = memType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getPrice() {
        return price;
    }

    public String getResolution() {
        return resolution;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTdp() {
        return tdp;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public double getWeight() {
        return weight;
    }

    public void setTdp(double tdp) {
        this.tdp = tdp;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
