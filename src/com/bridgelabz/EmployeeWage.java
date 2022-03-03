package com.bridgelabz;

public class EmployeeWage {

    static final int WAGE_PER_HOUR = 20;
    static final int IS_FULL_TIME = 1;
    static final int IS_PART_TIME = 2;
    static final int MAX_WORKING_HOURS = 100;
    static final int MAX_WORKING_DAYS = 20;


    public static void main(String[] args) {
        System.out.println("--- Welcome to Employee Wage Computation Program ---");
        int empHrs;
        int empWage;
        int totalEmpWage = 0;
        int totalWorkingDays = 0;
        int totalWorkingHrs = 0;

        //  TO CALCULATE WAGES FOR 20 DAYS (100 HRS)
        while (totalWorkingHrs <= MAX_WORKING_HOURS && totalWorkingDays < MAX_WORKING_DAYS) {
            int checkAttendance = (int) Math.floor(Math.random() * 10) % 3;
            switch (checkAttendance) {
                case IS_FULL_TIME -> empHrs = 8;
                case IS_PART_TIME -> empHrs = 4;
                default -> empHrs = 0;
            }

            //CALCULATE TOTAL WORKING HOURS AND WAGE
            empWage = empHrs * WAGE_PER_HOUR;
            System.out.println("Daily working hour : "+ empHrs);
            System.out.println("Daily Wage : " + empWage);

            totalWorkingHrs = totalWorkingHrs + empHrs;
            totalEmpWage = totalEmpWage + empWage;
            totalWorkingDays++;
        }
        System.out.println("Total Working Hours : "+ totalWorkingHrs);
        System.out.println("Total Working Days : "+ totalWorkingDays);
        System.out.println("Total Employee Wage : "+ totalEmpWage);
    }
}