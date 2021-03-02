package edu.pingpong.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class Receptivo {


    private Set<GuestDispatcher> observers = new LinkedHashSet<>();

    public Receptivo() {};

    public void registra(GuestDispatcher guestDispatcher) {
        observers.add(guestDispatcher);
    }

}
