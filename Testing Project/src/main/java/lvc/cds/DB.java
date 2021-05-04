package lvc.cds;

import java.util.HashMap;

public interface DB {

    public boolean add(String name, String number); 

    public boolean remove(String name);

    public String find(String name);
    
}
