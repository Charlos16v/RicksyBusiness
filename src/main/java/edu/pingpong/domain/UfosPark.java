package edu.pingpong.domain;

import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher {

    private final double fee = 500.0;
    private final Map<String, String> fleet = new HashMap<>();

    // Constructor
    public UfosPark() {
    }

    // Metodo encargado de añadir el ufo a la flota si no existe ya.
    public void add(String ufo) {
        this.fleet.putIfAbsent(ufo, null);
    }


    // Override del metodo "dispatch" implementado en la interfaz "GuestDispatcher"
    @Override
    public void dispatch(CreditCard creditCard) {

        Map.Entry<String, String> ufo = null;

        if (!fleet.containsValue(creditCard.number())) {
            for (Map.Entry<String, String> entry : fleet.entrySet()) {
                if (entry.getValue() == null) {
                    ufo = entry;
                    break;
                }
            }
        }
        if (ufo != null && creditCard.pay(fee)) {
            this.fleet.put(ufo.getKey(), creditCard.number());
        }
    }


    public String getUfoOf(String cardNumber) {

        String ufo = null;

        if (this.fleet.containsValue(cardNumber)) {
            for (Map.Entry<String, String> entry : this.fleet.entrySet()) {
                if (entry.getValue().equals(cardNumber)) {
                    ufo = entry.getKey();
                    break;
                }
            }
        }
        return ufo;
    }


    @Override
    public String toString() {
        return this.fleet.keySet().toString();
    }


    // Metodo privado encargado comprobar si hay un ufo alquilado a partir del numero de tarjeta.
    private boolean containsCard(String cardNumber) {
        return fleet.containsValue(cardNumber);
    }
}
