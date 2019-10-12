package primat;

import static java.lang.Math.*;
import static primat.CycleEncryptorUtils.log2;

public class CycleEncryptor {

    int numberInfoBits, numberAuxBits, numberBits;

    final static int POLYNOMIAL[] = {0,
            0b11,
            0b111,
            0b1011,
            0b10011,
            0b100101,
            0b1000011,
            0b10000011,
            0b1000000011
    };


    public CycleEncryptor(int numberBits) {
        this.numberBits = numberBits;
        numberAuxBits = (int) ceil(log2(numberBits + 1));
        numberInfoBits = numberBits - numberAuxBits;
    }

    public String decode(String combination) {
        int polynomial = POLYNOMIAL[numberAuxBits];
        int numberCombination = Integer.parseInt(combination, 2);
        int remainder = numberCombination % polynomial;
        int countShift;
        for (countShift = 0; remainder > 1; ++countShift) {
            numberCombination = leftShift(numberCombination);
            remainder = numberCombination % polynomial;
            if (countShift > combination.length())
                throw new IllegalArgumentException("Too many errors in one message!");
        }
        numberCombination = numberCombination ^ remainder;
        while (countShift > 0) {
            numberCombination = rightShift(numberCombination);
            --countShift;
        }
        return toBinaryString(numberCombination / polynomial);
    }

    private String toBinaryString(int value) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberInfoBits; ++i) {
            stringBuilder.append(value % 2);
            value /= 2;
        }
        return stringBuilder.reverse().toString();
    }

    private int leftShift(int combination) {
        if ((combination & (1 << (numberBits - 1))) != 0)
            return (combination << 1) % (1 << numberBits) | 1;
        return  combination << 1;
    }

    private int rightShift(int combination) {
        if (combination % 2 != 0)
            return (combination >> 1) | (1 << (numberBits - 1));
        return  combination >> 1;
    }

}
