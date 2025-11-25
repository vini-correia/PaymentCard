package JavaClasses.controller;

import JavaClasses.CreditCard2;
import JavaClasses.Model.CreditCard;
import JavaClasses.Service.CreditCardService;
import JavaClasses.dao.CreditCardDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/credit-cards")

public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public ResponseEntity<CreditCard2> addCreditCard(@RequestBody CreditCard2 creditCardBody) {

        CreditCard2 creditCard = creditCardService.createCreditCard(creditCardBody);

        URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(creditCard.getCardNumber())
                .toUri();

        return ResponseEntity.created(location).body(creditCard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard2> getCreditCard(@PathVariable("id") Long id) {
        CreditCard2 creditcard = creditCardService.getCreditCardById(id);


        if (creditcard != null) {
            return ResponseEntity.ok(creditcard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
