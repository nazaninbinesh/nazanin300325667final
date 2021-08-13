package com.example.nazanin300325667;

public class Customer {
    private String custname;
    private String custno;
    private double cdep;
    private int nyears;
    private String savtype;

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public double getCdep() {
        return cdep;
    }

    public void setCdep(double cdep) {
        this.cdep = cdep;
    }

    public int getNyears() {
        return nyears;
    }

    public void setNyears(int nyears) {
        this.nyears = nyears;
    }

    public String getSavtype() {
        return savtype;
    }

    public void setSavtype(String savtype) {
        this.savtype = savtype;
    }

    public Customer(String custno, String custname, double cdep, int nyears, String savtype) {
        this.custname = custname;
        this.custno = custno;
        this.cdep = cdep;
        this.nyears = nyears;
        this.savtype = savtype;
    }
}
