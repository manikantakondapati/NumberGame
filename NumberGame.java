import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

import java.util.Random;



/**

 * 

 *

 * @version  : 1.0

 */



public class NumberGame {

    private static String HIGHER = "higher";

    private static String LOWER = "lower";

    private static String YES = "yes";

    private static String NO = "no";



    private static int randomNumber = 0;

    public static int getRandomNumber() {
		return randomNumber;
	}



	public static void setRandomNumber(int randomNumber) {
		NumberGame.randomNumber = randomNumber;
	}



	public static int getCurrentNumber() {
		return currentNumber;
	}



	public static void setCurrentNumber(int currentNumber) {
		NumberGame.currentNumber = currentNumber;
	}



	public static int getPrevious() {
		return previous;
	}



	public static void setPrevious(int previous) {
		NumberGame.previous = previous;
	}



	private static int currentNumber = 0;

    private static int previous = 0;

    public static void main(String[] args) {

        String input = null;

        int count = 0;

        int higherCount = 0;

        int lowerCount = 0;

        int maxSize = 0;

        int minSize = 0;

        InputStreamReader inputReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputReader);

        List<Integer> higherInputs = new ArrayList<Integer>();

        List<Integer> lowerInputs = new ArrayList<Integer>();

        System.out.println("**********Welcome to Number Game**********");

        try {

            System.out.println("Choose any of your Favorite number between 1 and 100");

            System.out.println("Press Any key to Start the game");

            String anyKey = bufferedReader.readLine();

            NumberGame numberGameClass = new NumberGame();

            randomNumber = numberGameClass.getRandomNumberInRange(0, 100);

            currentNumber = randomNumber;

            System.out.println("Your Number is : " + String.valueOf(randomNumber));

            printMessage();

            input = bufferedReader.readLine();

            while (input != null) {

                count++;

                if (HIGHER.equalsIgnoreCase(input) || LOWER.equalsIgnoreCase(input) || YES.equalsIgnoreCase(input)) {

                    if (HIGHER.equalsIgnoreCase(input)) {

                        higherCount++;

                        if (higherCount == count) {

                            higherInputs.add(currentNumber);

                            randomNumber = numberGameClass.getRandomNumberInRange(currentNumber, 100);

                            currentNumber = randomNumber;

                        }

                        else {

                            higherInputs.add(currentNumber);

                            Collections.sort(higherInputs);

                            maxSize = lowerInputs.size();

                            minSize = higherInputs.size();

                          //  System.out.println("Higher Minimum: " + higherInputs.get(minSize - 1) + " Maximum size :" + lowerInputs.get(maxSize - 1));

                            randomNumber = numberGameClass.getRandomNumberInRange(higherInputs.get(minSize - 1), lowerInputs.get(maxSize - 1));

                            currentNumber = randomNumber;

                        }

                        System.out.println("Your Number is : " + String.valueOf(randomNumber));

                        printMessage();

                    }

                    else if (LOWER.equalsIgnoreCase(input)) {

                        lowerCount++;

                        if (lowerCount == count) {

                            lowerInputs.add(currentNumber);

                            randomNumber = numberGameClass.getRandomNumberInRange(0, currentNumber);

                            currentNumber = randomNumber;

                        }

                        else {

                            lowerInputs.add(currentNumber);

                            Collections.sort(lowerInputs);

                            Collections.reverse(lowerInputs);

                            maxSize = lowerInputs.size();

                            minSize = higherInputs.size();

                         //   System.out.println("Lower Minimum: " + higherInputs.get(minSize - 1) + " Maximum size :" + lowerInputs.get(maxSize - 1));

                            randomNumber = numberGameClass.getRandomNumberInRange(higherInputs.get(minSize - 1), lowerInputs.get(maxSize - 1));

                            currentNumber = randomNumber;

                        }

                        System.out.println("Your Number is : " + String.valueOf(randomNumber));

                        printMessage();



                    }

                    else if (YES.equalsIgnoreCase(input)) {

                        System.out.println("Do you want to try one more time ? Yes or No");

                        input = bufferedReader.readLine();

                        if ("YES".equalsIgnoreCase(input)) {

                            currentNumber = 0;

                            randomNumber = 0;

                            count = 0;

                            higherCount = 0;

                            lowerCount = 0;

                            maxSize = 0;

                            minSize = 0;

                            lowerInputs.clear();

                            higherInputs.clear();



                            System.out.println("Choose any of your Favorite number between 1 and 100");

                            System.out.println("Press Any key to Start the game");

                            String anyKey1 = bufferedReader.readLine();

                            NumberGame testClass1 = new NumberGame();

                            randomNumber = testClass1.getRandomNumberInRange(0, 100);

                            currentNumber = randomNumber;

                            System.out.println("Your Number is : " + String.valueOf(randomNumber));

                            printMessage();

                        }

                        else if (NO.equalsIgnoreCase(input)) {

                            System.out.println("Thank You ");

                            break;

                        }

                    }

                }

                else {

                    System.out.println("Please enter a valid response ");

                    printMessage();

                }



                input = bufferedReader.readLine();

            }

        }

        catch (IOException e) {

            e.printStackTrace();

        }

}



	/**

     * This method is to get random number between two numbers

     * 

     * @param min

     * @param max

     * @return

     */

    public int getRandomNumberInRange(int min, int max) {



        if (min >= max) {

            throw new IllegalArgumentException("max must be greater than min");

        }



        Random r = new Random();

        return r.nextInt((max - min)) + min;

}



    /**

     * This method is to print console message

     * 

     */

    public static void printMessage() {

        System.out.println("Please Say ");

        System.out.println("higher = Higher than this number ");

        System.out.println("lower = lower than this number ");

        System.out.println("yes = yes this number");

    }


}