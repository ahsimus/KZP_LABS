package Matviishyn.LB2;

/**
 * 
 */

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;
/**
 * 
 */
public class TvApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		try {
            TV tv = new TV(); 
            tv.turnOn();
            tv.displayInfo();
            WaitForEnter();
            tv.changeChannel(3);          
            tv.adjustVolume(10);
            WaitForEnter();
            
            
            tv.turnOff();
            tv.displayInfo();

            tv.dispose();
        } catch (FileNotFoundException e) {
            System.err.println("Could not create TVLog.txt");
        }


	}
	public static void WaitForEnter()
	{
		Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); 
	}
}

