package encryptdecrypt;

/**
 * A part of the Encrypt-Decrypt project
 *
 * @author fabioanzola
 */
public class Shift {
    /**
     * Stores the input (String)
     */
    private String userInput;

    /**
     * Stores how much to shift (int)
     */
    private int shiftWidth;

    /**
     * Stores if encrypt (boolean)
     */
    private boolean enc;

    /**
     * The constructor for this class
     *
     * @param input The input as a String
     * @param shift How much to shift as an int
     * @param encrypt If it has to encrypt as a boolean
     */
    public Shift(String input, int shift, boolean encrypt) {
        setUserInput(input);
        setShiftWidth(shift);
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
        String resourceSmall = "abcdefghijklmnopqrstuvwxyz";
        String resourceBig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if (isEnc()) {
            for (int i = 0; i < getUserInput().length(); i++) {
                if (resourceSmall.contains("" + getUserInput().charAt(i))) {
                    for (int j = 0; j < resourceSmall.length(); j++) {
                        if (getUserInput().charAt(i) == resourceSmall.charAt(j)) {
                            int k = j + getShiftWidth();
                            if ((k) >= resourceSmall.length()) {
                                out += resourceSmall.charAt(k - resourceSmall.length());
                            } else {
                                out += resourceSmall.charAt(k);
                            }
                            break;
                        }
                    }
                } else if (resourceBig.contains("" + getUserInput().charAt(i))) {
                    for (int j = 0; j < resourceBig.length(); j++) {
                        if (getUserInput().charAt(i) == resourceBig.charAt(j)) {
                            int k = j + getShiftWidth();
                            if ((k) >= resourceBig.length()) {
                                out += resourceBig.charAt(k - resourceBig.length());
                            } else {
                                out += resourceBig.charAt(k);
                            }
                            break;
                        }
                    }
                } else {
                    out += getUserInput().charAt(i);
                }

            }
        } else {
            for (int i = 0; i < getUserInput().length(); i++) {
                if (resourceSmall.contains("" + getUserInput().charAt(i))) {
                    for (int j = 0; j < resourceSmall.length(); j++) {
                        if (getUserInput().charAt(i) == resourceSmall.charAt(j)) {
                            int k = j - getShiftWidth();
                            if ((k) < 0) {
                                out += resourceSmall.charAt(k + resourceSmall.length());
                            } else {
                                out += resourceSmall.charAt(k);
                            }
                            break;
                        }
                    }
                } else if (resourceBig.contains("" + getUserInput().charAt(i))) {
                    for (int j = 0; j < resourceBig.length(); j++) {
                        if (getUserInput().charAt(i) == resourceBig.charAt(j)) {
                            int k = j - getShiftWidth();
                            if ((k) <= 0) {
                                out += resourceBig.charAt(k + resourceBig.length());
                            } else {
                                out += resourceBig.charAt(k);
                            }
                            break;
                        }
                    }
                } else {
                    out += getUserInput().charAt(i);
                }

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
     * Get how much to shift as an int
     *
     * @return The shift as an int
     */
    private int getShiftWidth() {
        return shiftWidth;
    }

    /**
     * Sets how much to shift as an int
     *
     * @param shiftWidth The shift as an int
     */
    private void setShiftWidth(int shiftWidth) {
        this.shiftWidth = shiftWidth;
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