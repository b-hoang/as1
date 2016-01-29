package bruce_hoang.bhoang2_fueltrack;

/**
 * Created by Bruce-PC on 1/27/2016.
 */
public class entryLog {
    private String date, station, fuelGrade;
    private float odometer, fuelAmount, fuelUnitCost, fuelCost;

    private entryLog(){
    }

    public entryLog(String date, String station, String fuelGrade, float odometer,
                    float fuelAmount, float fuelUnitCost, float fuelCost){
        this.date = date;
        this.station = station;
        this.odometer = odometer;
        this.fuelGrade = fuelGrade;;
        this.fuelAmount = fuelAmount;
        this.fuelUnitCost = fuelUnitCost;
        this.fuelCost = fuelCost;
    }

    @Override
    public String toString(){
        return("Date: " + date + "\nStation: " + station + "\nOdometer Reading: " + odometer +
                "\nFuel Grade: " + fuelGrade + "\nFuel Amount: " + fuelAmount + "\nFuel Unit Cost: "
                + fuelUnitCost + "\nFuel Cost: " + fuelCost);
    }

}
