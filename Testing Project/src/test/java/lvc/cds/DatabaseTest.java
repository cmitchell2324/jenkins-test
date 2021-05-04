package lvc.cds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DatabaseTest {
    private static Database db;

    @BeforeAll
    public static void setUp() throws Exception{
        db = new Database();
    }

    @Test
    @DisplayName("Adding a test record")
    public void testAdd(){
        assertEquals(true, db.add("John Doe", "8561234567"), "Simply adding a record");
    }

    @Test
    @DisplayName("Finding a record we have just added")
    public void testFind(){
        assertEquals("8561234567", db.find("John Doe"), "Finding a record that exists in the map");
    }

    @Test
    @DisplayName("Removing a record")
    public void testRemove(){
        assertEquals(true, db.remove("John Doe"), "Removing the added record");
    }
}
