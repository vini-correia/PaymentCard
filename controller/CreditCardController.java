package JavaClasses.controller;

import JavaClasses.Model.CreditCard;
import JavaClasses.Service.CreditCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/credit-cards")

public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCard creditCardBody) {

        CreditCard creditCard = creditCardService.createCreditCard(creditCardBody);

        URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(creditCard.getCardNumber())
                .toUri();

        return ResponseEntity.created(location).body(creditCard);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CreditCard> getCreditCard(@PathVariable("id") Long id) {
//        CreditCard creditcard = creditCardService.getCreditCardById(id);
//
//
//        if (creditcard != null) {
//            return ResponseEntity.ok(creditcard);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/number/{creditCardNumber}")
    public ResponseEntity<String> getCreditCards(@PathVariable("creditCardNumber")  String creditCardNumber) {
        return ResponseEntity.ok(creditCardNumber);

    }

    @GetMapping("/email/{email}")
    public ResponseEntity<String> getByEmail(@PathVariable("email")  String email) {
        return ResponseEntity.ok(email);
    }

    @GetMapping("/holder/{cardHolderName}")
    public ResponseEntity<String> getByHolderName(@PathVariable("cardHolderName") String cardHolderName) {
        return ResponseEntity.ok(cardHolderName);
    }

    @GetMapping("/{creditCardNumber}")
    public ResponseEntity<CreditCard> getCreditCardByNumber(@PathVariable("creditCardNumber") String creditCardNumber) {
        Optional<CreditCard> creditCard = creditCardService.getCreditCardByNumber(creditCardNumber);
        return ResponseEntity.ok(creditCard.get());
    }


}
