package com.example.rollievaldez.mortgagecalculator;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        double totalInterest;
        totalInterest = (calcMonthlyInterest()*(terms*12))-loanAmount;
        return totalInterest;
    }

    /*
        function to calculate total Property Tax paid
     */
    public double totalPropertyTax(){
        double totalPropTax;
        totalPropTax = calcMonthlyTax()*(terms*12);
        return totalPropTax;
    }

    public String datePaidOff(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, terms);
        return sdf.format(calendar.getTime());
    }

    public void setHomeValue(double homeValue){
        this.homeValue = homeValue;
    }

    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }

    public void setAPR(double APR){
        this.APR = APR / 100;
    }

    public void setTerms(int terms){
        this.terms = terms;
    }

    public void setPropertyTaxRate(double propertyTaxRate){
        this.propertyTaxRate = propertyTaxRate;
    }
}
