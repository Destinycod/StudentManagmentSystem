package exeptions;

public class UnableCloseConnectionException extends ServiceException {
    public UnableCloseConnectionException(String message){
        super(message);
    }
}
