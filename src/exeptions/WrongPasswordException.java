package exeptions;

public class WrongPasswordException extends ServiceException {

    public WrongPasswordException(){

    }
    public WrongPasswordException(String message){
        super(message);
    }

}
