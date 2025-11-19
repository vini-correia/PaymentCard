package JavaClasses.Service;

import JavaClasses.Account2;
import JavaClasses.dao.AccountDao;
import JavaClasses.repository.AccountRepository;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

@Service

public class AccountService {

    public final AccountRepository accountRepository;



    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }


    public Account2 createAccount (Account2 accontBody){
        Account2 AccontCreated = accountRepository.save(accontBody);
        return AccontCreated;

    }

    public Account2 getAccountById(Long id) {

        Optional<Account2> optionalAccount = accountRepository.findById(id);
        return optionalAccount.orElse(null);


    }




}
