package ru.netology.javaqa.ticket;

import java.util.Comparator;

public interface Comparable extends Comparator {

    int compareTo(Ticket o);
}
