package org.example.integration;

import br.com.payments.MainClone;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SpringBootTest(
        classes = MainClone.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerITIT {

    @LocalServerPort
    private int port;

    @Value("classpath:integration.payloads/account-payload.json")
    private Resource accountCreateJson;

    @Test
    public void shouldRegisterAnAccount() throws IOException {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        String jsonContent = accountCreateJson.getContentAsString(StandardCharsets.UTF_8);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonContent)
                .when()
                .post("/api/v1/account")
                .then()
                .log().all();

    }

}
