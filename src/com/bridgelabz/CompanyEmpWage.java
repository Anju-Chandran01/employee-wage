package com.bridgelabz;

public class CompanyEmpWage {public String company;
    public int wagePerHour;
    public int workingDays;
    public int workingHours;
    public int totalEmpWage;

    public CompanyEmpWage(String company ,int wagePerHour,int workingDays,int workingHours){

        this.company=company;
        this.wagePerHour=wagePerHour;
        this.workingDays=workingDays;
        this.workingHours=workingHours;
    }

    public String getName(){
        return this.company;
    }

    public int getEmpRate(){
        return this.wagePerHour;
    }

    public int getNumOfWorkingDays(){
        return this.workingDays;
    }

    public int getMaxHrsInMonth(){
        return this.workingHours;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage=totalEmpWage;
    }

    public String toString() {
        return "Total employee wage for company " +company+" is: "+totalEmpWage;
    }
}
