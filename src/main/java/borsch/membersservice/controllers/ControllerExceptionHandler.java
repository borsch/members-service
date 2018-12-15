package borsch.membersservice.controllers;

import borsch.membersservice.domain.response.ResultResponse;
import borsch.membersservice.exceptions.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResultResponse handle(BaseException e) {
        return ResultResponse.of(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultResponse handle(Exception e) {
        return ResultResponse.of(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResultResponse handle(AccessDeniedException e) {
        return ResultResponse.of(HttpStatus.FORBIDDEN.value(), "You have no permission to access this resource");
    }

}
