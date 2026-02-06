package br.com.payments.Service;

import br.com.payments.Model.CreditCard;
import br.com.payments.repository.CreditCardRepository;
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

    public Optional<CreditCard> findByAccountEmail(String email) {
        return creditCardRepository.buscarCartaoPeloEmail(email);
    }


    public Optional<CreditCard> updateCreditCard(String cardNumber, CreditCard cardAtualizado) {

        Optional<CreditCard> creditCardOptional = creditCardRepository.findById(cardNumber);
        
       if (creditCardOptional.isPresent())
        {
            creditCardOptional.get().setCardHolderName(cardAtualizado.getCardHolderName());

            creditCardOptional.get().setLimit(cardAtualizado.getLimit());

            CreditCard creditCardUpdated = creditCardRepository.save(creditCardOptional.get());
            return Optional.of(creditCardUpdated);
        }


        return creditCardOptional;
    }

    public boolean deleteCreditCard(String cardNumber) {
        if (creditCardRepository.existsById(cardNumber)) {
            creditCardRepository.deleteById(cardNumber);
            return true;
        }
        return false;
    }


}
