/**
 * A Solid State Drive (SSD)
 *
 * @author Chris Klunder
 * @version 06/04/2023
 */
public class SSD {
    private int storageAmount; //in MBs
    
    public SSD(int storageAmount) {
        this.storageAmount = storageAmount;
    }
    
    public int getStorageAmount() {
        return this.storageAmount;
    }
    
    public void setStorageAmount(int storageAmount) {
        this.storageAmount = storageAmount;
    }
}
