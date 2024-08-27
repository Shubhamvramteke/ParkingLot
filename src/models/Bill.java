package models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private Date exitDate;
    private int amount;
    private Gate gate;
    private Operator currentOperator;
    private Ticket ticket;
    private List<Payment> payments;
}
