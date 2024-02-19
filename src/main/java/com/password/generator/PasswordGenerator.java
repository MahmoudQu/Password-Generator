package com.password.generator;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    public String numericPassGenerator(){
        return RandomStringUtils.randomNumeric(6);
    }
    public String allPasswordGenerator(){
        String generatedPassword;
        do{
            generatedPassword=RandomStringUtils.random(4,true,true);
            generatedPassword+=RandomStringUtils.random(2, "_$#%");
            generatedPassword=shufflePassword(generatedPassword);
        }
        while(!isValidPassword(generatedPassword));
        return generatedPassword;
    }
    private String shufflePassword(String password){
        List<Character>chars=new ArrayList<>();
        for(char c : password.toCharArray()){
            chars.add(c);
        }
        Collections.shuffle(chars);
        StringBuilder shuffledPassword= new StringBuilder();
        for(char c : chars){
            shuffledPassword.append(c);
        }
        return shuffledPassword.toString();
    }
    private boolean isValidPassword(String password){
        int digitCount=0;
        int uppercaseCount=0;
        int symbolsCount=0;

        for(int i=0; i<password.length(); i++){
            if((int) password.charAt(i) >=65 && (int) password.charAt(i) <=90){
                uppercaseCount++;
            }
            else  if((int) password.charAt(i) >=48 && (int) password.charAt(i) <=57){
                digitCount++;
            }
            //(int) password.charAt(i) ==95 || ((int) password.charAt(i) >=35 && (int) password.charAt(i) <=37)
            else if("_$#%".indexOf(password.charAt(i)) != -1){
                symbolsCount++;
            }
        }
        if (digitCount != 2 || uppercaseCount != 2 || symbolsCount != 2) {
            return false;
        }

        for (int i = 0; i < password.length() - 1; i++) {
            if (isSameGroup(password.charAt(i), password.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }
    private  boolean isSameGroup(char a, char b) {
        if (Character.isDigit(a) && Character.isDigit(b)) {
            return true;
        }
        else if (Character.isUpperCase(a) && Character.isUpperCase(b)) {
            return true;
        }
        else {
            return "_$#%".indexOf(a) != -1 && "_$#%".indexOf(b) != -1;
        }
    }
}



