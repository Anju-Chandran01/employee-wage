package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

interface InterfaceCalculateWage {
    void addCompanyEmpWage(String companyName, int empWagePerHour, int workingHours, int workingDays);
    void calculateWage();
    int getTotalWage(String companyName);
}

class CompanyEmpWage {
    public int totalEmpWage;
    public String name;
    public int empWage;
    public int maxWorkingDays;
    public int maxWorkingHrs;

    public CompanyEmpWage(String name, int empWage, int maxWorkingDays, int maxWorkingHrs) {
        this.name = name;
        this.empWage = empWage;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHrs = maxWorkingHrs;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString() {
        return "Total employee's wage of " +name+ " for maximum of " +maxWorkingHrs+ " hours for " +maxWorkingDays+ " days is: " +totalEmpWage+ "\n";
    }
}

public class EmployeeWage implements InterfaceCalculateWage {

    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private final ArrayList<CompanyEmpWage> companyEmpWageArrayList;
    private final Map<String, CompanyEmpWage> companyToEmpWageMap;
    private static String name = null;

    public EmployeeWage(String name) {
        EmployeeWage.name = name;
        companyEmpWageArrayList = new ArrayList<>();
        companyToEmpWageMap = new HashMap<>();
    }

    public void addCompanyEmpWage(String companyName, int empWagePerHour, int workingDays, int workingHours) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName, empWagePerHour, workingDays, workingHours);
        companyEmpWageArrayList.add(companyEmpWage);
        companyToEmpWageMap.put(companyName, companyEmpWage);
    }

    public void calculateWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWageArrayList) {
            companyEmpWage.setTotalEmpWage(this.calculateWage(companyEmpWage));
            System.out.println(companyEmpWage);
        }
    }

    @Override
    public int getTotalWage(String name) {
        return companyToEmpWageMap.get(name).totalEmpWage;
    }

    private int calculateWage(CompanyEmpWage companyEmpWage) {
        int empHours;
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;

        while (totalWorkingHours < companyEmpWage.maxWorkingHrs && totalWorkingDays < companyEmpWage.maxWorkingDays) {
            totalWorkingDays++;
            int empCheck = ((int) Math.floor(Math.random() * 10)) % 3;
            empHours = switch (empCheck) {
                case IS_FULL_TIME -> 8;
                case IS_PART_TIME -> 4;
                default -> 0;
            };
            totalWorkingHours += empHours;
        }
        return totalWorkingHours * companyEmpWage.empWage;
    }

    public static void main(String[] args)
    {
        System.out.println("--- Welcome to employee wage problem ---");
        EmployeeWage employeeWage = new EmployeeWage(name);
        employeeWage.addCompanyEmpWage("Reliance", 20, 180, 30);
        employeeWage.addCompanyEmpWage("TCS", 30, 100, 25);
        employeeWage.calculateWage();
    }
}