package com.hadas.zooticketssystem.steps;

import com.hadas.zooticketssystem.ZooTicketsSystemApplication;
import com.hadas.zooticketssystem.businessLogic.Cashier;
import com.hadas.zooticketssystem.businessLogic.Request;
import com.hadas.zooticketssystem.configuration.JmsConfig;
import com.hadas.zooticketssystem.services.TicketServiceImp;
import com.hadas.zooticketssystem.ticket.Ticket;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;


@ContextConfiguration(classes = {ZooTicketsSystemApplication.class, JmsConfig.class})
public class CashierSteps {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private TicketServiceImp ticketService;

    @Given("^I have the request details$")
    public void i_have(List<Request> requests){
        for (Request request : requests) {
            jmsTemplate.convertAndSend("mainQueue", request);
        }
    }

    @When("^I create a new tickets$")
    public void iCreateANewTicket(){
    }

    @Then("^The ticket should be$")
    public void theTicketShouldBe(List<Ticket> tickets){
        for (Ticket ticket : tickets) {
            Long id = ticket.getId();
//            Assert.assertTrue(ticketService.isExist(id));
        }

    }
}
