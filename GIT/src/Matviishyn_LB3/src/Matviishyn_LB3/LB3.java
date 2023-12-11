package Matviishyn_LB3;
import java.io.*;

// Інтерфейс для відображення інформації
public interface LB3 {
    void displayInfo();
}

// Абстрактний клас електронного пристрою
abstract class ElectronicDevice implements LB3 {
    private boolean isOn;

    public ElectronicDevice() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public abstract void displayInfo();

    public abstract void dispose();
}

// Клас екрану
class Screen {
    private boolean isOn;

    public Screen() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }
}

// Клас тюнера
class Tuner extends ElectronicDevice {
    private String[] tvChannels;
    private int currentChannel;

    public Tuner() {
        tvChannels = new String[]{
        		"1+1",
                "National Geographic",
                "Novyy",
                "Films",
                "HBO",
                "BBC News",
                "Cartoon Network",
                "History Channel",
                "Food Network",
                "Netflix"

        };
        currentChannel = 0;
    }

    public void changeChannel(int newChannel) {
        if (newChannel >= 0 && newChannel < tvChannels.length) {
            currentChannel = newChannel;
            System.out.println("TV channel is changed");
            getCurrentChannel();
        } else {
            System.out.println("Invalid channel number");
        }
    }

    public String getCurrentChannel() {
        String currentChannelName = tvChannels[currentChannel];
        System.out.println("Current TV channel: " + currentChannelName);
        return currentChannelName;
    }

    @Override
    public void displayInfo() {
        System.out.println("Tuner is " + (isOn() ? "on" : "off"));
        getCurrentChannel();
    }

    @Override
    public void dispose() {
        System.out.println("Tuner is being disposed.");
    }
}

// Клас телевізора
 class TV extends ElectronicDevice {
    private Screen screen;
    private Tuner tuner;
    private int currentVolume;
    private PrintWriter fout;

    public TV() throws FileNotFoundException {
        screen = new Screen();
        tuner = new Tuner();
        currentVolume = 50;

        try {
            fout = new PrintWriter(new File("TVLog.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Could not create TVLog.txt");
        }
    }

    public void changeChannel(int newChannel) {
        tuner.changeChannel(newChannel);
        System.out.println("Channel is changed");  
    }

    public void adjustVolume(int delta) {
        currentVolume += delta;
        if (currentVolume < 0) {
            currentVolume = 0;
        } else if (currentVolume > 100) {
            currentVolume = 100;
        }
        System.out.println("Volume is changed");
        getCurrentVolume();
    }

    public int getCurrentVolume() {
        System.out.println("Current volume: " + currentVolume);
        return currentVolume;
    }

    @Override
    public void displayInfo() {
        System.out.println("TV is " + (isOn() ? "on" : "off"));
        tuner.displayInfo();
    }

    @Override
    public void dispose() {
        tuner.dispose();
        if (fout != null) {
            fout.close();
        }
    }

   
}
