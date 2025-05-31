package com.mycompany.boolean_calculator;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class BOOLEAN_CALCULATOR {

    public static void main(String[] args) {
        BOOLEAN_CALCULATOR.INPUT();
    }

    public static void INPUT() {
        Object[] options = new String[]{"DECIMAL", "BINARY", "OCTAL", "HEXADECIMAL"};
        int input = JOptionPane.showOptionDialog(null, "CHOOSE THE TYPE OF INPUT :", "INPUT TYPE", 0, 3, null, options, options[0]);
        switch (input) {
            case 0 -> {
                BOOLEAN_CALCULATOR.DECIMAL();
            }
            case 1 -> {
                BOOLEAN_CALCULATOR.BINARY();
            }
            case 2 -> {
                BOOLEAN_CALCULATOR.OCTAL();
            }
            case 3 -> {
                BOOLEAN_CALCULATOR.HEXADECIMAL();
            }
        }
    }

    public static void DECIMAL() {
        String DECIMAL = JOptionPane.showInputDialog(null, "WRITE THE DECIMAL NUMBER :", "DECIMAL INPUT", 3);
        while (true) {
            if (DECIMAL == null) {
                System.exit(0);
            }
            if (!DECIMAL.isEmpty() && DECIMAL.matches("[0123456789]+")) {
                break;
            }
            JOptionPane.showMessageDialog(null, "INVALID INPUT PLEASE ENTER CORRECT INPUT DATA", "INVALID INPUT", 0);
            DECIMAL();
        }
        int INTEGER_OF_DECIMAL = Integer.parseInt(DECIMAL);
        JOptionPane.showMessageDialog(null, "THE DECIMAL VALUE IS = " + DECIMAL + "\nTHEN : \nTHE BINARY VALUE = " + BOOLEAN_CALCULATOR.DECIMAL_TO_BINARY(INTEGER_OF_DECIMAL) + "\nTHE OCTAL VALUE = " + BOOLEAN_CALCULATOR.DECIMAL_TO_OCTAL(INTEGER_OF_DECIMAL) + "\nTHE HEXADECIMAL VALUE = " + BOOLEAN_CALCULATOR.DECIMAL_TO_HEXADECIMAL(INTEGER_OF_DECIMAL), "RESULT", 1, null);
        BOOLEAN_CALCULATOR.INPUT();
    }

    public static void BINARY() {
        String BINARY = JOptionPane.showInputDialog(null, "WRITE THE BINARY NUMBER :", "BINARY INPUT", 3);
        while (true) {
            if (BINARY == null) {
                System.exit(0);
            }
            if (!BINARY.isEmpty() && BINARY.matches("[01]+")) {
                break;
            }
            JOptionPane.showMessageDialog(null, "INVALID INPUT PLEASE ENTER CORRECT INPUT DATA", "INVALID INPUT", 0);
            BINARY();
        }
        int BINARY_TO_DECIMAL = 0;
        int WEIGHT = 1;
        int i = BINARY.length() - 1;
        while (i >= 0) {
            if (BINARY.charAt(i) == '1') {
                BINARY_TO_DECIMAL += WEIGHT;
            }
            WEIGHT *= 2;
            --i;
        }
        JOptionPane.showMessageDialog(null, "THE BINARY VALUE IS = " + BINARY + "\nTHEN : \nTHE DECIMAL VALUE = " + BINARY_TO_DECIMAL + "\nTHE OCTAL VALUE = " + BOOLEAN_CALCULATOR.DECIMAL_TO_OCTAL(BINARY_TO_DECIMAL) + "\nTHE HEXADECIMAL VALUE = " + BOOLEAN_CALCULATOR.DECIMAL_TO_HEXADECIMAL(BINARY_TO_DECIMAL), "RESULT", 1, null);
        BOOLEAN_CALCULATOR.INPUT();
    }

    public static void OCTAL() {
        String OCTAL = JOptionPane.showInputDialog(null, "WRITE THE OCTAL NUMBER :", "OCTAL INPUT", 3);
        while (true) {
            if (OCTAL == null) {
                System.exit(0);
            }
            if (!OCTAL.isEmpty() && OCTAL.matches("[01234567]+")) {
                break;
            }
            JOptionPane.showMessageDialog(null, "INVALID INPUT PLEASE ENTER CORRECT INPUT DATA", "INVALID INPUT", 0);
            OCTAL();
        }
        int WEIGHT = 1;
        int RESULT = 0;
        int i = OCTAL.length() - 1;
        while (i >= 0) {
            int OCTAL_INTEGER = OCTAL.charAt(i) - 48;
            RESULT += OCTAL_INTEGER * WEIGHT;
            WEIGHT *= 8;
            --i;
        }
        JOptionPane.showMessageDialog(null, "THE OCTAL VALUE IS = " + OCTAL + "\nTHEN : \nTHE DECIMAL VALUE = " + RESULT + "\nTHE BINARY VALUE = " + BOOLEAN_CALCULATOR.DECIMAL_TO_BINARY(RESULT) + "\nTHE HEXADECIMAL VALUE = " + BOOLEAN_CALCULATOR.DECIMAL_TO_HEXADECIMAL(RESULT), "RESULT", 1, null);
        BOOLEAN_CALCULATOR.INPUT();
    }

    public static void HEXADECIMAL() {
        String HEXADECIMAL = JOptionPane.showInputDialog(null, "WRITE THE HEXADECIMAL NUMBER :", "HEXADECIMAL INPUT", 3);
        while (true) {
            if (HEXADECIMAL == null) {
                System.exit(0);
            }
            if (!HEXADECIMAL.isEmpty() && HEXADECIMAL.matches("[0123456789ABCDEF]+")) {
                break;
            }
            JOptionPane.showMessageDialog(null, "INVALID INPUT PLEASE ENTER CORRECT INPUT DATA", "INVALID INPUT", 0);
            HEXADECIMAL();
        }
        String CAPITAL_HEXADECIMAL = HEXADECIMAL.toUpperCase();
        char[] LETTERS = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        int[] NUMBERS = new int[]{10, 11, 12, 13, 14, 15};
        int VALUE = 0;
        int WEIGHT_OF_HEXADECIMAL = 1;
        int RESULT_OF_DECIMAL = 0;
        int TEST = 0;
        int i = HEXADECIMAL.length() - 1;
        while (i >= 0) {
            Character UNKNOWN = Character.valueOf(CAPITAL_HEXADECIMAL.charAt(i));
            int L = 0;
            while (L < 6) {
                if (UNKNOWN.equals(Character.valueOf(LETTERS[L])) && (VALUE = NUMBERS[L]) > 0) {
                    ++TEST;
                }
                ++L;
            }
            if (TEST == 0) {
                VALUE = UNKNOWN.charValue() - 48;
            }
            RESULT_OF_DECIMAL += VALUE * WEIGHT_OF_HEXADECIMAL;
            WEIGHT_OF_HEXADECIMAL *= 16;
            --TEST;
            --i;
        }
        JOptionPane.showMessageDialog(null, "THE HEXADECIMAL VALUE IS = " + CAPITAL_HEXADECIMAL + "\nTHEN : \nTHE DECIMAL VALUE = " + RESULT_OF_DECIMAL + "\nTHE BINARY VALUE = " + BOOLEAN_CALCULATOR.DECIMAL_TO_BINARY(RESULT_OF_DECIMAL) + "\nTHE OCTAL VALUE = " + BOOLEAN_CALCULATOR.DECIMAL_TO_OCTAL(RESULT_OF_DECIMAL), "RESULT", 1, null);
        BOOLEAN_CALCULATOR.INPUT();
    }

    public static String DECIMAL_TO_BINARY(int DECIMAL) {
        int QOUTIENT;
        ArrayList<Integer> BINARY = new ArrayList<Integer>();
        double USER_DOUBLE = DECIMAL;
        do {
            double REMAINDER = USER_DOUBLE / 2.0;
            QOUTIENT = (int) REMAINDER;
            double BIT = REMAINDER - (double) QOUTIENT;
            double BITS = BIT * 2.0;
            int RESULT = (int) BITS;
            BINARY.add(RESULT);
            USER_DOUBLE = QOUTIENT;
        } while (QOUTIENT != 0);
        Object BINARY_VALUE = "";
        Iterator BITS = BINARY.iterator();
        while (BITS.hasNext()) {
            int VALUES = (Integer) BITS.next();
            BINARY_VALUE = (String) BINARY_VALUE + VALUES;
        }
        String LAST_VALUE_BINARY = "";
        int i = ((String) BINARY_VALUE).length() - 1;
        while (i >= 0) {
            LAST_VALUE_BINARY = (String) LAST_VALUE_BINARY + ((String) BINARY_VALUE).charAt(i);
            --i;
        }
        return LAST_VALUE_BINARY;
    }

    public static String DECIMAL_TO_OCTAL(int DECIMAL) {
        int QOUTIENT_OCTAL;
        ArrayList<Integer> OCTAL_VALUES = new ArrayList<Integer>();
        double USER_DOUBLE_OCTAL = DECIMAL;
        do {
            double REMAINDER_OCTAL = USER_DOUBLE_OCTAL / 8.0;
            QOUTIENT_OCTAL = (int) REMAINDER_OCTAL;
            double BIT = REMAINDER_OCTAL - (double) QOUTIENT_OCTAL;
            double BITS = BIT * 8.0;
            int RESULT = (int) BITS;
            OCTAL_VALUES.add(RESULT);
            USER_DOUBLE_OCTAL = QOUTIENT_OCTAL;
        } while (QOUTIENT_OCTAL != 0);
        Object OCTAL_VALUE = "";
        Iterator BITS = OCTAL_VALUES.iterator();
        while (BITS.hasNext()) {
            int VALUES = (Integer) BITS.next();
            OCTAL_VALUE = (String) OCTAL_VALUE + VALUES;
        }
        String LAST_OCTAL_VALUE = "";
        int i = ((String) OCTAL_VALUE).length() - 1;
        while (i >= 0) {
            LAST_OCTAL_VALUE = (String) LAST_OCTAL_VALUE + ((String) OCTAL_VALUE).charAt(i);
            --i;
        }
        return LAST_OCTAL_VALUE;
    }

    public static String DECIMAL_TO_HEXADECIMAL(int DECIMAL) {
        int QOUTIENT_HEXADECIMAL;
        Object HEXADECIMAL = "";
        double USER_DOUBLE_HEXADECIMAL = DECIMAL;
        char[] LETTERS = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        int[] NUMBERS = new int[]{10, 11, 12, 13, 14, 15};
        do {
            double REMAINDER_HEXADECIMAL;
            double BIT;
            double BITS;
            int RESULT;
            if ((RESULT = (int) (BITS = (BIT = (REMAINDER_HEXADECIMAL = USER_DOUBLE_HEXADECIMAL / 16.0) - (double) (QOUTIENT_HEXADECIMAL = (int) REMAINDER_HEXADECIMAL)) * 16.0)) <= 9) {
                HEXADECIMAL = (String) HEXADECIMAL + RESULT;
            } else {
                int i = 0;
                while (i <= 5) {
                    if (NUMBERS[i] == RESULT) {
                        HEXADECIMAL = (String) HEXADECIMAL + LETTERS[i];
                    }
                    ++i;
                }
            }
            USER_DOUBLE_HEXADECIMAL = QOUTIENT_HEXADECIMAL;
        } while (QOUTIENT_HEXADECIMAL != 0);
        String LAST_HEXADECIMAL_VALUE = "";
        int i = ((String) HEXADECIMAL).length() - 1;
        while (i >= 0) {
            LAST_HEXADECIMAL_VALUE = (String) LAST_HEXADECIMAL_VALUE + ((String) HEXADECIMAL).charAt(i);
            --i;
        }
        return LAST_HEXADECIMAL_VALUE;
    }
}
