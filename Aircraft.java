package com.bsu.by;

import java.util.Objects;

public class Aircraft {


    private int id;
    private String nameOfCompany;
    private int number;
    private String model;
    private String dateOfproduction;
    private int capacity;
    private double qualityControl;

    public Aircraft(String id,String nameOfCompany,String number,String model,String dateOfproduction,String capacity,String qualityControl) {
        this.id = Integer.parseInt(id);
        this.nameOfCompany=nameOfCompany;
        this.number=Integer.parseInt(number);
        this.model=model;
        this.dateOfproduction=dateOfproduction;
        this.capacity=Integer.parseInt(capacity);
        this.qualityControl=Double.parseDouble(qualityControl);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", nameOfCompany='" + nameOfCompany + '\'' +
                ", number=" + number +
                ", model='" + model + '\'' +
                ", dateOfproduction='" + dateOfproduction + '\'' +
                ", capacity=" + capacity +
                ", qualityControl=" + qualityControl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return id == aircraft.id &&
                number == aircraft.number &&
                capacity == aircraft.capacity &&
                Double.compare(aircraft.qualityControl, qualityControl) == 0 &&
                nameOfCompany.equals(aircraft.nameOfCompany) &&
                model.equals(aircraft.model) &&
                dateOfproduction.equals(aircraft.dateOfproduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfCompany, number, model, dateOfproduction, capacity, qualityControl);
    }

    public int getId() {
        return id;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public String getDateOfproduction() {
        return dateOfproduction;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getQualityControl() {
        return qualityControl;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public void setNumber(String number) {
        this.number = Integer.parseInt(number);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCapacity(String capacity) {
        this.capacity = Integer.parseInt(capacity);
    }

    public void setQualityControl(String qualityControl) {
        this.qualityControl = Double.parseDouble(qualityControl);
    }

    public void setDateOfproduction(String dateOfproduction) {
        this.dateOfproduction = dateOfproduction;
    }
}

