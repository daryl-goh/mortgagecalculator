package personal.mortgagecalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

       
    public static void main(String[] args) {

        //Import scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Principal Amount: ");

        double principal = scanner.nextDouble();

        System.out.println("Please enter the Interest Rate (Annual): ");

        float annualInterestRate = scanner.nextFloat();
        //when people enter x% interest rate annually, below will convert x% to monthly and decimal format
        float monthlyInterestRate = annualInterestRate / 12 / 100;

        System.out.println("Please enter the Loan Period (Years): ");

        int periodInYears = scanner.nextInt();

        scanner.close();

        int periodInMonths = periodInYears * 12;
        //Put all variables above together to form the formula to calculate month mortgage payment   
        //Math.pow to utilize power function. This utilizes 2 parameters, takes 1st parameter and raises it to the 2nd parameter
        double monthlyPayment = principal * ((monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, periodInMonths))) / ((Math.pow(1 + monthlyInterestRate, periodInMonths)) - 1));


        System.out.println("Your monthly mortgage payment is: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
        System.out.println("Your total amount paid is: " + NumberFormat.getCurrencyInstance().format(periodInMonths * monthlyPayment));
        
    }
}
