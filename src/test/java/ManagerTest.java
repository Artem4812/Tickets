import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Repository repository = new Repository();
    TicketsManager manager = new TicketsManager(repository);


    Ticket ticket1 = new Ticket(1, 10_000, "ABA", "KUF", "15:00");
    Ticket ticket2 = new Ticket(2, 8_000, "VKO", "ABA", "14:00");
    Ticket ticket3 = new Ticket(3, 15_000, "KUF", "VKO", "10:00");
    Ticket ticket4 = new Ticket(4, 12_000, "VKO", "KUF", "08:00");
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
    public void ShouldFindALl() {
        Ticket[] expected = {ticket5, ticket2, ticket1, ticket4, ticket3};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
