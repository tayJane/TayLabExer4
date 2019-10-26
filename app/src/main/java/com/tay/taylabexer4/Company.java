package com.tay.taylabexer4;

public class Company {
    int comLogo;
    String comName, comCoun, comIndus, comCEO;

    public Company(int comLogo, String comName, String comCoun, String comIndus, String comCEO) {
        this.comLogo = comLogo;
        this.comName = comName;
        this.comCoun = comCoun;
        this.comIndus = comIndus;
        this.comCEO = comCEO;
    }

    public int getComLogo() {
        return comLogo;
    }

    public String getComName() {

        return comName;
    }

    public String getComCoun() {

        return comCoun;
    }

    public String getComIndus() {

        return comIndus;
    }

    public String getComCEO() {

        return comCEO;
    }
}
