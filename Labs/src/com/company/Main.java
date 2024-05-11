package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Hello. What is your name? ");
        String name = input.next();
        System.out.print("It's nice to meet you, " + name + ". How old are you? ");
        int age = input.nextInt();
        System.out.print("I see that you are still quite young at only " + age + ".\nWhere do you live? ");
        String home = input.next();
        System.out.print("Wow! I've always wanted to go to " + home + ". Thanks for chatting with me. Bye!");
    }
}
