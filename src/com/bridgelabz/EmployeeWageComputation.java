package com.bridgelabz;

import java.util.ArrayList;

interface EmployeeWage {

    void addCompanyEmpWage(String company ,int wagePerHour,int workingDays,int workingHours);
    void computeEmpWage();
}

public class EmployeeWageComputation implements EmployeeWage {

    //CONSTANTS
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private final ArrayList<CompanyEmpWage> companies;

    public EmployeeWageComputation() {
        companies = new ArrayList<>();
    }

    public void addCompanyEmpWage(String company ,int wagePerHour,int workingDays,int workingHours){
        companies.add(new CompanyEmpWage(company,wagePerHour,workingDays,workingHours));
    }

    public void computeEmpWage() {
        for (CompanyEmpWage company : companies) {
            int totalWage = computeEmpWage(company);
            company.setTotalEmpWage(totalWage);
            System.out.println(company);
        }
    }

    //CALCULATING MONTHLY WAGE OF EMPLOYEE
    private int computeEmpWage(CompanyEmpWage companyEmpWage){

        //VARIABLES
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

        System.out.println("Total employee working hour - "+totalEmpHours);
        System.out.println("Total employee working days - "+totalWorkingDays);
        return totalEmpHours * companyEmpWage.wagePerHour;
    }

    public static void main(String[] args){
        System.out.println("--- Welcome to Employee Wage Computation ---");
        EmployeeWageComputation empWage = new EmployeeWageComputation();
        empWage.addCompanyEmpWage("Dmart",20,20,100);
        empWage.addCompanyEmpWage("Reliance",10,25,150);
        empWage.computeEmpWage();
    }
}
