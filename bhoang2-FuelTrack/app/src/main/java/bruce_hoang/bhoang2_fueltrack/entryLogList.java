package bruce_hoang.bhoang2_fueltrack;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Bruce-PC on 1/29/2016.
 * Taken from lonelyTwitter Jan-29-2016
 */
public class entryLogList implements Serializable{
    private ArrayList<entryLog> entryLogs = new ArrayList<>();

    public void addEntry(entryLog entry){
        entryLogs.add(entry);
    }

    public boolean hasEntry(entryLog entry) {
        return entryLogs.contains(entry);
    }

    public void removeEntry(entryLog entry){
        entryLogs.remove(entry);
    }

    public entryLog getEntry(int index){
        return entryLogs.get(index);
    }

    public int getCount(){
        return entryLogs.size();
    }

    public void setEntry(int index, entryLog entry){
        entryLogs.set(index, entry);
    }
}
