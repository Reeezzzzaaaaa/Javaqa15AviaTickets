package ru.netology.javaqa.ticket;

public class TicketsRepository {

    private Ticket[] tickets = new Ticket[0];

    public Ticket[] getTickets() {
        return tickets;
    }

    public void save(Ticket ticket) {

        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets,0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket findById(int id) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                tmp[copyToIndex] = ticket;
                return ticket;
            }

        }
        return null;
    }

    public void removeById(int id) {

        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] findAll() {
        Ticket[] tmp = new Ticket[tickets.length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tickets = tmp;
        return tickets;
    }
}
