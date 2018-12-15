package borsch.membersservice.exceptions;

public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public abstract int getCode();
}
