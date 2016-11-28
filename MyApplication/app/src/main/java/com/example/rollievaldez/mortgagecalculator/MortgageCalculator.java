package com.example.rollievaldez.mortgagecalculator;

/**
 * Created by G-Cheung on 11/28/2016.
 */

public class MortgageCalculator {
    private double homeValue;
    private double loanAmount;
    private double APR;
    private int terms;
    private double propertyTaxRate;

    public MortgageCalculator(double homeValue, double loanAmount,
                              double APR, int terms, double propertyTaxRate){
        this.homeValue = 0;
        this.loanAmount = 0;
        this.APR = 0;
        this.terms = 0;
        this.propertyTaxRate = 0;
    }

    public double Calculate(){
        return 0;
    }

    /*
        function to calculate monthly tax rate
     */
    public double calcMonthlyTax(){
        return (homeValue*propertyTaxRate)/12;
    }

    private double calcMonthlyInterest(){
        double monthlyInterest;
        double rate = APR/12;
        double n = terms*12;
        monthlyInterest = loanAmount*((rate*Math.pow(1+rate,n))/(Math.pow(1+rate,n)-1) );
        return monthlyInterest;
    }
    /*
        function to calculate TOTAL Monthly Payment
     */
    public double calcTotalMonthlyPayment(){
        double monthlyPayment = calcMonthlyInterest()+ calcMonthlyTax();
        return monthlyPayment;
    }
    /*
        function to calculate the Total Interest Paid
     */
    public double totalInterestPaid(){
        return 0;
    }
}
