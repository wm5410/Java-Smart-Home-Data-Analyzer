//Student: William Malone
//ID: 1604564
//Student SDS/Test Number 1


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class DataSet {

    private String filepath = "Encost Smart Homes Dataset (small).txt";
    private String dataLine;
    private BufferedReader reader;
    private ArrayList<Device> devices;

    // Constructor
    public DataSet() {
        devices = new ArrayList<>();
    }

    public void createDataSet() {
    try {
        reader = new BufferedReader(new FileReader(filepath));

    // Read each line from the file
    while ((dataLine = reader.readLine()) != null) {
        // Create a new device from the data line
        Device device = new Device(dataLine);
        // Add the device to the list
        devices.add(device);
        System.out.println(dataLine);
    }

    // Close the file
    reader.close();

    } catch (IOException | ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


    }
    
    public void setFileLocation(String filepath) {
        this.filepath = filepath;
    }
    
    public String calculateConnectivity() {
        // Logic to calculate connectivity statistics
        // and return them as a String
        return "Connectivity Statistics";
    }

    public String calculateLocation() {
        // Logic to calculate location statistics
        // and return them as a String
        return "Location Statistics";
    }

    public String calculateDistribution() {
        // Logic to calculate distribution statistics
        // and return them as a String
        return "Distribution Statistics";
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }
}