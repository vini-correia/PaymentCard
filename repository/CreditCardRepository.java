package JavaClasses.repository;

import JavaClasses.Model.CreditCard;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, String> {

    Optional<CreditCard> findByCardNumber(String cardNumber);
    //Optional<CreditCard> findByEmail(String email);
}
