package by.epam.labproject.createmypc.controller.validation.messages;

public class Message {

    public final static String USER_NAME_NULL = "Login can not be empty!";
    public final static String PASSWORD_NULL = "Password can not be empty!";
    public final static String EMAIL_NULL = "Email can not be empty!";
    private String errorText;

     Message() {
    }

    public Message(String errorText){
         this.errorText= errorText;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
