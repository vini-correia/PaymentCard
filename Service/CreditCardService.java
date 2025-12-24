package JavaClasses.Service;

import JavaClasses.Model.CreditCard;
import JavaClasses.repository.CreditCardRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service

public class CreditCardService {

    public final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCard createCreditCard(CreditCard creditCardBody) {

        CreditCard creditcard = creditCardRepository.save(creditCardBody);
        return creditcard;
    }

//    public CreditCard getCreditCardById(Long id){
//
//        //Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
//        return optionalCreditCard.orElse(null);
//    }

    public Optional<CreditCard> getCreditCardByNumber(String cardNumber) {
        Optional<CreditCard> foundCard = creditCardRepository.findByCardNumber(cardNumber);

        if(foundCard.isEmpty()){
            System.out.println("No credit card found");
            return Optional.empty();
        }
        return foundCard;
    }

////    public CreditCard getCreditCardByEmail(String email) {
////        Optional<CreditCard> foundCard = creditCardRepository.findByEmail(email);
////        return foundCard.orElse(null);
//    }



}
