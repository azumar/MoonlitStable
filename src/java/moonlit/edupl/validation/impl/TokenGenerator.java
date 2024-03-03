/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.validation.impl;

import javax.ejb.Stateless;



/**
 *
 * @author umar_
 */
@Stateless
public class TokenGenerator {
     static  int   count = 0;
    public String getAccessCodes()
    {
      
        String pin =    getRandomTriple() + "-" +
                        getRandomTriple() + "-" +
                        getRandomTriple() + "-" +
                     getRandomTriple();
        count++;
        return pin;
        
    }

    public TokenGenerator() {
        
        System.out.println("CONTAINER INSTANTIATED");
    }
    

    public  int getCount() {
        return count;
    }
    
     public static int getRandomDigit() {
        return (int)(100.0 * Math.random());
    } 
      
    public static char getRandomChar() {
        return (char)('A' + (26.0 * Math.random()) );
    }
    
    public static String getRandomTriple() {
        return "" + getRandomDigit() + getRandomDigit() + getRandomChar();
    } 
    
}
