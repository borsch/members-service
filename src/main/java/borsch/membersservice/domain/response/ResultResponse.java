package borsch.membersservice.domain.response;

import java.util.Objects;

public class ResultResponse<T> {

    private final T result;
    private final ErrorResponse error;

    private ResultResponse(T result, ErrorResponse error) {
        this.result = result;
        this.error = error;
    }

    public static <T> ResultResponse<T> of(T object) {
        return new ResultResponse<>(object, null);
    }

    public static ResultResponse of(ErrorResponse error) {
        return new ResultResponse<>(null, error);
    }

    public static ResultResponse of(int code, String message) {
        return new ResultResponse<>(null, new ErrorResponse(code, message));
    }

    public T getResult() {
        return result;
    }

    public ErrorResponse getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultResponse<?> that = (ResultResponse<?>) o;
        return Objects.equals(result, that.result) &&
                Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, error);
    }

    @Override
    public String toString() {
        return "ResultResponse{" +
                "result=" + result +
                ", error=" + error +
                '}';
    }
}
