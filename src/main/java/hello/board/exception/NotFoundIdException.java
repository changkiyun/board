package hello.board.exception;

public class NotFoundIdException extends RuntimeException{
    public NotFoundIdException() {
        super();
    }

    public NotFoundIdException(String message) {
        super(message);
    }

    public NotFoundIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundIdException(Throwable cause) {
        super(cause);
    }

    protected NotFoundIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
