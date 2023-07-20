package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void testSortPriceForMany() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("MSC", "SPB", 10_000, 10, 14);
        Ticket ticket2 = new Ticket("MSC", "KAZ", 100_000, 14, 19);
        Ticket ticket3 = new Ticket("MSC", "ADL", 120_000, 12, 14);
        Ticket ticket4 = new Ticket("MSC", "UFA", 50_000, 11, 20);
        Ticket ticket5 = new Ticket("MSC", "SPB", 5_000, 10, 14);

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] actual = avia.search("MSC", "SPB");
        Ticket[] expected = {ticket5, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortPriceForOne() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("MSC", "SPB", 10_000, 10, 14);
        Ticket ticket2 = new Ticket("MSC", "KAZ", 100_000, 14, 19);
        Ticket ticket3 = new Ticket("MSC", "ADL", 120_000, 12, 14);
        Ticket ticket4 = new Ticket("MSC", "UFA", 50_000, 11, 20);
        Ticket ticket5 = new Ticket("MSC", "SPB", 5_000, 10, 14);

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] actual = avia.search("MSC", "UFA");
        Ticket[] expected = {ticket4};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortPriceForZero() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("MSC", "SPB", 10_000, 10, 14);
        Ticket ticket2 = new Ticket("MSC", "KAZ", 100_000, 14, 19);
        Ticket ticket3 = new Ticket("MSC", "ADL", 120_000, 12, 14);
        Ticket ticket4 = new Ticket("MSC", "UFA", 50_000, 11, 20);
        Ticket ticket5 = new Ticket("MSC", "SPB", 5_000, 10, 14);

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] actual = avia.search("MSC", "LA");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTimeMany() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("MSC", "SPB", 10_000, 10, 14); //4
        Ticket ticket2 = new Ticket("MSC", "KAZ", 100_000, 14, 19);
        Ticket ticket3 = new Ticket("MSC", "ADL", 120_000, 12, 14);
        Ticket ticket4 = new Ticket("MSC", "UFA", 50_000, 11, 20);
        Ticket ticket5 = new Ticket("MSC", "SPB", 5_000, 8, 14); //6
        Ticket ticket6 = new Ticket("MSC", "SPB", 5_000, 10, 19); //9
        Ticket ticket7 = new Ticket("MSC", "SPB", 5_000, 22, 6); //8

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = avia.search("MSC", "SPB", comparator);
        Ticket[] expected = {ticket1, ticket5, ticket7, ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTimeOne() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("MSC", "SPB", 10_000, 10, 14); //4
        Ticket ticket2 = new Ticket("MSC", "KAZ", 100_000, 14, 19);
        Ticket ticket3 = new Ticket("MSC", "ADL", 120_000, 12, 14);
        Ticket ticket4 = new Ticket("MSC", "UFA", 50_000, 11, 20);
        Ticket ticket5 = new Ticket("MSC", "SPB", 5_000, 8, 14); //6
        Ticket ticket6 = new Ticket("MSC", "SPB", 5_000, 10, 19); //9
        Ticket ticket7 = new Ticket("MSC", "SPB", 5_000, 22, 6); //8

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = avia.search("MSC", "ADL", comparator);
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTimeZero() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("MSC", "SPB", 10_000, 10, 14); //4
        Ticket ticket2 = new Ticket("MSC", "KAZ", 100_000, 14, 19);
        Ticket ticket3 = new Ticket("MSC", "ADL", 120_000, 12, 14);
        Ticket ticket4 = new Ticket("MSC", "UFA", 50_000, 11, 20);
        Ticket ticket5 = new Ticket("MSC", "SPB", 5_000, 8, 14); //6
        Ticket ticket6 = new Ticket("MSC", "SPB", 5_000, 10, 19); //9
        Ticket ticket7 = new Ticket("MSC", "SPB", 5_000, 22, 6); //8

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = avia.search("MSC", "LA", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }


}
