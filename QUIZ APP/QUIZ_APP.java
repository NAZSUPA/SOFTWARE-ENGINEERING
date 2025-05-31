package QUIZ_APP;


import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Arrays;


public class QUIZ_APP {
 static long START_TIME;
    static long MINUTES;
    static long SECONDS;
    static String TIME_OF_QUIZ;
public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        // FIRST TIME CALL name() METHOD
        name();
    }

    public static void name() throws FileNotFoundException, InterruptedException {
        //USER'S NAME PART CONTROL AND GREETING 
        JOptionPane.showMessageDialog(null, "QUIZ APP", "QUIZ APP", 1);
        String NAME = JOptionPane.showInputDialog(null, "CAN I KNOW OUR GUEST'S NAME ?", "IDENTIFICATION", 3);

        if (NAME == null || NAME.isEmpty()) {
            int VALUE_OF_NAME = JOptionPane.showConfirmDialog(null, "PLEASE ENTER YOUR NAME TO CONTINUE THE QUIZ OR DO YOU WANT TO EXIT THE PROGRAM?", "EXIT CONFIRMATION", JOptionPane.YES_NO_OPTION, 3);
            if (VALUE_OF_NAME == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "EXITING THE PROGRAM. I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } else {
                name();
            }
        }
        String GREETING = "NICE TO MEET YOU " + NAME;
        JOptionPane.showMessageDialog(null, GREETING, "QUIZ APP", 1);
        // GO TO TYPE OF QUESTIONS BY CALLING type_of_question() METHOD
        type_of_question();
    }

    @SuppressWarnings("null")
    public static void type_of_question() throws FileNotFoundException, InterruptedException {
        // TYPE OF QUESTION PART CONTROL
        String options[] = {"QUESTION BANK", "MATH GENERATED QUESTIONS"};
        Integer TYPE_OF_QUESTIONS = JOptionPane.showOptionDialog(null, "CHOOSE TYPE OF QUESTION YOU WANT TO HAVE A QUIZ :", "TYPE OF QUESTION", 0, 3, null, options, options[0]);
        if (null == TYPE_OF_QUESTIONS) {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else // AFTER USER INPUT A THING AGAIN CHECK IT AND DECIDE WHAT TO DO
        {
            switch (TYPE_OF_QUESTIONS) {
                case 0 -> // TAKE THE USER TO QUESTION BANK IF HE WRITE 0
                    catagories_or_bank();
                // TAKE THE USER TO MATH GENRATED QUESTIONS IF HE WRITE 1
                case 1 ->
                    math_generated_questions();
                default -> {
                }
            }
        }

    }

    @SuppressWarnings("null")
    public static void catagories_or_bank() throws FileNotFoundException, InterruptedException {
        // TYPE OF QUESTION PART CONTROL
        String options[] = {"MATHAMATICS", "SCIENCE", "PROGRAMMING", "HISTORY", "GENRAL_INFORMATION", "GEOGRAPHY", "ASTRONOMY", "COMPUTER", "EDUCATION", "CULTURE", "ART", "HEALTH", "HUMAN_BODY", "ALL CATEGORIES"};
        Integer TYPE_OF_QUESTIONS = JOptionPane.showOptionDialog(null, "CHOOSE TYPE OF QUESTION YOU WANT TO HAVE A QUIZ :", "TYPE OF QUESTION", 0, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (TYPE_OF_QUESTIONS == null) {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        // AFTER USER INPUT A THING AGAIN CHECK IT AND DECIDE WHAT TO DO 
        switch (TYPE_OF_QUESTIONS) {
            // TAKE THE USER TO HUMAN_BODY_QUESTIONS IF WRITE 0
            case 0 ->
                mathematics();
            // TAKE THE USER TO SCIENCE_QUESTIONS IF WRITE 1
            case 1 ->
                science();
            // TAKE THE USER TO PROGRAMMING_QUESTIONS IF WRITE 2
            case 2 ->
                programming();
            // TAKE THE USER TO HISTORY_QUESTIONS IF WRITE 3
            case 3 ->
                history();
            // TAKE THE USER TO GENERAL_INFORMATION_QUESTIONS IF WRITE 4
            case 4 ->
                general_information();
            // TAKE THE USER TO GEOGRAPHY_QUESTIONS IF WRITE 5
            case 5 ->
                geography();
            // TAKE THE USER TO ASTRONOMY_QUESTIONS IF WRITE 6
            case 6 ->
                astronomy();
            // TAKE THE USER COMPUTER_QUESTIONS IF WRITE 7
            case 7 ->
                computer();
            // TAKE THE USER TO EDUCATION_QUESTIONS IF WRITE 8
            case 8 ->
                education();
            // TAKE THE USER TO CULTURE_QUESTIONS IF WRITE 9
            case 9 ->
                culture();
            // TAKE THE USER ART_QUESTIONS IF WRITE 10
            case 10 ->
                art();
            // TAKE THE USER TO HEALTH_QUESTIONS IF WRITE 11
            case 11 ->
                health();
            // TAKE THE USER TO HUMAN_BODY_QUESTIONS IF WRITE 12
            case 12 ->
                human_body();
            // TAKE THE USER TO QUESTIONS_BANK IF WRITE 13
            case 13 ->
                question_bank();
            default -> {
            }
        }
    }

    public static void question_bank() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/120Q.txt");
        StringBuilder QUESTION_BANK[] = new StringBuilder[120];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER
        for (int i = 0; i < QUESTION_BANK.length; i++) {
            QUESTION_BANK[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                QUESTION_BANK[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {0, 1, 8, 13, 19, 22, 23, 26, 28, 33, 34, 35, 37, 41, 45, 48, 49, 54, 56, 59, 60, 65, 66, 73, 74, 75, 78, 79, 82, 83, 85, 86, 89, 94, 95, 97, 102, 104, 109, 112};
        Integer[] B_INDEX = {6, 7, 9, 11, 14, 16, 18, 20, 21, 24, 25, 27, 29, 30, 32, 34, 42, 43, 47, 50, 51, 52, 53, 58, 62, 64, 67, 68, 69, 71, 80, 87, 88, 91, 100, 105, 106, 107, 110, 11, 113, 114, 115, 116, 119};
        Integer[] C_INDEX = {2, 3, 4, 5, 10, 17, 31, 39, 40, 44, 46, 55, 57, 63, 70, 72, 77, 81, 84, 90, 92, 96, 98, 99, 101, 103, 108, 117};
        Integer[] D_INDEX = {12, 15, 36, 61, 76, 93, 118};
        for (int i = 0; i < USER_ANSWERS.length; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(QUESTION_BANK.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, QUESTION_BANK[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            } else if (Arrays.asList(D_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[3];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void mathematics() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/mathematics.txt");
        StringBuilder[] MATHEMATICS_QUESTIONS = new StringBuilder[8];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < MATHEMATICS_QUESTIONS.length; i++) {
            MATHEMATICS_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                MATHEMATICS_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {0, 1, 2, 5, 6};
        Integer[] B_INDEX = {4, 7};
        Integer[] C_INDEX = {3};
        for (int i = 0; i < MATHEMATICS_QUESTIONS.length - 3; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(MATHEMATICS_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, MATHEMATICS_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void science() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/science.txt");
        StringBuilder[] SCIENCE_QUESTIONS = new StringBuilder[8];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < SCIENCE_QUESTIONS.length; i++) {
            SCIENCE_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                SCIENCE_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {0, 5, 6};
        Integer[] B_INDEX = {1, 2, 4};
        Integer[] C_INDEX = {3, 7};
        for (int i = 0; i < SCIENCE_QUESTIONS.length - 3; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(SCIENCE_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, SCIENCE_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void programming() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/programming.txt");
        StringBuilder[] PROGRAMMING_QUESTIONS = new StringBuilder[9];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < PROGRAMMING_QUESTIONS.length; i++) {
            PROGRAMMING_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                PROGRAMMING_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {2, 3, 4};
        Integer[] B_INDEX = {5, 7, 8};
        Integer[] C_INDEX = {0};
        Integer[] D_INDEX = {1, 6};
        for (int i = 0; i < PROGRAMMING_QUESTIONS.length - 4; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(PROGRAMMING_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, PROGRAMMING_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            } else if (Arrays.asList(D_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[3];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();

    }

    public static void history() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/history.txt");
        StringBuilder[] HISTORY_QUESTIONS = new StringBuilder[6];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < HISTORY_QUESTIONS.length; i++) {
            HISTORY_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                HISTORY_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {7};
        Integer[] B_INDEX = {1, 2, 3, 5};
        Integer[] C_INDEX = {0, 4, 6};
        for (int i = 0; i < HISTORY_QUESTIONS.length - 1; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(HISTORY_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, HISTORY_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void general_information() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/general_information.txt");
        StringBuilder[] GENERAL_INFORMATION_QUESTIONS = new StringBuilder[10];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < GENERAL_INFORMATION_QUESTIONS.length; i++) {
            GENERAL_INFORMATION_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                GENERAL_INFORMATION_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {4, 6, 7};
        Integer[] B_INDEX = {2, 3, 5, 8, 9};
        Integer[] C_INDEX = {0, 1};
        for (int i = 0; i < GENERAL_INFORMATION_QUESTIONS.length - 5; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(GENERAL_INFORMATION_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, GENERAL_INFORMATION_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();

    }

    public static void geography() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/geography.txt");
        StringBuilder[] GEOGRAPHY_QUESTIONS = new StringBuilder[11];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < GEOGRAPHY_QUESTIONS.length; i++) {
            GEOGRAPHY_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                GEOGRAPHY_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {6, 9};
        Integer[] B_INDEX = {1, 8, 10};
        Integer[] C_INDEX = {0, 2, 3, 4, 5, 7};
        for (int i = 0; i < GEOGRAPHY_QUESTIONS.length - 6; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(GEOGRAPHY_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, GEOGRAPHY_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void astronomy() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/astronomy.txt");
        StringBuilder[] ASTRONOMY_QUESTIONS = new StringBuilder[11];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < ASTRONOMY_QUESTIONS.length; i++) {
            ASTRONOMY_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                ASTRONOMY_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {1, 3, 7, 8};
        Integer[] B_INDEX = {0, 2, 4, 5, 9};
        Integer[] C_INDEX = {6};
        Integer[] D_INDEX = {10};
        for (int i = 0; i < ASTRONOMY_QUESTIONS.length - 6; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(ASTRONOMY_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, ASTRONOMY_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            } else if (Arrays.asList(D_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[3];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void computer() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/computer.txt");
        StringBuilder[] COMPUTER_QUESTIONS = new StringBuilder[11];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < COMPUTER_QUESTIONS.length; i++) {
            COMPUTER_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                COMPUTER_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {2, 4, 6};
        Integer[] B_INDEX = {0, 1, 9};
        Integer[] C_INDEX = {3, 5, 7, 8, 10};
        for (int i = 0; i < COMPUTER_QUESTIONS.length - 6; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(COMPUTER_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, COMPUTER_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void education() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/education.txt");
        StringBuilder[] EDUCATION_QUESTIONS = new StringBuilder[11];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < EDUCATION_QUESTIONS.length; i++) {
            EDUCATION_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                EDUCATION_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {0, 2, 4, 5, 6, 8, 9};
        Integer[] B_INDEX = {1, 3, 10};
        Integer[] C_INDEX = {7};
        for (int i = 0; i < EDUCATION_QUESTIONS.length - 6; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(EDUCATION_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, EDUCATION_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void culture() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/culture.txt");
        StringBuilder[] CULTURE_QUESTIONS = new StringBuilder[11];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < CULTURE_QUESTIONS.length; i++) {
            CULTURE_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                CULTURE_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {1, 2, 3, 5};
        Integer[] B_INDEX = {0, 6, 7, 10};
        Integer[] C_INDEX = {8, 9};
        Integer[] D_INDEX = {4};
        for (int i = 0; i < CULTURE_QUESTIONS.length - 6; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(CULTURE_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, CULTURE_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            } else if (Arrays.asList(D_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[3];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void art() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/art.txt");
        StringBuilder[] ART_QUESTIONS = new StringBuilder[7];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < ART_QUESTIONS.length; i++) {
            ART_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                ART_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {1, 3, 5};
        Integer[] B_INDEX = {4, 6};
        Integer[] C_INDEX = {0};
        Integer[] D_INDEX = {2};
        for (int i = 0; i < ART_QUESTIONS.length - 2; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(ART_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, ART_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            } else if (Arrays.asList(D_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[3];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void health() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/health.txt");
        StringBuilder[] HEALTH_QUESTIONS = new StringBuilder[7];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < HEALTH_QUESTIONS.length; i++) {
            HEALTH_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                HEALTH_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] A_INDEX = {2, 6};
        Integer[] B_INDEX = {0, 1, 3};
        Integer[] C_INDEX = {4};
        Integer[] D_INDEX = {5};
        for (int i = 0; i < HEALTH_QUESTIONS.length - 2; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(HEALTH_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, HEALTH_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(A_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[0];
            } else if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            } else if (Arrays.asList(D_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[3];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void human_body() throws FileNotFoundException, InterruptedException {
        START_TIME = System.currentTimeMillis();
        // READING ART FILE FIRST BY SCANNER
        String options[] = {"A", "B", "C", "D"};
        File file = new File("src/file/human_body.txt");
        StringBuilder[] HUMAN_BODY_QUESTIONS = new StringBuilder[7];
        Scanner scan = new Scanner(file);
        // A LOOP TO STORE EVERY 6 LINES LIKE A STRING IN STRINGBUILDER OR IN GENERAL_INFORMATION_QUESTIONS
        for (int i = 0; i < HUMAN_BODY_QUESTIONS.length; i++) {
            HUMAN_BODY_QUESTIONS[i] = new StringBuilder();
            for (int j = 0; j <= 5; j++) {
                String SIX_LINES = scan.nextLine();
                HUMAN_BODY_QUESTIONS[i].append(SIX_LINES).append("\n");
            }
        }
        // // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ 
        Random RANDOM_NUMBER = new Random();
        int CORRECT_ANSWERS_HOLDER = 0;
        int WRONG_ANSWERS_HOLDER = 0;
        String USER_ANSWERS[] = new String[5];
        String CORRECT_ANSWERS[] = new String[5];
        Integer[] B_INDEX = {1, 2, 3, 4};
        Integer[] C_INDEX = {5, 6};
        Integer[] D_INDEX = {0};
        for (int i = 0; i < HUMAN_BODY_QUESTIONS.length - 2; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(HUMAN_BODY_QUESTIONS.length);
            Integer USER_ANSWER = JOptionPane.showOptionDialog(null, HUMAN_BODY_QUESTIONS[RANDOM_INDEX], "MULTIPLE CHOICE QUESTION ", 0, 3, null, options, options[0]);
            if (USER_ANSWER == -1) {
                JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                System.exit(0);
            }
            String USER_CHOICE = options[USER_ANSWER];
            // STORE THE USER'S TEMPORARLY INPUT IN AN ARRAY
            USER_ANSWERS[i] = options[USER_ANSWER];
            if (Arrays.asList(B_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[1];
            } else if (Arrays.asList(C_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[2];
            } else if (Arrays.asList(D_INDEX).contains(RANDOM_INDEX)) {
                CORRECT_ANSWERS[i] = options[3];
            }
            if (USER_CHOICE.equals(CORRECT_ANSWERS[i])) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long END_TIME = System.currentTimeMillis();
        long PERIOD = END_TIME - START_TIME;
        MINUTES = (PERIOD / 1000) / 60;
        SECONDS = (PERIOD / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT THE SCORE BY CORRECT ANSWERS' OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT THE DETAILED RESULT 
        JOptionPane.showMessageDialog(null, ("YOUR ANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + " YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT TAKE ANOTHER QUIZ OR EXIT THE PROGRAM
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        scan.close();
    }

    public static void math_generated_questions() throws InterruptedException, FileNotFoundException {
        START_TIME = System.currentTimeMillis();
        Random RANDOM_NUMBER = new Random();
        int FIRST_RANDOM_NUMBER;
        int SECOND_RANDOM_NUMBER;
        // SOME MATH GENERATED QUESTIONS 
        int RIGH_ANSWER = 0;
        String math_generated_questions[] = new String[5];
        // CHOOSING 5 QUESTIONS RANDOMLY
        int WRONG_ANSWERS_HOLDER = 0;
        int CORRECT_ANSWERS_HOLDER = 0;
        // 2 ARRAYS TO STORE USER'S INPUT AND RIGHT ANSWER OF QUESTION'S FOR EACH NEW SETION
        String USER_ANSWERS[] = new String[5];
        int CORRECT_ANSWERS[] = new int[5];
        // A LOOP TO CHOOSE RANDOM NUMBERS AND QUESTIONS AND FIND THE CORRECT ANSWER AND STORE BOTH USER AND CORRECT ANSWER AND COMPARE THEM WITH EACH OTHER AND CONTROL NUMBER OF CORRECT ANSWER AND WRONG ANSWER OF USER AND COUNT THE TIME OF QUIZ
        for (int i = 0; i < math_generated_questions.length; i++) {
            int RANDOM_INDEX = RANDOM_NUMBER.nextInt(5);
            FIRST_RANDOM_NUMBER = RANDOM_NUMBER.nextInt((5));
            SECOND_RANDOM_NUMBER = RANDOM_NUMBER.nextInt((12) + 6);
            math_generated_questions[0] = FIRST_RANDOM_NUMBER + "+" + SECOND_RANDOM_NUMBER;
            math_generated_questions[1] = FIRST_RANDOM_NUMBER + "*" + SECOND_RANDOM_NUMBER;
            math_generated_questions[2] = SECOND_RANDOM_NUMBER + "-" + FIRST_RANDOM_NUMBER;
            math_generated_questions[3] = SECOND_RANDOM_NUMBER + "^" + FIRST_RANDOM_NUMBER;
            math_generated_questions[4] = FIRST_RANDOM_NUMBER + "%" + SECOND_RANDOM_NUMBER;
            String USER_ANSWER = JOptionPane.showInputDialog(null, (math_generated_questions[RANDOM_INDEX] + " ?"), "MATH GENERATED QUESTIONS", 3);
            while (true) {
                if (USER_ANSWER == null) {
                    JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED", "EXIT THE PROGRAM", 3);
                    System.exit(0);
                }
                USER_ANSWERS[i] = USER_ANSWER;
                if (USER_ANSWER.isEmpty() || !USER_ANSWER.matches("\\d+\\s*")) {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID INPUT THAT IT'S NUMBER");
                    math_generated_questions();
                }
                break;
            }
            Integer user_answer = Integer.valueOf(USER_ANSWER);
            switch (RANDOM_INDEX) {
                case 0 ->
                    RIGH_ANSWER = FIRST_RANDOM_NUMBER + SECOND_RANDOM_NUMBER;
                case 1 ->
                    RIGH_ANSWER = FIRST_RANDOM_NUMBER * SECOND_RANDOM_NUMBER;
                case 2 ->
                    RIGH_ANSWER = SECOND_RANDOM_NUMBER - FIRST_RANDOM_NUMBER;
                case 3 ->
                    RIGH_ANSWER = (int) Math.pow(SECOND_RANDOM_NUMBER, FIRST_RANDOM_NUMBER);
                case 4 ->
                    RIGH_ANSWER = FIRST_RANDOM_NUMBER % SECOND_RANDOM_NUMBER;
                default -> {
                }
            }
            CORRECT_ANSWERS[i] = RIGH_ANSWER;

            if (user_answer == RIGH_ANSWER) {
                CORRECT_ANSWERS_HOLDER++;
            } else {
                WRONG_ANSWERS_HOLDER++;
            }
        }
        long end_time = System.currentTimeMillis();
        long period = end_time - START_TIME;
        MINUTES = (period / 1000) / 60;
        SECONDS = (period / 1000) % 60;
        TIME_OF_QUIZ = MINUTES + ":" + SECONDS;
        // COUNT SCORES BY CORRECT ANSWER OF USER
        byte SCORES = (byte) (CORRECT_ANSWERS_HOLDER * 20);
        // PRINT DETAILED RESULT
        JOptionPane.showMessageDialog(null, ("YOURANSWERS = " + Arrays.toString(USER_ANSWERS) + "  " + " CORRECT ANSWERS = " + Arrays.toString(CORRECT_ANSWERS) + "  " + "\n" + "YOUR WRONG ANSWERS NUMBER = " + WRONG_ANSWERS_HOLDER + "  " + "YOUR CORRECT ANSWERS NUMBER = " + CORRECT_ANSWERS_HOLDER + "\n" + "YOUR SCORE = " + SCORES + " / " + 100 + "  " + "YOUR RESULT : " + (CORRECT_ANSWERS_HOLDER + " / " + 5) + "\n" + "THE TIME YOU TOOK FOR THE QUIZ = " + TIME_OF_QUIZ), "QUIZ RESULT", 1);
        // ASK USER TO KNOW THAT EXIT PROGRAM OR RETAKE ANOTHER QUIZ
        int REAGAIN_QUIZ = JOptionPane.showConfirmDialog(null, "DO YOU WANT OT TAKE ANOTHER QUIZ ?", "REAGAIN QUIZ ?", JOptionPane.YES_NO_OPTION, 3);
        if (REAGAIN_QUIZ == JOptionPane.YES_OPTION) {
            type_of_question();
        } else {
            JOptionPane.showMessageDialog(null, "I HOPE YOU ENJOYED QUIZ APP ", "END OF QUIZ APP", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}
