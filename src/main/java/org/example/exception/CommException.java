package org.example.exception;

/**
 * @author wzllby
 * @date 2022年11月20日 19:56
 */
public class CommException extends Exception{
    static final long serialVersionUID = -3387516993124229986L;

    public CommException() {
        super();
    }

    public CommException(String msg) {
        super(msg);
    }

    public CommException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommException(Throwable cause) {
        super(cause);
    }

    public CommException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
