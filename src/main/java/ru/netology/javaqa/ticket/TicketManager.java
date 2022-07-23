package ru.netology.javaqa.ticket;

import java.util.Arrays;

public class TicketManager {
    private TicketsRepository repo;235235

    public TicketManager(TicketsRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] searchBy(String textFrom, String textTo) {
        Ticket[] result = new Ticket[0];
        int copyToIndexFrom = 0;
        Ticket[] tmp = new Ticket[repo.findAll().length];
        for (Ticket ticket : repo.findAll()) {
            if ( matchesFromIATA(ticket, textFrom) ) {
                tmp[copyToIndexFrom] = ticket;
                copyToIndexFrom++;
            }
        }
        result = new Ticket[copyToIndexFrom];
        System.arraycopy(tmp, 0, result, 0, copyToIndexFrom);

        int copyToIndexTo = 0;
        Ticket[] tmpTo = new Ticket[repo.findAll().length];
        for (Ticket ticket : repo.findAll()) {
            if ( matchesToIATA(ticket, textTo) ) {
                tmpTo[copyToIndexTo] = ticket;
                copyToIndexTo++;
            }
        }

        result = new Ticket[copyToIndexTo];
        System.arraycopy(tmpTo, 0, result, 0, copyToIndexTo);

        Ticket[] ticketResult = result;
        Arrays.sort(ticketResult);
        return ticketResult;
    }


    public boolean matchesFromIATA(Ticket ticket, String search) {
        if (ticket.getFromIATA().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesToIATA(Ticket ticket, String search) {
        if (ticket.getToIATA().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
