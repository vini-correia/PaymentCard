//package org.example.integration;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.core.io.Resource;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class AccountControllerIT {
//
//    @LocalServerPort
//    private int port;
//
//    @Value("classpath:integration.payloads/account-payload.json")
//    private Resource accountCreateJson;
//
//    @Test
//    public void shoulfRegisterAnAccount() throws IOException {
//        RestAssured.baseURI = "http://localhost";
//        RestAssured.port = port;
//
//        String jsonContent = accountCreateJson.getContentAsString(StandardCharsets.UTF_8);
//
//        RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body(jsonContent)
//                .when()
//                .post("/apu/v1/account")
//                .then()
//                .log().all();
//
//    }
//
//}
