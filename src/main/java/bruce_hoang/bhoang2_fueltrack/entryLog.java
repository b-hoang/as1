package bruce_hoang.bhoang2_fueltrack;

import java.io.Serializable;

/**
 * Created by Bruce-PC on 1/27/2016.
 */
public class entryLog implements Serializable{
    private String date;
    private String station;
    private String fuelGrade;
    private double odometer;
    private double fuelAmount;
    private double fuelUnitCost;
    private double fuelCost;

    public entryLog(){
    }

    public entryLog(String date, String station, double odometer, String fuelGrade,
                    double fuelAmount, double fuelUnitCost, double fuelCost){
        this.date = date;
        this.station = station;
        this.odometer = odometer;
        this.fuelGrade = fuelGrade;
        this.fuelAmount = fuelAmount;
        this.fuelUnitCost = fuelUnitCost;
        this.fuelCost = fuelCost;
    }

//    Taken from https://en.wikipedia.org/wiki/Gson, Jan 31, 2016
//    Converts the entry log to a string.
    @Override
    public String toString(){
        return("Date: " + date + "\nStation: " + station + "\nOdometer Reading: " + odometer +
                "\nFuel Grade: " + fuelGrade + "\nFuel Amount: " + fuelAmount + "\nFuel Unit Cost: "
                + fuelUnitCost + "\nFuel Cost: " + fuelCost + "\n");
    }

    // Returns the date
    public String getDate(){
        return this.date;
    }

    // Returns the station
    public String getStation(){
        return this.station;
    }

    // Returns the Odometer Reading
    public Double getOdometer(){
        return this.odometer;
    }

    // Returns the Fuel Grade
    public String getFuelGrade(){
        return this.fuelGrade;
    }

    // Returns the Fuel Amount
    public Double getFuelAmount(){
        return this.fuelAmount;
    }

    // Returns the Fuel Unit Cost
    public Double getFuelUnitCost(){
        return this.fuelUnitCost;
    }

    // Returns the Fuel Cost
    public Double getFuelCost(){
        return this.fuelCost;
    }

    // Sets the date
    public void setDate(String date){
        this.date = date;
    }

    // Sets the station
    public void setStation(String station){
        this.station = station;
    }

    // Sets the Odometer Reading
    public void setOdometer(Double odometer){
        this.odometer = odometer;
    }

    // Sets the Fuel Grade
    public void setFuelGrade(String fuelGrade){
        this.fuelGrade = fuelGrade;
    }

    // Sets the Fuel Amount
    public void setFuelAmount(Double fuelAmount){
        this.fuelAmount = fuelAmount;
    }

    // Sets the Fuel Unit Cost
    public void setFuelUnitCost(Double fuelUnitCost){
        this.fuelUnitCost = fuelUnitCost;
    }

    // Sets the Fuel Cost
    public void setFuelCost(Double fuelCost){
        this.fuelCost = fuelCost;
    }



}
