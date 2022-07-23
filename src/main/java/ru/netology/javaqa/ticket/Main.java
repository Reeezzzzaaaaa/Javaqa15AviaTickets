package ru.netology.javaqa.ticket;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        TicketsRepository repo = new TicketsRepository();

        Ticket ticket1 = new Ticket(1, 11_685, "VKO", "AER", 3);
        Ticket ticket2 = new Ticket(2, 7_485, "AER", "VKO", 3);
        Ticket ticket3 = new Ticket(3, 33_086, "VKO", "IST", 4);
        Ticket ticket4 = new Ticket(4, 55_170, "IST", "VKO", 4);
        Ticket ticket5 = new Ticket(5, 181_373, "DME", "DPS", 22);
        Ticket ticket6 = new Ticket(6, 108_320, "DPS", "VKO", 11);
        Ticket ticket7 = new Ticket(7, 60_270, "VKO", "RTM", 15);

        Ticket[] ticketsSort = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Arrays.sort(ticketsSort);
    }
}
