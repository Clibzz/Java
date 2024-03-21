/**
 * A game
 *
 * @author Chris Klunder
 * @version 06/04/2023
 */
public class Game {
    private String title;
    private int storageSize;
    private int memorySize;
    
    public Game(String title, int storageSize, int memorySize) {
        this.title = title;
        this.storageSize = storageSize;
        this.memorySize = memorySize;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getStorageSize() {
        return this.storageSize;
    }
    
    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }
    
    public int getMemorySize() {
        return this.memorySize;
    }
    
    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }
}
