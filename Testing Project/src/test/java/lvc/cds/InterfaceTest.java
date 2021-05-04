package lvc.cds;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InterfaceTest {
    private static Interface interface1;

    @BeforeAll
    public static void setUp() throws Exception{
        interface1 = new Interface();
    }

    @Test
    @DisplayName("Adding a test record")
    public void testAdd(){
        assertEquals(true, interface1.action(1), "Simply adding a record");
    }

    @Test
    @DisplayName("Finding a record we have just added")
    public void testFind(){
        assertEquals(true, interface1.action(3), "Finding a record that exists in the map");
    }

    @Test
    @DisplayName("Removing a record")
    public void testRemove(){
        assertEquals(true, interface1.action(2), "Removing the added record");
    }
}
