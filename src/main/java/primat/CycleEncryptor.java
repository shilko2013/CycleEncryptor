package primat;

import static java.lang.Math.*;
import static primat.CycleEncryptorUtils.log2;

public class CycleEncryptor {

    int numberInfoBits, numberAuxBits, numberBits;

    final static int POLYNOMIAL[] = {0,
            Integer.parseInt("11", 2),
            Integer.parseInt("111", 2),
            Integer.parseInt("1011", 2),
            Integer.parseInt("10011", 2),
            Integer.parseInt("100101", 2),
            Integer.parseInt("1000011", 2),
            Integer.parseInt("10000011", 2),
            Integer.parseInt("100011011", 2),
            Integer.parseInt("1000000011", 2)
    };


    public CycleEncryptor(int numberBits) {
        this.numberBits = numberBits;
        numberAuxBits = (int) ceil(log2(numberBits + 1));
        numberInfoBits = numberBits - numberAuxBits;
    }

    public int decode(String combination) {
        int count1 = (int) combination.chars().filter(code -> (char) code == '1').count();

        return 0;
    }

}
