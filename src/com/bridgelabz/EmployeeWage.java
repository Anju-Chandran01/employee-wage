package com.bridgelabz;

import java.util.Random;

public class EmployeeWage {

    static final int WAGE_PER_HOUR = 20;

    public static void main(String[] args) {
        System.out.println("--- Welcome to Employee Wage Computation Program ---");
        int attendance = (int)Math.floor(Math.random()*10)%2;
        if(attendance == 1){
            int empHrs = 8;
            int empWage = empHrs * WAGE_PER_HOUR;
            System.out.println("Employee is present");
            System.out.println("Daily wage of employee is "+ empWage);
        }
        else{
            System.out.println("Employee is absent");
        }
    }
}









