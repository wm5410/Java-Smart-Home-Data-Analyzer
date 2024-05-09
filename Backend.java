//Student: William Malone
//ID: 1604564
//Student SDS/Test Number 1

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class Backend {
    private Map<String, String> database;
    private String userType;

    public static void main(String[] args) {
        Backend program = new Backend();
        program.welcomePrompt();
    }

    public void welcomePrompt() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select user type: ");
            // Convert input to lowercase and take the first character
            char userInput = scanner.next().toLowerCase().charAt(0); 
            
            if (userInput == 'a') {
                //No need for checking
                userType = "community";
                esgpOptionsPrompt(userType);
            } else if (userInput == 'b') {
                // Check user credentials
                loginPrompt();
            } else {
                userType = "invalid";
                System.out.println("Invalid Input");
            }
            scanner.close();
        }

    public void loginPrompt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
    
        // Validate username and password
        if (validateUser(username, password)) {
            userType = "encost-verified";
            System.out.println("Welcome " + username);
            esgpOptionsPrompt(userType);
        } else {
            userType = "invalid";
            System.out.println("Invalid username or password. Please try again.");
        }
        scanner.close();
    }
    
    private boolean validateUser(String username, String password) {
        // Read users from the file and store them in a map for easy comparison
        Map<String, String> users = readUsersFromFile("users.txt");
        // Check if the entered username exists in the map and if its corresponding password matches
        return users.containsKey(username) && users.get(username).equals(password);
    }
    
    private Map<String, String> readUsersFromFile(String filename) {
        Map<String, String> users = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void esgpOptionsPrompt(String userType) {
        System.out.println("ESGP Feature Options \n");
        if(userType == "encost-verified")
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option:");
            System.out.println("a) Load a custom dataset");
            System.out.println("b) Visualise a graph representation of the data");
            System.out.println("c) View summary statistics");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("a")) {
                System.out.println("Enter full path of custom dataset:");
            } else if (option.equalsIgnoreCase("b")) {
                System.out.println("Graph data visualisation open in new window");
            } else if (option.equalsIgnoreCase("c")) {
                System.out.println("==> Summary Statistics <==");
            } else {
                System.out.println("Invalid Input");
            }

            scanner.close();
        }
        else if(userType == "community")
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option: ");
            System.out.println("a) Visualise a graph representation of the data");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("a")) {
                
            }
            else{
                System.out.println("Invalid Input");
            }

            scanner.close();
        }
        else{
            System.out.println("Error");
        }
    }
    
    public void displayGraph() {

    }

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

    


}


