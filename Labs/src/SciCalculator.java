import java.util.Scanner;

public class SciCalculator {
    public static void main(String[] args) {
        double currResult = 0;      //Declaring and initializing variables
        double previousResult = 0;
        double firstOp;
        double secondOp;
        double sumCalcs = 0;
        int numCalcs = 0;
        String firstInput;
        String secondInput;
        Scanner input = new Scanner(System.in);
        boolean keepGoing = false;
        while(!keepGoing){      //while loop on the condition that they still want to do calculations
            System.out.println("Current Result: " + currResult);
            System.out.println("\nCalculator Menu");
            System.out.println("---------------");
            System.out.println("0. Exit Program");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exponentiation");
            System.out.println("6. Logarithm");
            System.out.println("7. Display Average\n");
            boolean correctInput = false;
            while(!correctInput){       //while loop on the condition that there is still a calculation to do
                System.out.print("Enter Menu Selection: ");
                int calculation = input.nextInt();
                System.out.println();
                if(calculation == 0){       //if statements based on the input
                    keepGoing = true;
                    correctInput = true;
                    System.out.println("Thanks for using this calculator. Goodbye!");
                }
                else if(calculation > 0 && calculation < 7){
                    System.out.print("Enter first operand: ");
                    firstInput = input.next();
                    if(firstInput.equals("RESULT")){    //If statements to determine if should use RESULT
                        firstOp = previousResult;
                    }
                    else{
                        firstOp = Double.parseDouble(firstInput);   //Using Double.parseDouble() to change
                    }                                               //the String into a double
                    System.out.print("Enter second operand: ");     //https://beginnersbook.com/2013/12/how-to-convert-string-to-double-in-java/
                    secondInput = input.next();
                    if(secondInput.equals("RESULT")){
                        secondOp = previousResult;
                    }
                    else{
                        secondOp = Double.parseDouble(secondInput);
                    }
                    if(calculation == 1){       //Using the methods to do the calculations for all the different inputs
                        currResult = AddCalc(firstOp, secondOp);
                    }
                    else if(calculation == 2){
                        currResult = SubCalc(firstOp, secondOp);
                    }
                    else if(calculation == 3){
                        currResult = MultCalc(firstOp, secondOp);
                    }
                    else if(calculation == 4){
                        currResult = DivCalc(firstOp, secondOp);
                    }
                    else if(calculation == 5){
                        currResult = ExpoCalc(firstOp, secondOp);
                    }
                    else{
                        currResult = LogCalc(firstOp, secondOp);
                    }
                    previousResult = currResult;
                    sumCalcs += currResult;
                    numCalcs++;
                    correctInput = true;
                    System.out.println();
                }
                else if(calculation == 7){
                    if(numCalcs == 0){
                        System.out.println("Error: No calculations yet to average!");
                    }
                    else{
                        System.out.println("Sum of calculations: " + sumCalcs);
                        System.out.println("Number of calculations: " + numCalcs);
                        System.out.println("Average of calculations: " + ((double)Math.round(DisAverage(sumCalcs, numCalcs)*100)/100) + "\n");
                    }
                }
                else{
                    System.out.println("Error: Invalid selection!");
                }
            }
        }
    }
        //All the methods used to do the calculations with the parameters
    public static double AddCalc(double fOp, double sOp) { return fOp + sOp;}
    public static double SubCalc(double fOp, double sOp){
        return fOp - sOp;
    }
    public static double MultCalc(double fOp, double sOp){
        return fOp * sOp;
    }
    public static double DivCalc(double fOp, double sOp){
        return fOp / sOp;
    }
    public static double ExpoCalc(double fOp, double sOp){
        return Math.pow(fOp,sOp);
    }
    public static double LogCalc(double fOp, double sOp) {
        return Math.log(sOp) / Math.log(fOp);
    }
    public static double DisAverage(double sum, double num){
        return sum / num;
    }
}
