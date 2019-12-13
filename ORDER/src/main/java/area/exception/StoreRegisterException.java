package area.exception;

public class StoreRegisterException extends Exception {

    private String code;

    public StoreRegisterException() {
        super();
    }

    public StoreRegisterException(String code, String message) {
        super(message);
        this.code=code;
    }

    public StoreRegisterException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }


    public String getCode() {
        return code;
    }

}
