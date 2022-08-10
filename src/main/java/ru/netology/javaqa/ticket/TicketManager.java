package ru.netology.javaqa.ticket;

import java.util.Arrays;

public class TicketManager {
    private TicketsRepository repo;

    public TicketManager(TicketsRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] searchBy(String textFrom, String textTo) {
        Ticket[] result = new Ticket[0];
        int copyToIndex = 0;
        Ticket[] tmp = new Ticket[repo.findAll().length];
        for (Ticket ticket : repo.findAll()) {
            if (matchesFromIATA(ticket, textFrom) && matchesToIATA(ticket, textTo)) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }

        if ( copyToIndex == 0 ) {
            throw new NoFlightException("Рейс " + textFrom + textTo + "не найден");
        }

        result = new Ticket[copyToIndex];
        System.arraycopy(tmp, 0, result, 0, copyToIndex);

        Ticket[] ticketResult = result;
        Arrays.sort(ticketResult);
        return ticketResult;
    }


    public boolean matchesFromIATA(Ticket ticket, String search) {
        if ( ticket.getFromIATA().contains(search) ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesToIATA(Ticket ticket, String search) {
        if ( ticket.getToIATA().contains(search) ) {
            return true;
        } else {
            return false;
        }
    }
}
