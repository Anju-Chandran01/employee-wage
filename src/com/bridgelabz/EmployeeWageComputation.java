package com.bridgelabz;

public class EmployeeWageComputation {
    //constants
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private int numOfCompany = 0;
    private final CompanyEmpWage[] companyEmpWageArray;

    public EmployeeWageComputation() {
        companyEmpWageArray = new CompanyEmpWage[5];
    }

    private void addCompanyEmpWage(String company ,int wagePerHour,int workingDays,int workingHours){
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company,wagePerHour,workingDays,workingHours);
        numOfCompany++;
    }

    private void computeEmpWage() {
        for (int i =0; i < numOfCompany; i++) {
            companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i]);
        }
    }
    //Calculating monthly wage of employee
    private int computeEmpWage(CompanyEmpWage companyEmpWage){
        //variables
        int empHours, totalWorkingDays=0, totalEmpHours=0;
        while (totalEmpHours <= companyEmpWage.workingHours && totalWorkingDays < companyEmpWage.workingDays){
            totalWorkingDays++;
            int empCheck=(int) Math.floor(Math.random() * 10) % 3;
            empHours = switch (empCheck) {
                case IS_PART_TIME -> 8;
                case IS_FULL_TIME -> 4;
                default -> 0;
            };
            totalEmpHours += empHours;
        }
        System.out.println("total employee working hour - "+totalEmpHours);
        System.out.println("total employee working days - "+totalWorkingDays);
        return totalEmpHours * companyEmpWage.wagePerHour;
    }
    public static void main(String[] args){
        System.out.println("Welcome to Employee Wage Computation");
        EmployeeWageComputation empWage = new EmployeeWageComputation();
        empWage.addCompanyEmpWage("Dmart",20,20,100);
        empWage.addCompanyEmpWage("Reliance",10,25,150);
        empWage.computeEmpWage();
    }
}
