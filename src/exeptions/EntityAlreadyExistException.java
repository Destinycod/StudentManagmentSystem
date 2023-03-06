package exeptions;

public class EntityAlreadyExistException extends ServiceException{
    public EntityAlreadyExistException(String message){
        super(message);
    }
}
