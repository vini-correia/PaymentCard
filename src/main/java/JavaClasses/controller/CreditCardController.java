package JavaClasses.controller;

import JavaClasses.CreditCard2;
import JavaClasses.Model.CreditCard;
import JavaClasses.Service.CreditCardService;
import JavaClasses.dao.CreditCardDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cards")

public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCard creditCard) {

        CreditCard2 creditCard = creditCardService.createCredotCard(creditCardBody);
    }

}
