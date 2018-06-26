package ru.kharkov.tinkoff.handler;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kharkov.tinkoff.exception.SimpleDataException;

import javax.validation.ConstraintViolationException;

/**
 * @author m.kharkov
 * @since 22.06.18
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponse handleConstraintValidationError(ConstraintViolationException e) {
        String title = "Ошибка валидации данных";
        log.error(title, e);
        return new ErrorResponse(title, e);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(SimpleDataException.class)
    public ErrorResponse handleConverterException(SimpleDataException e) {
        String title = "Ошибка";
        log.error(title, e);
        return new ErrorResponse(title, e);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleServerException(Exception e) {
        String title = "Internal Server Error";
        log.error(title, e);
        return new ErrorResponse(title, e.getMessage());
    }

    @Getter
    @Setter
    private class ErrorResponse {

        private String errorTitle;
        private String errorMessage;

        public ErrorResponse(String errorTitle, String errorMessage) {
            this.errorTitle = errorTitle;
            this.errorMessage = errorMessage;
        }

        public ErrorResponse(String errorTitle, Throwable throwable) {
            this(errorTitle, throwable.getMessage());
        }
    }
}
