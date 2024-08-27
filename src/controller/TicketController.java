package controller;

import Dtos.IssueTicketRequestDto;
import Dtos.IssueTicketResponseDto;
import constants.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto){
        IssueTicketResponseDto responseDto=new IssueTicketResponseDto();
        try {
            Ticket ticket= ticketService.issueTicket(requestDto.getGateId()
                    ,requestDto.getVehicleNumber()
                    ,requestDto.getOwnerName(),
                    requestDto.getVehicleType());
            responseDto.setTicket(ticket);
        }
        catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
//Using the model directly with the client is not suggested
// Instead use DTO: Data Transfer Object