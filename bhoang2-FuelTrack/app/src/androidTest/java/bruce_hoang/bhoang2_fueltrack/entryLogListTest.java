package bruce_hoang.bhoang2_fueltrack;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Bruce-PC on 1/29/2016.
 * Taken from https://github.com/b-hoang/lonelytwitter/tree/w16Thursday on Jan 29, 2016
 */
public class entryLogListTest extends ActivityInstrumentationTestCase2{

    public entryLogListTest() {
        super(MainActivity.class);
    }

    public void testAddEntry(){
        entryLogList entryLogs = new entryLogList();
        entryLog entry = new entryLog("1999-02-02", "Costco", 19999.4, "Regular", 30.000, 69.4, 20.82);

        entryLogs.addEntry(entry);

        assertTrue(entryLogs.hasEntry(entry));
    }


    public void testHasEntry(){
        entryLogList entryLogs = new entryLogList();
        entryLog entry = new entryLog("1999-02-02", "Costco", 19999.4, "Regular", 30.000, 69.4, 20.82);

        assertFalse(entryLogs.hasEntry(entry));
        entryLogs.addEntry(entry);
        assertTrue(entryLogs.hasEntry(entry));


    }

    public void testGetEntry() {
        entryLogList entryLogs = new entryLogList();
        entryLog entry = new entryLog("1999-02-02", "Costco", 19999.4, "Regular", 30.000, 69.4, 20.82);

        entryLogs.addEntry(entry);
        entryLog returnedEntry = entryLogs.getEntry(0);

        assertEquals(returnedEntry, entry);
    }

    public void testDeleteEntry(){
        entryLogList entryLogs = new entryLogList();
        entryLog entry = new entryLog("1999-02-02", "Costco", 19999.4, "Regular", 30.000, 69.4, 20.82);

        entryLogs.addEntry(entry);
        entryLogs.removeEntry(entry);
    }

    public void testGetCount(){
        entryLogList entryLogs = new entryLogList();
        entryLog entry1 = new entryLog("1999-02-02", "Costco", 19999.4, "Regular", 30.000, 69.4, 20.82);
        entryLog entry2 = new entryLog("1999-02-02", "Costco", 19999.4, "Regular", 30.000, 69.4, 20.82);
        entryLog entry3 = new entryLog("1999-02-02", "Costco", 19999.4, "Regular", 30.000, 69.4, 20.82);
        entryLog entry4 = new entryLog("1999-02-02", "Costco", 19999.4, "Regular", 30.000, 69.4, 20.82);
        entryLog entry5 = new entryLog("1999-02-02", "Costco", 19999.4, "Regular", 30.000, 69.4, 20.82);

        entryLogs.addEntry(entry1);
        entryLogs.addEntry(entry2);
        entryLogs.addEntry(entry3);
        entryLogs.addEntry(entry4);
        entryLogs.addEntry(entry5);

        assertEquals(entryLogs.getCount(), 5);
        entryLogs.removeEntry(entry5);
        assertEquals(entryLogs.getCount(), 4);
    }

    public void testSetEntry(){
        entryLogList entryLogs = new entryLogList();
        entryLog entry = new entryLog("1999-02-02", "Costco", 19999.4, "Regular", 30.000, 69.4, 20.82);

        entryLogs.addEntry(entry);
        entryLog entry2 = new entryLog("2000-02-02", "Costco", 29999.4, "Regular", 50.000, 79.4, 20.82);

        entryLogs.setEntry(0, entry2);
        assertTrue(entryLogs.hasEntry(entry2));
    }

}
