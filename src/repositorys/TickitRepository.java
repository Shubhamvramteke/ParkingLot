package repositorys;

import models.Ticket;

import java.util.TreeMap;

public class TickitRepository {
    private TreeMap<Integer, Ticket> tickits=new TreeMap<>();
    public static int previousID=0;

    public Ticket saveTicket(Ticket ticket)
    {
        previousID +=1;
        ticket.setId(previousID);
        tickits.put(previousID,ticket);
        return ticket;
    }
}
