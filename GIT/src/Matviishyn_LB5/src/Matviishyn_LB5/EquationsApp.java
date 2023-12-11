package Matviishyn_LB5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EquationsApp {
    public static void main(String[] args) {
        CalculateTheEquation calc = new CalculateTheEquation();
        calc.WriteAValue();
        try {
            calc.readResultFromBin("src/bin.bin");
            System.out.println("Result of calculation: " + calc.doCalculation());
            calc.writeResultToBin("src/bin.bin");
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            calc.readResultFromTxt("src/txt.txt");
            System.out.println("Result of calculation: " + calc.doCalculation());
            calc.writeResultToTxt("src/txt.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
