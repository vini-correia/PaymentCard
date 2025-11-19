package JavaClasses.Service;

import JavaClasses.CreditCard2;
import JavaClasses.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CreditCardService {

    public final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCard2 createCreditCard(CreditCard2 creditCardBody) {

        CreditCard2 creditcard = creditCardRepository.save(creditCardBody);
        return creditcard;
    }

    public CreditCard2 getCreditCardById(Long id){

        Optional<CreditCard2> optionalCreditCard = creditCardRepository.findById(id);
        return optionalCreditCard.orElse(null);
    }



}
