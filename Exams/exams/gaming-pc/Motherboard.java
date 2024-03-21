import java.util.ArrayList;

/**
 * A Motherboard
 *
 * @author Chris Klunder
 * @version 06/04/2023
 */
public class Motherboard {
    private int slotAmount;
    private ArrayList<GraphicsCard> graphicsCards;
    private ArrayList<SSD> sSDs;
    private ArrayList<SoundCard> soundCards;
    private int totalStorageAmount;
    
    public Motherboard(int slotAmount) {
        this.slotAmount = slotAmount;
        this.graphicsCards = new ArrayList<>();
        this.sSDs = new ArrayList<>();
        this.soundCards = new ArrayList<>();
        this.totalStorageAmount = 0;
    }
    
    public int getSlotAmount() {
        return this.slotAmount;
    }
    
    public ArrayList getGraphicsCards() {
        return this.graphicsCards;
    }
    
    /**
     * Add a graphicscard to the system
     * @param graphicsCard A graphics card
     */
    public boolean addGraphicsCards(GraphicsCard graphicsCard) {
        if (this.slotAmount >= 3) {
            this.graphicsCards.add(graphicsCard);
            this.slotAmount -= 3;
            return true;
        }
        return false;
    }
    
    public ArrayList getSSDs() {
        return this.sSDs;
    }
    
    /**
     * Add a SSD to the system, check the storage space of the SSD to determine how many slots are needed
     * @param ssd A SSD
     */
    public boolean addSSDs(SSD ssd) {
        if(ssd.getStorageAmount() > 2048) {
            if(this.slotAmount >= 2) {
                this.sSDs.add(ssd);
                this.slotAmount -= 2;
                setTotalStorageAmount(ssd.getStorageAmount());
                return true;
            }
        } else {
            if(this.slotAmount >= 1) {
                this.sSDs.add(ssd);
                this.slotAmount -= 1;
                setTotalStorageAmount(ssd.getStorageAmount());
                return true;
            }
        }
        return false;
    }
    
    public ArrayList getSoundCards() {
        return this.soundCards;
    }
    
    /**
     * Add a sound card to the system
     * @param soundCard A sound card
     */
    public boolean addSoundCards(SoundCard soundCard) {
        if (this.slotAmount >= 1) {
            this.soundCards.add(soundCard);
            this.slotAmount -= 1;
            return true;
        }
        return false;
    }
    
    public int getTotalStorageAmount() {
        return this.totalStorageAmount;
    }
    
    private void setTotalStorageAmount(int storageAmount) {
        this.totalStorageAmount = totalStorageAmount + storageAmount;
    }
}
