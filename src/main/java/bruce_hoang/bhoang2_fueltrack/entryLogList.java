package bruce_hoang.bhoang2_fueltrack;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Bruce-PC on 1/29/2016.
 * Taken from lonelyTwitter Jan-29-2016
 *
 * I kept getting a Casting Error on Line 99 of MainActivity.java with this, so I decided
 * not to use this class. This was a last minute Error that randomly occurred. It didn't
 * happen the previous days I worked on the assignment. I'll keep this Class though, because
 * I used it for tests prior to this Casting Error.
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
