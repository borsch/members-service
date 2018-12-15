package borsch.membersservice.exceptions;

import org.springframework.http.HttpStatus;

public class NoSuchEntityException extends BaseException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    @Override
    public int getCode() {
        return HttpStatus.NOT_FOUND.value();
    }

}
