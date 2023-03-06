package exeptions;

public class NotExistException extends DAOException {
    public NotExistException(String message){
        super(message);
    }
}
