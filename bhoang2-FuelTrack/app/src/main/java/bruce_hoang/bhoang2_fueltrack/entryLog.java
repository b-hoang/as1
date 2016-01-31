package bruce_hoang.bhoang2_fueltrack;

/**
 * Created by Bruce-PC on 1/27/2016.
 */
public class entryLog extends newEntryActivity {
    private String date;
    private String station;
    private String fuelGrade;
    private double odometer;
    private double fuelAmount;
    private double fuelUnitCost;
    private double fuelCost;

//    public entryLog(){
//    }

    public entryLog(String date, String station, double odometer, String fuelGrade,
                    double fuelAmount, double fuelUnitCost, double fuelCost){
        this.date = date;
        this.station = station;
        this.odometer = odometer;
        this.fuelGrade = fuelGrade;;
        this.fuelAmount = fuelAmount;
        this.fuelUnitCost = fuelUnitCost;
        this.fuelCost = fuelCost;
    }

//    Taken from https://en.wikipedia.org/wiki/Gson, Jan 31, 2016
//    Converts the entry log to a string.
    @Override
    public String toString(){
/*        StringBuilder sb = new StringBuilder();

        sb.append("Date: " + date + "\n");
        sb.append("Station: " + station + "\n");
        sb.append("Odometer Reading: " + odometer + "\n");
        sb.append("Fuel Grade: " + fuelGrade + "\n");
        sb.append("Fuel Amount: " + fuelAmount + "\n");
        sb.append("Fuel Unit Cost: " + fuelUnitCost + "\n");
        sb.append("Fuel Cost: " + fuelCost + "\n");

        return sb.toString();*/
        return("Date: " + date + "\nStation: " + station + "\nOdometer Reading: " + odometer +
                "\nFuel Grade: " + fuelGrade + "\nFuel Amount: " + fuelAmount + "\nFuel Unit Cost: "
                + fuelUnitCost + "\nFuel Cost: " + fuelCost + "\n");
    }

}
