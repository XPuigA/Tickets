package com.tickets.rest.domain;

public class Ticket {

    private double value;
    private int quantity;

    public Ticket(double value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    public Ticket(double value) {
        this.value = value;
        this.quantity = 1;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public void incrementQuantity(int howMany) {
        this.quantity += howMany;
    }

    public Ticket clone() {
        return new Ticket(this.getValue(), this.getQuantity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.value, value) == 0 && quantity == ticket.quantity;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}
