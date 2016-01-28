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
}
