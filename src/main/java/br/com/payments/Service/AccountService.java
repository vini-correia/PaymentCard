package br.com.payments.Service;

import br.com.payments.Model.Account;
import br.com.payments.repository.AccountRepository;
import br.com.payments.repository.CreditCardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service

public class AccountService {

    private final AccountRepository accountRepository;
    private final CreditCardRepository creditCardRepository;

    public AccountService(CreditCardRepository crditcardRepository, AccountRepository accountRepository) {
        this.creditCardRepository = crditcardRepository;
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

    @Transactional
    public boolean deleteAccount(Long accountId) {
        if (accountRepository.existsById(accountId)) {

            creditCardRepository.deleteByAccountId(accountId);
            accountRepository.deleteById(accountId);
            return true;
        }
        return false;
    }




}
