package encryptdecrypt;

/**
 * A part of the Encrypt-Decrypt project
 *
 * @author fabioanzola
 */
public class Unicode {
    /**
     * Stores the input (String)
     */
    private String userInput;

    /**
     * Stores how much to add (int)
     */
    private int uniAdd;

    /**
     * Stores if encrypt (boolean)
     */
    private boolean enc;

    /**
     * The constructor for this class
     *
     * @param input The input as a String
     * @param shift How much to add as an int
     * @param encrypt If it has to encrypt as a boolean
     */
    public Unicode(String input, int shift, boolean encrypt) {
        setUserInput(input);
        setUniAdd(shift);
        setEnc(encrypt);
    }

    /**
     * Calculates and outputs the encryption/decryption
     *
     * @return the result as a String
     */
    @Override
    public String toString() {
        String out = "";
        if (isEnc()) {
            for (int i = 0; i < getUserInput().length(); i++) {
                out += (char) (((int) getUserInput().charAt(i)) + getUniAdd());
            }
        } else {
            for (int i = 0; i < getUserInput().length(); i++) {
                out += (char) (((int) getUserInput().charAt(i)) - getUniAdd());
            }
        }
        return out;
    }

    /**
     * Gets the input as a String
     *
     * @return The input as a String
     */
    private String getUserInput() {
        return userInput;
    }

    /**
     * Sets the input as a String
     *
     * @param userInput The input as a String
     */
    private void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    /**
     * Get how much to add as an int
     *
     * @return The add as an int
     */
    private int getUniAdd() {
        return uniAdd;
    }

    /**
     * Sets how much to add as an int
     *
     * @param uniAdd The add as an int
     */
    private void setUniAdd(int uniAdd) {
        this.uniAdd = uniAdd;
    }

    /**
     * Checks if it has to encrypt as a boolean
     *
     * @return Encrypt as a boolean
     */
    private boolean isEnc() {
        return enc;
    }

    /**
     * Sets if it has to encrypt as a boolean
     *
     * @param enc Encrypt as a boolean
     */
    private void setEnc(boolean enc) {
        this.enc = enc;
    }
}