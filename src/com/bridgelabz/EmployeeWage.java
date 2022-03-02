package com.bridgelabz;

public class EmployeeWage {

    static final int WAGE_PER_HOUR = 20;
    static final int IS_FULL_TIME = 1;
    static final int IS_PART_TIME = 2;

    public static void main(String[] args) {
        System.out.println("--- Welcome to Employee Wage Computation Program ---");
        int empHrs = 0;
        int empWage;
        int checkAttendance = (int)Math.floor(Math.random()*10)%3;
        switch (checkAttendance) {
            case IS_FULL_TIME -> {
                System.out.println("Employee works for Full Time");
                empHrs = 8;
            }
            case IS_PART_TIME -> {
                System.out.println("Employee works for Part Time");
                empHrs = 4;
            }
            default -> System.out.println("Employee is absent");
        }
        empWage = empHrs * WAGE_PER_HOUR;
        System.out.println("Employee Wage is "+ empWage);
    }
}