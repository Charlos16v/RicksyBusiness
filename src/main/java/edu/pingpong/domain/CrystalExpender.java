package edu.pingpong.domain;

public class CrystalExpender implements GuestDispatcher{


    private int stock = 0;
    private double itemCost = 0.0d;

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    public int stock() {
        return this.stock;
    }

    @Override
    public void dispatch(CreditCard creditCard) {
        if (this.stock > 0 && creditCard.pay(itemCost)) {
            this.stock -= 1;
        }
    }

    @Override
    public String toString() {
        return "Stock: " + stock() + '\n' +
                "ItemCost: " + itemCost;
    }
}
