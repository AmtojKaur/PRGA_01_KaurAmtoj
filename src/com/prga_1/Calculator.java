package com.prga_1;

/*
 * TCSS 305
 * Instructor: Kivanc Dincer
 * Winter 2022
 * Programming Assignment 1
 */
import java.util.*;
/**
 * Calculator is a program that functions as a basic calculator. It allows the use of functions
 * such as addition, subtraction, multiplication, and division. It also allows the user to generate
 * a random number when they choose, as well as to clear there input and start over.
 *
 * @author Amtoj Kaur
 * @version January 13, 2022
 */

public class Calculator {

    /**
     * The main class provides the implementation of the program, it takes in input from the user
     * to run the program for the calculator and calls all necessary methods.
     *
     * @param args default parameter for the main class
     */
    public static void main(String[] args) {
        commandLineInterface();

        boolean end = false; //true when program ends

        double num1, num2; //holds the first and second numerical input
        double result = 0.0;

        String str1, str2, operator; //hold the numbers/operator that user puts in the scanner

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        str1 = input.nextLine();
        //do while loop so that the program runs at the very least once
        do{
            if(Objects.equals(str1,"END")) {
                end = true;
            } else {
                if(checkForClear(str1)) {
                    str1 = "";
                    System.out.println("Enter the first number");
                    str1 = input.nextLine();
                } else {
                    System.out.println("Enter the operator: " );
                    operator = input.nextLine();

                    System.out.println("Enter the second number: ");
                    str2 = input.nextLine();
                    if(Objects.equals(str2,"END")) {
                        end = true;
                    } else {
                        if(checkForClear(str2)) {
                            System.out.println("Enter the first number: ");
                            str1 = input.nextLine();
                        } else {
                            num1 = strToDouble(str1, result); //method changes string to double
                            num2 = strToDouble(str2, result);

                            //This is calls and code to display and do the math for the input
                            System.out.println(num1 + " " + operator + " " + num2);
                            result = mathFunctions(num1, num2, operator);
                            str1 = "RT";    //Signifies that the operation has not been clear and that
                            // the program should draw from result to be the first number.
                            num1 = result;
                        }
                    }
                }
            }
        } while(!end);
    }

    /**
     * The initial display when the user runs th program. This CLI goes over how to use the calculator.
     */
    public static void commandLineInterface(){
        System.out.println("Hello welcome to my basic Calculator.");
        System.out.println("To use the calculator when prompted enter the first number, then the");
        System.out.println("operation you want to perform, and then the second number. The operations");
        System.out.println("you can perform are as follows; addition(+), subtraction(-), multiplication(*),");
        System.out.println("and division(/). For a Random number enter RND when prompted for a number.");
        System.out.println("To clear input, enter CLR when prompted for a number. To end the program enter");
        System.out.println("END when prompted for a number.");
    }

    /**
     * checkForClear method checks whether the user wants to clear what they have entered so far.
     *
     * @param str takes in user input string
     * @return boolean true or false depending on whether CLR or not
     */
    public static boolean checkForClear(String str) {
        if(Objects.equals(str, "CLR")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * strToDouble returns the double value of either the user input or the current running total
     *
     * @param str str1 or str2 from user input in main
     * @param currentNum random is string is RND, or the running total
     * @return double random double if String is RND, if RT it returns current number or parses
     * through input string to return double
     */
    public static double strToDouble(String str, Double currentNum) {
        if(Objects.equals(str, "RND")) {
            return getRND();
        } else if(Objects.equals(str, "RT")) {
            return currentNum;
        } else {
            return Double.parseDouble(str);
        }
    }

    public static double getRND(){
        Random r = new Random();
        return r.nextDouble();
    }

    public static double mathFunctions(double num1, double num2, String operator){
        double result = 0.0;

        if(Objects.equals(operator, "+")){
            result = num1 + num2;
            int length = String.valueOf(num1 + num2).length();
            if(length > 10) {
                System.out.printf("%10f\n", num1 + num2);
            } else {
                System.out.println(num1 + num2);
            }
        } else if(Objects.equals(operator, "-")) {
            result = num1 - num2;
            int length = String.valueOf(num1 - num2).length();
            if(length > 10) {
                System.out.printf("%10f\n", num1 - num2);
            } else {
                System.out.println(num1 - num2);
            }
        } else if(Objects.equals(operator, "*")) {
            result = num1 * num2;
            int length = String.valueOf(num1 * num2).length();
            if(length > 10) {
                System.out.printf("%10f\n", num1 * num2);
            } else {
                System.out.println(num1 * num2);
            }
        } else if(Objects.equals(operator, "/")) {
            result = num1 / num2;
            int length = String.valueOf(num1 / num2).length();
            if(length > 10) {
                System.out.printf("%10f\n", num1 / num2);
            } else {
                System.out.println(num1 / num2);
            }
        } else {
            System.out.println("Input is invalid");
        }
        return result;
    }
}
