package dto.common;

/**
 * Created by rajjasti on 3/20/17.
 */
public class ErrorResponse {

    private String message;

    public ErrorResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
