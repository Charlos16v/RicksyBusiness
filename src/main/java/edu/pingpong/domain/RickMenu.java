package edu.pingpong.domain;

import java.util.ArrayList;
import java.util.List;

public class RickMenu implements GuestDispatcher{


    private int stock = 0;
    private double menuCost = 0.0d;
    private final List<String> orders = new ArrayList<>();

    public RickMenu(int stock, double menuCost) {
        this.stock = stock;
        this.menuCost = menuCost;
    }

    public int stock() {
        return this.stock;
    }

    @Override
    public void dispatch(CreditCard creditCard) {
        if (this.stock > 0 && creditCard.pay(menuCost)) {
            this.stock -= 1;
            orders.add(creditCard.getOwner());
        }
    }

    @Override
    public String toString() {
        return "Stock: " + stock() + '\n' +
                "MenuCost: " + menuCost + '\n' +
                "Orders: " + orders;
    }
}
