import java.util.Arrays;

public class TicketsManager {
    private Repository repository;

    public TicketsManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] search(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length -1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from)) {
        } if (ticket.getTo().contains(to)) {
            return true;
        } else {
            return false;
        }
    }
}
