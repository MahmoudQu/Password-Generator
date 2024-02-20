package com.password.generator;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("How many password you want to generate?");
        int numOfPassword= input.nextInt();
        input.nextLine();
        System.out.println("what type of password you want to generate? (Numbers only, All)");
        String passwordType= input.nextLine();
        //PasswordGenerator passwordGenerator=
        while(numOfPassword>0){
            String password;
            if(passwordType.equals("Numbers only")){
                PasswordGenerator passwordGenerator=new NumericPasswordGenerator();
                password = passwordGenerator.generatedPassword();
                System.out.println(password);
            }
            else{
                PasswordGenerator passwordGenerator=new AllPasswordGenerator();
                password = passwordGenerator.generatedPassword();
                System.out.println(password);
            }
            numOfPassword--;
        }
    }
}