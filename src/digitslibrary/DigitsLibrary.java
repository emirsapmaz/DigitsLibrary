/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitslibrary;

import java.util.Scanner;

/**
 *
 * @author Emir Sapmaz
 */
public class DigitsLibrary {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu;
        do{
            System.out.println("Digits Library Menu\n"+
                            "1. Least significant digit   \n" +
                            "2. ith digit\n" +
                            "3. Sum of digits \n" +
                            "4. Count digits \n" +
                            "5. Remove digitK \n" +
                            "6. Remove digit with value \n" +
                            "7. Generate random number \n" +
                            "8. Reverse digits \n" +
                            "9. Check palindrome \n" +
                            "10. CharDigitSum\n" +
                            "11. Quit \n"+
                            "Choose action to perform: ");

            menu = input.nextInt();
            switch(menu){
                case 1:
                    System.out.println("Enter an integer:");
                    int aa = input.nextInt();
                    System.out.println("The least significant digit is "+digitZero(aa) );
                    break;
                case 2:
                    System.out.println("Enter an integer:");
                    int ab = input.nextInt();
                    System.out.println("Enter the digit:");
                    int ac = input.nextInt();
                    System.out.println(ac+"th digit of "+ab+" is "+digitAt(ab, ac));
                    break;
                case 3:
                    System.out.println("Enter an integer:");
                    int ad = input.nextInt();
                    System.out.println("Enter the limit:");
                    int ae = input.nextInt();
                    System.out.println("The limit digit sum is calculated as: "+digitSumLargerThan(ad, ae));
                    break;
                case 4:
                    System.out.println("Enter an integer:");
                    int af = input.nextInt();
                    System.out.println("Enter the digit:");
                    int ag = input.nextInt();
                    System.out.println(ag+" occurs "+digitCount(af, ag)+" time(s) in "+ af);
                    break;
                case 5:
                    System.out.println("Enter an integer:");
                    int ah = input.nextInt();
                    System.out.println("Which digit to remove?");
                    int ai = input.nextInt();
                    System.out.println("After the removal number is "+digitRemoveAt(ah, ai));
                    break;
                case 6:
                    System.out.println("Enter an integer:");
                    int aj = input.nextInt();
                    System.out.println("Enter the integer that you want to remove:");
                    int ak = input.nextInt();
                    System.out.println("The new number is "+digitRemoveAll(aj, ak));
                    break;
                case 7:
                    System.out.println("Enter an integer to get n-digit random number: ");
                    int a1 = input.nextInt();
                    System.out.println(a1+" digit random number is "+randomNumber(a1));
                    break;
                case 8:
                    System.out.println("Enter an integer to invert:");
                    int a2 = input.nextInt();
                    System.out.println("Reversed version of "+a2+" is "+reverse(a2));
                    break;
                case 9:
                    System.out.println("Enter the number to check:");
                    int a3 = input.nextInt();
                    if(isPalindrome(a3)==true)
                        System.out.println("This number is a palindrome.");
                    else
                        System.out.println("This number is not a palindrome.");
                    break;
                case 10://sıkıntılı
                    System.out.println("Enter a word to calculate it's sum of the integer equivalents (ASCII CODES)");
                    String word = input.next();
                    System.out.println("Sum of the integer equivalents (ASCII CODES) is "+charDigitSum(word));
                    break;
                case 11:
                    System.out.println("Ok, good bye.");
                    break;
                default:
                    System.out.println("Please enter a valid number!");
                    break;
            }
        }while(menu!=11);
    }
  
    public static int digitZero (int n){
        int a = n%10;        
        return a;
    }
    
    public static int digitAt (int n, int i){
        int b=0 ;
        int y = (int)Math.pow(10, i);
        for (int j = 0; j <= i; j++) {
            b = n/y;
        }
        b=b%10;
        return b;
    }
    
    public static int digitSumLargerThan (int n, int limit){
        int sum = 0;
        int c;
        for (int i = 0; i < n; i++) {
            c =n%10;
            if(c>limit){
                sum=sum+c;
            }
            n=n/10;
        }
        return sum;    
    }
    
    public static int digitCount (int n, int digit){
        int count = 0;
        int d;
        for (int i = -10; i < n; i++) {
            d=n%10;
            if(d==digit){
                count++;
            }
            n=n/10; 
        }
        return count;
    }
    
    public static int digitRemoveAt (int n, int i){
        int e = 0;
        int f = 0;
        int x = (int)Math.pow(10, i+1);
        int y = (int)Math.pow(10, i);
        for (int j = 0; j <= i; j++) {
            e= n/x;
        }
        for (int j = 0; j <= i; j++) {
            f= n%y;
        }
        return (e*y+f);
    }
    
    public static int digitRemoveAll (int n, int digit){
        int a;
        int a2;
        int sum2 = 0;
        int sum = 0;
        while(n>0){
            a=n%10;
            n=n/10;
            if(a!=digit){
                sum=sum*10+a;
            }
        }
        while(sum>0) {
            a2=sum%10;
            sum=sum/10;
            sum2=sum2*10+a2;
        }
        return sum2;
    }
    
    public static int randomNumber (int k){
     
        int[] digit = new int[k];
        for (int i = 0; i < k; i++) {
            digit[i]=(int)(Math.random()*9)+1;
        }
        for (int i = 0; i < k; i++) {
            for (int j = i+1; j < k; j++) {
                if(digit[i]==digit[j]){
                    digit[j]=(int)(Math.random()*9);
                    i=0;
                    j--;
                }
                else if(digit[digit.length-1]==0)//There is also a probability to get 0 in the first digit which would decrease the digit number.
                    digit[0]=(int)(Math.random()*9)+1;
            }
            if(k==10) //to increase the chance of getting proper random numbers. There is a probability to get higher values than an integer's maximum value so it is better to narrow the intervals down.
                if(digit[0]!=1)
                    return randomNumber(k);
            
        }
        
        int sumd = 0;
        for (int i = 0; i < k; i++) {
            sumd=sumd*10+digit[i];
        }
        
        
        return sumd;
    } 
    
    public static int reverse (int n){
       int sum = 0;
       int a;
        for (int i = -1; i <= n; i++) {
            a = n%10;
            sum=sum*10+a;
            n=n/10;
        }
        return sum;
    }
    
    public static boolean isPalindrome (int n){
        boolean palindrome ;
        int a;
        int rtn;
        int x = n;
        int sum = 0;
        while(n>0){
            a = n%10;
            sum=sum*10+a;
            n=n/10;
        }
        if(sum==x)
            palindrome=true;
        else
            palindrome=false;
        
        return palindrome;      
    }
    
    public static int charDigitSum (String str){
        
        char[] character = new char [str.length()];
        int sum =0;
        for (int i = 0; i < character.length; i++) {
            character[i]=str.charAt(i);
            sum = (int)character[i]+sum;
        }
        return sum;
        
    }
    
}

