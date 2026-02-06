package br.com.payments.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.RestAssured.given;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

//@TestPropertySource(properties = {
//        // Configuração do Banco de Dados
//        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL",
//        "spring.datasource.driver-class-name=org.h2.Driver",
//        "spring.datasource.username=sa",
//        "spring.datasource.password=",
//        "spring.jpa.hibernate.ddl-auto=create-drop",
//        "spring.jpa.show-sql=true",
//        "spring.jpa.properties.hibernate.format_sql=true",
//        "spring.h2.console.enabled=true",
//        "spring.h2.console.path=/h2-console"
//})

public class AccountControllerIT {
    @LocalServerPort
    private int port;

    @Test
    public void shouldRegisterAnAccount() throws InterruptedException {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        System.out.println("------------------------------------------------");
        System.out.println("ACESSE O H2 EM: http://localhost:" + port + "/h2-console");
        System.out.println("------------------------------------------------");

        String jsonBody = """
                {
                "birthDay":"1990-05-20",
                "fullName":"John2 Doe",
                "email":"ro12222111332o@example.com"
                }
                """;


        given()
        .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post( "/api/v1/accounts")
                .then()
                .statusCode(201);




        Thread.sleep(400000);



    }
}
