/**
 * A graphics card
 *
 * @author Chris Klunder
 * @version 06/04/2023
 */
public class GraphicsCard {
    private int ghz;
    private int memory;
    
    public GraphicsCard(int ghz, int memory) {
        this.ghz = ghz;
        this.memory = memory;
    }
    
    public int getGhz() {
        return this.ghz;
    }
    
    public void setGhz(int ghz) {
        this.ghz = ghz;
    }
    
    public int getMemory() {
        return this.memory;
    }
    
    public void setMemory(int memory) {
        this.memory = memory;
    }
}
