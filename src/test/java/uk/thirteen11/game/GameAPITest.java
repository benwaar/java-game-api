package uk.thirteen11.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for GameAPI (1311.uk domain)
 */
class GameAPITest {
    
    @Test
    @DisplayName("Should create GameAPI instance")
    void shouldCreateGameAPIInstance() {
        GameAPI api = new GameAPI();
        assertNotNull(api);
    }
    
    @Test
    @DisplayName("Should return correct version")
    void shouldReturnCorrectVersion() {
        GameAPI api = new GameAPI();
        String version = api.getVersion();
        
        assertEquals("1.0.0-SNAPSHOT", version);
    }
    
    @Test
    @DisplayName("Should return correct domain")
    void shouldReturnCorrectDomain() {
        GameAPI api = new GameAPI();
        String domain = api.getDomain();
        
        assertEquals("1311.uk", domain);
    }
    
    @Test
    @DisplayName("Should start successfully")
    void shouldStartSuccessfully() {
        GameAPI api = new GameAPI();
        
        // This should not throw any exception
        assertDoesNotThrow(() -> api.start());
    }
}