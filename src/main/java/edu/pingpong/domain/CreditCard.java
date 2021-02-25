package edu.pingpong.domain;

public class CreditCard {


    private final String owner;
    private final String number;
    private double credit = 3000.0;
    private String SYMBOL = "EZI";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public String number() {
        return number;
    }

    public double credit() {
        return credit;
    }

    public String getSYMBOL() {
        return SYMBOL;
    }

    @Override
    public String toString() {
        return "Owner: " + getOwner() + '\n' +
                "Number: " + number() + '\n' +
                "Credit: " + credit() + " " + getSYMBOL() + '\n';
    }
}
