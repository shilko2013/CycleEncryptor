package primat;

import static primat.CycleEncryptorUtils.log2;

public class CycleEncryptor {

    int numberInfoBits, numberAuxBits, numberBits;
    int distance;

    public CycleEncryptor(int numberBits, int distance) {
        this.numberBits = numberBits;
        this.distance = distance;
        numberAuxBits = (int) Math.ceil(log2(numberBits + 1));
        numberInfoBits = numberBits - numberAuxBits;
    }

    public int decode(int combination) {
        return 0;
    }

}
