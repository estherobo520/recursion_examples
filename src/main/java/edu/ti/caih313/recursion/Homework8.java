package edu.ti.caih313.recursion;

import java.math.BigInteger;
import java.lang.*;
import java.util.Scanner;

public class Homework8
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


    public static void main(String args[]){

        Scanner keyboard = new Scanner(System.in);

        //run getLargestValue
        System.out.println("Enter the size of the array of numbers:");
        int size = keyboard.nextInt();
        int [] arrayOfNums = new int [size];
        System.out.println("Enter " + size + " numbers to add into the array");
        for (int i =0; i<size;i++){
            arrayOfNums[i] = keyboard.nextInt();
        }
        int largestValue = getLargestValue(arrayOfNums, 0, arrayOfNums.length-1);
        System.out.println("The largest value in the array is " + largestValue);

        //run handshake
        System.out.println("Enter the number of people in the room:");
        int num = keyboard.nextInt();
        int handshake = handshake(num);
        System.out.println("If there are "+ num +" people in the room then there are " + handshake + " handshakes.");

        //run factorial
        Homework8 lastRecursion = new Homework8();
        boolean playing = true;

        while (playing){
            System.out.println("Please enter a number to receive the factorial:");
            BigInteger number = keyboard.nextBigInteger();
            BigInteger factorial = lastRecursion.factorial(number);
            System.out.println("The factorial of " + number + " is: " + factorial + ". Enter 'yes' if you want to play again, otherwise enter 'no'. ");
            String response = keyboard.next();
            if(((String) response).equalsIgnoreCase("yes")){
                playing = true;
            }
            else    {
                playing = false;
            }
        }

    }


}