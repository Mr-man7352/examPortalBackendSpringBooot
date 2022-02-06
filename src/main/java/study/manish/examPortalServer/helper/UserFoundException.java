package study.manish.examPortalServer.helper;

public class UserFoundException extends Exception{
    public UserFoundException() {
        super("User with this username found in database !!");
    }

    public UserFoundException(String msg) {
        super(msg);
    }
}
