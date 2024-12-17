package pl.dk.accounts_service.account;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.dk.accounts_service.account.dtos.AccountDto;
import pl.dk.accounts_service.account.dtos.CreateAccountDto;

import java.net.URI;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody CreateAccountDto createAccountDto) {
        AccountDto account = accountService.createAccount(createAccountDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.accountNumber())
                .toUri();
        return ResponseEntity.created(uri).body(account);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable String accountId) {
        AccountDto accountById = accountService.getAccountById(accountId);
        return ResponseEntity.ok(accountById);
    }
}
