package controllers;

import dtos.IssueTicketRequestDto;
import dtos.IssuseTicketResponseDto;
import dtos.ResponseStatus;
import model.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    public IssuseTicketResponseDto issueTicket(IssueTicketRequestDto requestDto){
        IssuseTicketResponseDto responseDto=new IssuseTicketResponseDto();
        try{
            Ticket ticket=ticketService.issueTicket(requestDto.getGateId()
                    ,requestDto.getVehicleOwnerName(),requestDto.getVehicleType(),requestDto.getVehicleNumber()
            );

            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setTicket(ticket);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);

        }
        return responseDto;
    }
}
