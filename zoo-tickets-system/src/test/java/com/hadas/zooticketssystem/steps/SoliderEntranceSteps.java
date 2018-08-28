package com.hadas.zooticketssystem.steps;

import com.hadas.zooticketssystem.services.TicketServiceImp;
import com.hadas.zooticketssystem.services.VisitorServiceImp;
import com.hadas.zooticketssystem.ticket.Ticket;
import com.hadas.zooticketssystem.visitors.Solider;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

public class SoliderEntranceSteps {
    @Autowired
    private TicketServiceImp ticketService;
    @Autowired
    private VisitorServiceImp visitorService;

    @Given("^I have solider details$")
    public void i_have(){
    }

    @When("^I apply solider post entrance request$")
    public void iApplySoliderPostEntranceRequest(List<Solider> entrances){
        for (Solider entrance : entrances) {
            this.visitorService.save(entrance);
        }
    }

    @Then("^The solider ticket should be$")
    public void theSoliderTicketShouldBe(List<Ticket> expectedTickets){
        for (Ticket ticket : expectedTickets) {
            isExistInDataBase(ticket);
        }
    }

    private void isExistInDataBase(Ticket expectedTicket) {
        Ticket ticketFromDB = this.ticketService.getById(expectedTicket.getId()).get();
        Assert.assertEquals(expectedTicket.getId(), ticketFromDB.getId());
        Assert.assertEquals(expectedTicket.getPrice(), ticketFromDB.getPrice());
        Assert.assertEquals(expectedTicket.getEntranceTime(), ticketFromDB.getEntranceTime());
    }
}
