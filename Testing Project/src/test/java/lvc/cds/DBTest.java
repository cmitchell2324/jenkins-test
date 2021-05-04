package lvc.cds;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DBTest {
    Database database;

    @BeforeAll
    public static void setUp() throws Exception{
        Database databaseMock = mock(Database.class);
    }

    @Test
    @DisplayName("Adding a record")
    public void testAdd(){
        
    }
    
    @Test
    @DisplayName("Find record")
    public void testFind(){

    }

    @Test
    @DisplayName("Remove a record")
    public void testRemove(){

    }
}
