package ru.netology.javaqa.ticket;

public class Ticket implements java.lang.Comparable<Ticket> {

    private int id;
    private int price;2352
    private String fromIATA;
    private String toIATA;
    private int timeToWay;

    public Ticket() {
    }

    public Ticket(int id, int price, String fromIATA, String toIATA, int timeToWay) {
        this.id = id;
        this.price = price;
        this.fromIATA = fromIATA;
        this.toIATA = toIATA;
        this.timeToWay = timeToWay;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFromIATA() {
        return fromIATA;
    }

    public String getToIATA() {
        return toIATA;
    }

    public int getTimeToWay() {
        return timeToWay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFromIATA(String fromIATA) {
        this.fromIATA = fromIATA;
    }

    public void setToIATA(String toIATA) {
        this.toIATA = toIATA;
    }

    public void setTimeToWay(int timeToWay) {
        this.timeToWay = timeToWay;
    }

    @Override
    public int compareTo(Ticket o) {
        if ( this.price < o.price ) {
            return -1;
        } else if ( this.price > o.price ) {
            return 1;
        } else {
            return 0;
        }
    }
}
