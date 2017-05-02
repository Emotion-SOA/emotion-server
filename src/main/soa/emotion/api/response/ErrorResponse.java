package emotion.api.response;

/**
 * Created by lifengshuang on 29/04/2017.
 */
public class ErrorResponse {

    private String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
