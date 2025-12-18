package me.example.acceptance.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class HealthCheckSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @When("^GET /health API를 요청하면$")
    public void requestGetHealthApi() {
        response = restTemplate.getForEntity("/health", String.class);
    }

    @Then("응답 상태 코드는 {int} 이어야 한다.")
    public void verifyStatusCode(int expectedStatusCode) {
        assertThat(response.getStatusCode().value()).isEqualTo(expectedStatusCode);
    }

    @And("응답 본문은 {string} 이어야 한다.")
    public void verifyResponseBody(String expectedBody) {
        assertThat(response.getBody()).isEqualTo(expectedBody);
    }
}
