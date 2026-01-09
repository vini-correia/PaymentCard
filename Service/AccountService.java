package JavaClasses.Service;

import JavaClasses.Model.Account;
import JavaClasses.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AccountService {

    public final AccountRepository accountRepository;



    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }


    public Account createAccount (Account accontBody){
        Account AccontCreated = accountRepository.save(accontBody);
        return AccontCreated;

    }

    public Account getAccountById(Long id) {

        Optional<Account> optionalAccount = accountRepository.findById(id);
        return optionalAccount.orElse(null);


    }

    public boolean deleteAccount(Long accountId) {
        if (accountRepository.existsById(accountId)) {
            accountRepository.deleteById(accountId);
            return true;
        }
        return false;
    }




}
