package lvc.cds;

import static org.mockito.Mockito.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Interface{
    DB database;
    Scanner scanner = new Scanner(System.in);

    static Logger l = LogManager.getRootLogger();
    static DB d = mock(DB.class);

    public static void main(String[] args) {

        while(true){
            Interface tester = new Interface();
            int command = tester.welcome();
            if(command == 0)
                break;
            tester.action(command);
        }
    }

    public Interface(){
        setDatabase(d);
    }


    public boolean action(int command){
        l.debug("In action");
        if(command==1){
            System.out.println("Insert the name of the record you are trying to add: ");
            scanner.nextLine();
            String name = scanner.nextLine();

            System.out.println("Insert the phone number of the record you are trying to add: ");
            String number = scanner.nextLine();
            when(d.add(name,number)).thenReturn(true);
            boolean check = d.add(name, number);
            if (check){
                l.debug("Add was successfull. Added record.");
                return true;
            } else{
                l.warn("Add was not successfull.");
            }
        } else if(command==2){
            System.out.println("Insert the name of the record you are trying to delete: ");
            scanner.nextLine();
            String name = scanner.nextLine();

            when(d.remove(name)).thenReturn(true);
            boolean check = d.remove(name);
            if (check){
                System.out.println("Remove was successfull. Record has been removed.");
                return true;
            } else{
                System.out.println("Remove was not successfull. Record has not been removed.");
            }
        } else if (command ==3){
            System.out.println("Insert the name of the phone number you are trying to find: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            // when(d.find(name)).thenReturn("330-555-4444");
            String phoneNumber = d.find(name);
            if(phoneNumber.equals(null)) {
                l.warn("Record was not found");
                return true;
            } else {
                l.debug("Record has been found.");
                System.out.println(phoneNumber);
            }
        }

        return false;
    }

    public int welcome(){
        l.debug("Entered welcome method");
        System.out.println(
            "Hello,\nTo add someone to the database press 1.\nTo remove someone from the database press 2.\nTo find someone within the database press 3\nTo exit, press 0");
        int command = scanner.nextInt();
        l.debug("Welcome method has been called. Returning command");
        return command;
    }

    public void setDatabase(DB database){
        this.database=database;
    }
}