import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Repository repository = new Repository();
    TicketsManager manager = new TicketsManager(repository);


    Ticket ticket1 = new Ticket(1, 10_000, "ABA", "KUF", "15:00");
    Ticket ticket2 = new Ticket(2, 8_000, "VKO", "ABA", "14:00");
    Ticket ticket3 = new Ticket(3, 15_000, "KUF", "VKO", "10:00");
    Ticket ticket4 = new Ticket(4, 12_000, "RSA", "MGA", "08:00");
    Ticket ticket5 = new Ticket(5, 4_000, "VKO", "ABA", "18:00");

    Ticket ticket6 = new Ticket(6, 24_000, "DYU", "KUF", "21:00");


    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void ShouldSearchTickets() {
        Ticket[] expected = {ticket5, ticket2};
        Ticket[] actual = manager.search("VKO", "ABA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchOneTickets() {
        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("RSA", "MGA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldNotSearchTickets() {
        Ticket[] expected = {};
        Ticket[] actual = manager.search("ABV", "GDE");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindALl() {
        Ticket[] expected = {ticket5, ticket2, ticket1, ticket4, ticket3};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }



    @Test

    public void ShouldGetId() {
        int expected = 1;
        int actual = ticket1.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ShouldSetId() {
        ticket1.setId(8);
        int expected = 8;
        int actual = ticket1.getId();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void ShouldGetPrice() {
        int expected = 10_000;
        int actual = ticket1.getPrice();
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ShouldSetPrice() {
        ticket1.setPrice(100_000);
        int expected = 100_000;
        int actual = ticket1.getPrice();
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ShouldGetFrom() {
        String expected = "ABA";
        String actual = ticket1.getFrom();
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ShouldSetFrom() {
        ticket1.setFrom("ABS");
        String expected = "ABS";
        String actual = ticket1.getFrom();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldGetTo() {
        String expected = "KUF";
        String actual = ticket1.getTo();
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ShouldSetTo() {
        ticket1.setTo("RSA");
        String expected = "RSA";
        String actual = ticket1.getTo();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldGetTime() {
        String expected = "15:00";
        String actual = ticket1.getTime();
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ShouldSetTime() {
        ticket1.setTime("19:00");
        String expected = "19:00";
        String actual = ticket1.getTime();
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ShouldAddTicket() {
        repository.save(ticket6);
        Ticket[] expected = {ticket5, ticket2, ticket1, ticket4, ticket3, ticket6};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void ShouldRemoveById() {
        repository.removeById(3);
        Ticket[] expected = {ticket5, ticket2, ticket1, ticket4};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void ShouldFindById() {
        Ticket expected = ticket5;
        Ticket actual = repository.findById(5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldNotFindById() {
        Ticket expected = null;
        Ticket actual = repository.findById(15);
        Assertions.assertEquals(expected, actual);
    }







}
