package com.password.generator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("How many password you want to generate?");
        int numOfPassword= input.nextInt();
        input.nextLine();
        PasswordGenerator passwordGenerator=new PasswordGenerator();
        System.out.println("what type of password you want to generate? (Numbers only, All)");
        String passwordType= input.nextLine();

        while(numOfPassword>0){
            String password;
            if(passwordType.equals("Numbers only")){
                password = passwordGenerator.numericPassGenerator();
                System.out.println(password);
            }
            else{
                password = passwordGenerator.allPasswordGenerator();
                System.out.println(password);
            }
            numOfPassword--;
        }
    }
}