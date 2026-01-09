package JavaClasses.repository;

import JavaClasses.Model.CreditCard;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, String> {

    Optional<CreditCard> findByCardNumber(String cardNumber);

    @Query("SELECT c FROM CreditCard c WHERE c.accountId IN (SELECT a.id FROM Account a WHERE a.email = :email)")
    Optional<CreditCard> buscarCartaoPeloEmail(@Param("email") String email);
}

