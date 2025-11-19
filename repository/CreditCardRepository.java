package JavaClasses.repository;

import JavaClasses.Account2;
import JavaClasses.CreditCard2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard2, Long> {
}
