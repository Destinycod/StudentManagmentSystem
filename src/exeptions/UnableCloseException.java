package exeptions;

public class UnableCloseException extends DAOException {
    public UnableCloseException(String message){
        super(message);
    }
}
