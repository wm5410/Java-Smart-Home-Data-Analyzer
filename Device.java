//Student: William Malone
//ID: 1604564 
//Student SDS/Test Number 1

import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Device {

    String deviceID;
    Date dateConnected;
    String name;
    String deviceType;
    String houseID;
    String routerConnection;
    boolean sends;
    boolean receives;
    String category;

    public Device(String dataLine) throws ParseException {
        // Split the data line into individual components
        String[] components = dataLine.split(",");
        
        this.deviceID = components[0];
        DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
        this.dateConnected = formatter.parse(components[1]);
        this.name = components[2];
        this.deviceType = components[3];
        this.houseID = components[4];
        this.routerConnection = components[5];
        this.sends = Boolean.parseBoolean(components[6]);
        this.receives = Boolean.parseBoolean(components[7]);
        // this.category = components[8];
    }

    // Getter methods
    public String getDeviceID() {
        return deviceID;
    }

    public Date getDateConnected() {
        return dateConnected;
    }

    public String getName() {
        return name;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getHouseID() {
        return houseID;
    }

    public String getRouterConnection() {
        return routerConnection;
    }

    public boolean getSends() {
        return sends;
    }

    public boolean getReceives() {
        return receives;
    }

    public String getCategory() {
        return category;
    }
}