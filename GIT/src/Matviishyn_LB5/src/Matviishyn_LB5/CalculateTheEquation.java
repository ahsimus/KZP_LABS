package Matviishyn_LB5;

import java.io.*;
import java.util.Scanner;

public class CalculateTheEquation implements CalculateTheEquationInterface, ReadWriteData {
    private double variable = 0;

    public void WriteAValue()
    {
    	String fileName = "src/bin.bin"; 

        double valueToWrite = 12.3; 

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeDouble(valueToWrite);
            System.out.println("Value written to the binary file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public double doCalculation() {
        try {
            variable = Math.cos(variable)/Math.tan (2*variable);



            return variable;
        } catch (ArithmeticException e){
            System.out.println("Arithmetic exception: illegal value.");
        }
        return 0;
    }

    @Override
    public void writeResultToTxt(String fileName) throws IOException {
        PrintWriter f = new PrintWriter(fileName);
        f.printf("%f ", variable);
        f.close();
    }

    @Override
    public void writeResultToBin(String fileName) throws IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fileName));
        f.writeDouble(variable);
        f.close();
    }

    @Override
    public void readResultFromTxt(String fileName) throws IOException {
        File f = new File (fileName);
        if (f.exists())
        {
            Scanner scanner = new Scanner(f);
            variable = scanner.nextDouble();
            scanner.close();
        }
        else
            throw new IOException("File " + fileName + " not found");
    }

    @Override
    public void readResultFromBin(String fileName) throws IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fileName));
        variable = f.readDouble();
        f.close();
    }
}
