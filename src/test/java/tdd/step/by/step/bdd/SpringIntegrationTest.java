package tdd.step.by.step.bdd;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import tdd.step.by.step.TddStepByStepApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TddStepByStepApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class SpringIntegrationTest {

    private static final String SERVER_URL = "http://localhost:";

    protected ResponseEntity<String> response;

    @LocalServerPort
    private int port;

    @Autowired
    protected TestRestTemplate restTemplate;

    public SpringIntegrationTest() {
        this.restTemplate = new TestRestTemplate();
    }

    public void executeGet(String endPoint) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        response = restTemplate.getForEntity(prepareUrl(endPoint), String.class, headers);
    }

    protected String prepareUrl(String endPoint){
        StringBuilder sb = new StringBuilder(SERVER_URL);
        sb.append(port).append("/").append(endPoint);
        return sb.toString();
    }
}
