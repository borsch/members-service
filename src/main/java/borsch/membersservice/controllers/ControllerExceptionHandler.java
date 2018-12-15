package borsch.membersservice.controllers;

import borsch.membersservice.domain.response.ResultResponse;
import borsch.membersservice.exceptions.BaseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ControllerExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResultResponse handle(BaseException e) {
        return ResultResponse.of(e.getCode(), e.getMessage());
    }

}
