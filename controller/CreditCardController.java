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

//    @GetMapping("/number/{creditCardNumber}")
//    public ResponseEntity<String> getCreditCards(@PathVariable("creditCardNumber")  String creditCardNumber) {
//        return ResponseEntity.ok(creditCardNumber);
//
//    }

    @GetMapping("/holder/{cardHolderName}")
    public ResponseEntity<String> getByHolderName(@PathVariable("cardHolderName") String cardHolderName) {
        return ResponseEntity.ok(cardHolderName);

    }

    @GetMapping("/number/{creditCardNumber}")
    public ResponseEntity<CreditCard> getCreditCardByNumber(@PathVariable("creditCardNumber") String creditCardNumber) {
        Optional<CreditCard> creditCard = creditCardService.getCreditCardByNumber(creditCardNumber);
        return creditCard.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<CreditCard> getByEmail (@RequestParam("email") String email) {
        Optional<CreditCard> creditCardOptional = creditCardService.findByAccountEmail(email);
        if (creditCardOptional.isPresent()) {
            CreditCard creditCard = creditCardOptional.get();
            return ResponseEntity.ok(creditCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{cardNumber}")
    public ResponseEntity<CreditCard> updateCreditCard(
            @PathVariable("cardNumber") String cardNumber,
            @RequestBody CreditCard creditCardBody) {

        Optional<CreditCard> updatedCard = creditCardService.updateCreditCard(cardNumber, creditCardBody);
        return updatedCard.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cardNumber}")
    public ResponseEntity<Void> deleteCreditCard(@PathVariable("cardNumber") String cardNumber) {
        boolean deleted = creditCardService.deleteCreditCard(cardNumber);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
