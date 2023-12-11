

	package Matviishyn.LB2;

	import java.io.*;

	public class TV {
	    private Screen screen;
	    private String[] channels;
	    private int currentChannel;
	    private int currentVolume;
	    private PrintWriter fout;

	    public TV() throws FileNotFoundException {
	        screen = new Screen();
	        this.channels = new String[]{
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
	        currentVolume = 50;

	        try {
	            fout = new PrintWriter(new File("TVLog.txt"));
	        } catch (FileNotFoundException e) {
	            System.err.println("Could not create TVLog.txt");
	        }
	    }

	    public void changeChannel(int newChannel) {
	        if (newChannel >= 0 && newChannel < channels.length) {
	            currentChannel = newChannel;
	            System.out.println("Channel is changed");
	            getCurrentChannel();
	        } else {
	            System.out.println("Invalid channel number");
	        }
	    }

	    public void adjustVolume(int delta) {
	        currentVolume += delta;
	        if (currentVolume < 0) {
	            currentVolume = 0;
	        } else if (currentVolume > 100) {
	            currentVolume = 100;
	        }
	        System.out.println("volume is changed");
	        getCurrentVolume();
	    }

	    public String getCurrentChannel() {
	    	String currentChannelName = channels[currentChannel];
	        System.out.println("Current channel: " + currentChannelName);
	        return currentChannelName;
	    }

	    public int getCurrentVolume() {
	    	 System.out.println("Current volume: " + currentVolume);
	         return currentVolume;
	    }

	    public void turnOn() {
	        screen.turnOn();
	    }

	    public void turnOff() {
	        screen.turnOff();
	    }

	    public void displayInfo() {
	        System.out.println("TV is " + (screen.isOn() ? "on" : "off"));
	        getCurrentChannel(); 
	        getCurrentVolume();  
	    }

	    public void dispose() {
	        if (fout != null) {
	            fout.close();
	        }
	    }
	}

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
