package com.bridgelabz;

public class EmployeeWage {
    // CONSTANTS
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private String company;
    private int wagePerHour;
    private int workingDays;
    private int workingHours;
    private int totalEmpWage;

    public void EmployeeWageComputation(String company , int wagePerHour, int workingDays, int workingHours){
        this.company=company;
        this.wagePerHour=wagePerHour;
        this.workingDays=workingDays;
        this.workingHours=workingHours;
    }

    // CALCULATING MONTHLY WAGE OF EMPLOYEES
    public void employeeMonthlyWage(){
        //variables
        int empHours;
        int totalWorkingDays=0;
        int totalEmpHours=0;
        int empCheck=(int) Math.floor(Math.random() * 10) % 3;
        while (totalEmpHours <= workingHours && totalWorkingDays < workingDays){
            totalWorkingDays++;
            empHours = switch (empCheck) {
                case IS_PART_TIME -> 8;
                case IS_FULL_TIME -> 4;
                default -> 0;
            };
            totalEmpHours += empHours;
        }
        System.out.println("total employee working hour - "+totalEmpHours);
        System.out.println("total employee working days - "+totalWorkingDays);
        totalEmpWage = totalEmpHours * wagePerHour;
    }

    public String toString(){
        return "Total employee wage for company : "+company+" is - "+totalEmpWage;
    }

    public static void main(String[] args){
        System.out.println("Welcome to Employee Wage Computation");
        //take user input for each company
        EmployeeWageComputation dmart = new EmployeeWageComputation("DMart",20,20,100);
        EmployeeWageComputation reliance = new EmployeeWageComputation("Reliance",10,25,150);
        dmart.employeeMonthlyWage();
        System.out.println(dmart);
        reliance.employeeMonthlyWage();
        System.out.println(reliance);
    }
}