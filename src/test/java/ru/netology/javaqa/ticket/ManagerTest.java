package ru.netology.javaqa.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    TicketsRepository repo = new TicketsRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 33_086, "VKO", "IST", 4);
    Ticket ticket2 = new Ticket(2, 181_373, "DME", "DPS", 22);
    Ticket ticket3 = new Ticket(3, 60_270, "VKO", "RTM", 15);
    Ticket ticket4 = new Ticket(4, 32_086, "VKO", "IST", 3);
    Ticket ticket5 = new Ticket(6, 59_270, "VKO", "RTM", 14);
    Ticket ticket6 = new Ticket(7, 34_086, "VKO", "IST", 5);
    Ticket ticket7 = new Ticket(9, 61_270, "VKO", "RTM", 16);
    Ticket ticket8 = new Ticket(10, 33_086, "VKO", "IST", 3);
    Ticket ticket9 = new Ticket(12, 60_270, "VKO", "RTM", 14);
    Ticket ticket10 = new Ticket(13, 36_086, "VKO", "IST", 5);
    Ticket ticket11 = new Ticket(15, 54_270, "VKO", "RTM", 12);

    @BeforeEach
    public void setup() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.save(ticket9);
        repo.save(ticket10);
        repo.save(ticket11);
    }

    @Test
    public void searchByTextTest() {

        Ticket[] expected = new Ticket[]{ticket11, ticket5, ticket3, ticket9, ticket7};
        Ticket[] actual = manager.searchBy("VKO", "RTM");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByOneTextTest() {

        Ticket[] expected = new Ticket[]{ticket2};
        Ticket[] actual = manager.searchBy("DME", "DPS");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNotFindFromTest() {

        Assertions.assertThrows(NoFlightException.class, () -> {
            manager.searchBy("LON","RTM");
        });
    }

    @Test
    public void searchNotFindToTest() {

        Assertions.assertThrows(NoFlightException.class, () -> {
            manager.searchBy("VKO","ZRH");
        });
    }

    @Test
    public void searchNotFindFlightTest() {

        Assertions.assertThrows(NoFlightException.class, () -> {
            manager.searchBy("LON","ZRH");
        });
    }
}
