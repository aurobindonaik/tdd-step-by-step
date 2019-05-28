package tdd.step.by.step.bdd.stepdefs;

import static org.junit.Assert.*;

import java.io.IOException;

import org.springframework.http.HttpStatus;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tdd.step.by.step.bdd.SpringIntegrationTest;

public class HealthzStepDefs extends SpringIntegrationTest {

    @When("client calls the GET end point (.*)")
    public void client_calls_the_GET_end_point(String endPoint) throws IOException {
        executeGet(endPoint);
    }

    @Then("the client receives a response (.*)")
    public void the_client_receives_a_response(String respString) {
        assertEquals(respString, response.getBody());
    }

    @Then("the client receives a status (.*)")
    public void the_client_receives_a_status(String statusString) {
        assertEquals(getResponseStatus(statusString), response.getStatusCode());
    }

    private HttpStatus getResponseStatus(String statusString) {
        HttpStatus httpStatus = null;
        switch(statusString) {
            case "SUCCESS":
            case "success":
                httpStatus = HttpStatus.OK;
                break;
            case "CREATED":
            case "created":
                httpStatus = HttpStatus.CREATED;
                break;
            default:
                httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
        }
        return httpStatus;
    }
}
