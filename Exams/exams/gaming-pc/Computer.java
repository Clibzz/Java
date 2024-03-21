import java.util.ArrayList;
import java.util.Iterator;

/**
 * A gaming computer
 *
 * @author Chris Klunder
 * @version 06/04/2023
 */
public class Computer {
    private Motherboard motherboard;
    private ArrayList<Game> games;
    
    public Computer(Motherboard motherboard) {
        this.motherboard = motherboard;
        this.games = new ArrayList<>();
    }
    
    public Motherboard getMotherboard() {
        return this.motherboard;
    }
    
    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }
    
    public ArrayList getGames() {
        return this.games;
    }
    
    private void addGames(Game game) {
        this.games.add(game);
    }
    
    /**
     * Install a game on the computer
     * @param game A game
     */
    public boolean installGame(Game game) {
        Iterator<SSD> ssdIt = motherboard.getSSDs().iterator();
        while(ssdIt.hasNext()) {
            SSD s = ssdIt.next();
            if(game.getStorageSize() <= s.getStorageAmount()) {
                Iterator<GraphicsCard> gcIt = motherboard.getGraphicsCards().iterator();
                while(gcIt.hasNext()) {
                    GraphicsCard gc = gcIt.next();
                    if(game.getMemorySize() <= gc.getMemory()) {
                        s.setStorageAmount(s.getStorageAmount() - game.getStorageSize()); 
                        addGames(game);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Check if the available storage space is less than or equal to 1% of the total storage space
     * @return false Less than or equal to 1% of the total storage space is available
     * @return true More than 1% of the total storage space is available
     */
    public boolean checkStorageSpace() {
        int availableSpace = 0;        
        Iterator<SSD> it = motherboard.getSSDs().iterator();
        while(it.hasNext()) {
            SSD ssd = it.next();
            availableSpace += ssd.getStorageAmount();
        }   
        
        if((availableSpace / this.motherboard.getTotalStorageAmount() * 100) < 2) {
            return false;
        }
        return true;
    }
}
