package lvc.cds;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Database implements DB {
    HashMap<String, String> records;
    static Logger l = LogManager.getRootLogger();

    public Database() {
        records = new HashMap<>();
    }

    public boolean add(String n, String p){
        l.debug("In add");
        try {
            records.put(n, p);

            l.debug("Put was successful. Returning true from add");
            return true;
        } catch (Exception e) {
            l.warn("Was not added successfully. Name is already present in records.");
            return false;
        }
    }

    public boolean remove(String n){
        l.debug("In remove");
        if(records.containsKey(n)){
            String p = records.remove(n);
            l.debug("Record removed successfully");
            return true;
        }
        else
            l.warn("Record was not present. Removal did not occur.");
            return false;
    }

    public String find(String n){
        l.debug("In find");
        if(records.containsKey(n)){
            String number = records.get(n);
            l.debug("Record was found.");
            return number;
        }
        else
            l.error("Record not found");
            return null;
    }

    public static void main(String[] args) {
        var db = new Database();
        db.add("Kenneth Yarnall", "123-4567");
        db.add("Kenneth Yarnall", "123-4568");
        db.find("Kenneth Yarnall");
    }
}
