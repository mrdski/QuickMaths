package com.company;
import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first operand: ");
        double operand1 = input.nextDouble();
        System.out.print("Enter second operand: ");
        double operand2 = input.nextDouble();
        System.out.print("Calculator Menu\n---------------\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\nWhich operation do you want to perform? ");
        int operation = input.nextInt();
        double result;
        if(operation == 1){
            result = operand1 + operand2;
            System.out.println("The result of the operation is " + result + ". Goodbye!");
        }
        else if(operation == 2){
            result = operand1 - operand2;
            System.out.println("The result of the operation is " + result + ". Goodbye!");
        }
        else if(operation == 3){
            result = operand1 * operand2;
            System.out.println("The result of the operation is " + result + ". Goodbye!");
        }
        else if(operation == 4){
            result = operand1 / operand2;
            System.out.println("The result of the operation is " + result + ". Goodbye!");
        }
        else{
            System.out.println("Error: Invalid selection! Terminating program.");
        }
    }
}
