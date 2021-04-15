package builder;

public class RequeredArgsMSSQLConnectionBuilderException extends RuntimeException{
    public RequeredArgsMSSQLConnectionBuilderException() {
    }

    public RequeredArgsMSSQLConnectionBuilderException(String message) {
        super(message);
    }

    public RequeredArgsMSSQLConnectionBuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequeredArgsMSSQLConnectionBuilderException(Throwable cause) {
        super(cause);
    }

    public RequeredArgsMSSQLConnectionBuilderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
