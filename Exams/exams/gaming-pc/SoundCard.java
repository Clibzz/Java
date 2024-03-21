/**
 * A sound card
 *
 * @author Chris Klunder
 * @version 06/04/2023
 */
public class SoundCard {
    private int supportedChannels;
    
    public SoundCard(int supportedChannels) {
        this.supportedChannels = supportedChannels;
    }
    
    public int getSupportedChannels() {
        return this.supportedChannels;
    }
    
    public void setSupportedChannels(int supportedChannels) {
        this.supportedChannels = supportedChannels;
    }
}
