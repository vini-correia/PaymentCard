package JavaClasses.controller;

import JavaClasses.Account2;
import JavaClasses.Service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account2> addAccount(@RequestBody Account2 accountBody) {

        Account2 account = accountService.createAccount(accountBody);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();

        return ResponseEntity.created(location).body(account);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account2> getAccountById(@PathVariable Long id) throws SQLException {
        Account2 account = accountService.getAccountById(id);

        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}