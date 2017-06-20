/**
 * Created by bunte on 6/18/2017.
 */
public class javaCard {
    private int value;
    private String suit;
    private Boolean faceUp;

    public javaCard(int value, String suit, Boolean faceUp){
        this.value = value;
        this.suit = suit;
        this.faceUp = faceUp;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public Boolean getFaceUp() {
        return faceUp;
    }

    public void setFaceUp(Boolean faceUp) {
        this.faceUp = faceUp;
    }
}
