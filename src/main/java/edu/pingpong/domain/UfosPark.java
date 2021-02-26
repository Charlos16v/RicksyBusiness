package edu.pingpong.domain;

import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher {

    private final double fee = 500.0;
    private final Map<String, String> fleet = new HashMap<>();

    public UfosPark(){};

    public void add(String ufo) {
        this.fleet.putIfAbsent(ufo, null);
    }


    @Override
    public void dispatch(CreditCard creditCard) {

    }

    @Override
    public String toString() {
        return this.fleet.keySet().toString();
    }
}
