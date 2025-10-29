package uk.thirteen11.game;

/**
 * Main application class for the Java Game API
 * Domain: 1311.uk
 */
public class GameAPI {
    
    public static void main(String[] args) {
        System.out.println("Java Game API (1311.uk) - Running on Java " + 
                          System.getProperty("java.version"));
        
        GameAPI api = new GameAPI();
        api.start();
    }
    
    /**
     * Starts the game API
     */
    public void start() {
        System.out.println("1311.uk Game API started successfully!");
        System.out.println("Ready to build amazing games with Java 17 features!");
    }
    
    /**
     * Gets the API version
     * @return the current API version
     */
    public String getVersion() {
        return "1.0.0-SNAPSHOT";
    }
    
    /**
     * Gets the domain information
     * @return the domain this API serves
     */
    public String getDomain() {
        return "1311.uk";
    }
}