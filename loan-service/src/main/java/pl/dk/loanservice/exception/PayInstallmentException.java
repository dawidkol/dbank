package pl.dk.loanservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class PayInstallmentException extends RuntimeException {

    public PayInstallmentException(String msg) {
        super(msg);
    }
}
