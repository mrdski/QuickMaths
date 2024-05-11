import java.util.Scanner;
public class NumericConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean end = false;
        while(!end){       //while loop to keep the program going
            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit\n");
            boolean valid = false;
            while(!valid){      //while loop to access valid input by user
                System.out.print("Please enter an option: ");
                int choice = input.nextInt();
                if(choice == 1){
                    System.out.print("Please enter the numeric string to convert: ");
                    String s = input.next();
                    System.out.println("Result: " + hexStringDecode(s));
                    valid = true;
                }
                else if(choice == 2){
                    System.out.print("Please enter the numeric string to convert: ");
                    String s = input.next();
                    System.out.println("Result: " + binaryStringDecode(s));
                    valid = true;
                }
                else if(choice == 3){
                    System.out.print("Please enter the numeric string to convert: ");
                    String s = input.next();
                    System.out.println("Result: " + binaryToHex(s));
                    valid = true;
                }
                else if(choice == 4){
                    System.out.println("Goodbye!");
                    valid = true;
                    end = true;
                }
                else{
                    System.out.println("Please enter a valid option.");
                }
            }
            System.out.println();
        }
    }

    public static long hexStringDecode(String hex){
        long result = 0;
        int p = 0;
        int c = 0;
        if(Character.toLowerCase(hex.charAt(1)) == 'x'){    //making lowercase so the case isn't a problem
            c = 2;
        }
        for(int i = hex.length()-1; i >= c; i--){
            int num = hexCharDecode(hex.charAt(i)); //using hexCharDecode to determine the value
            result += num * Math.pow(16, p);
            p++;
        }
        return result;
    }
    public static short hexCharDecode(char digit){
        short result = 0;
        if(Character.isDigit(digit)){   //determining if it is a digit or letter
            result = Short.parseShort(String.valueOf(digit));
        }
        else{
            char nc = Character.toUpperCase(digit);
            if(nc == 'A'){   //the values for the letters
                result = 10;
            }
            else if(nc == 'B'){
                result = 11;
            }
            else if(nc == 'C'){
                result = 12;
            }
            else if(nc == 'D'){
                result = 13;
            }
            else if(nc == 'E'){
                result = 14;
            }
            else if(nc == 'F'){
                result = 15;
            }
        }
        return result;
    }
    public static short binaryStringDecode(String binary){
        short result = 0;
        int j = 0;
        int c = 0;
        if(Character.toLowerCase(binary.charAt(1)) == 'b'){
            c = 2;
        }
        for(int i = binary.length()-1; i >= c; i--){
            char ch = binary.charAt(i);
            int num = Integer.parseInt(String.valueOf(ch));
            result += num * Math.pow(2, j);
            j++;
        }
        return result;
    }
    public static String binaryToHex(String binary){
        String result = "";
        int c;
        if(Character.toLowerCase(binary.charAt(1)) == 'b'){
            c = 2;
        }
        else{
            c = 0;
        }
        for(int i = c; i < binary.length(); i += 4){
            int p = 0;
            int r = 0;
            for(int j = i+3; j >= i; j--){
                char ch = binary.charAt(j);
                int num = Short.parseShort(Character.toString(ch));
                r += num * Math.pow(2, p);
                p++;
            }
            if(r < 10){
                String n = Integer.toString(r);
                result = result.concat(n);          //adding onto the string as the loop goes
            }
            else{
                if(r == 10){
                    result = result.concat("A");
                }
                else if(r == 11){
                    result = result.concat("B");
                }
                else if(r == 12){
                    result = result.concat("C");
                }
                else if(r == 13){
                    result = result.concat("D");
                }
                else if(r == 14){
                    result = result.concat("E");
                }
                else if(r == 15){
                    result = result.concat("F");
                }
            }
        }
        return result;
    }
}
