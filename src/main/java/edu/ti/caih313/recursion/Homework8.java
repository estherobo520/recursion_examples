package edu.ti.caih313.recursion;

import java.math.BigInteger;
import java.lang.*;

public class LastRecursion
{
    //Homework #1
    public static int handshake(int num) {
        if (num == 0 || num == 1) {
            return 0;
        }
        else if (num == 2){
            return 1;
        }
        else {
            return (num + handshake(num -1));
        }
    }

    //Homework #2
    public static BigInteger factorial(BigInteger num) {
        if (num.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ONE;
        }
        else {
            return num.multiply(factorial(num.subtract(BigInteger.ONE)));
        }
    }

    public static void getFactorial() {
        LastRecursion lastRecursion = new LastRecursion();
        boolean playing = true;
        Scanner keyboard = new Scanner(System.in);

        while (playing){
            System.out.println("Please enter a number to play:");
            BigInteger number = keyboard.nextBigInteger();
            BigInteger factorial = lastRecursion.factorial(number);
            System.out.println("The factorial of " + number + " is: " + factorial + ". Enter 'yes' if you want to play again, otherwise enter 'no'. ");
            string response = keyboard.next();
            if(response.equalsIgnoreCase("yes")){
                playing = true;
            }
            else    {
                playing = false;
            }
        }

    }


    //Homework #3
    public static int getLargestValue(int[] array, int start, int end)
    {
        if (start == end) {
            return array[start];
        }
       else {
            int half = (start + end) / 2;
            int firstHalf = getLargestValue(array, start, half);
            int lastHalf = getLargestValue(array, half + 1, end);

            return Math.max(firstHalf, lastHalf);
        }
    }


}