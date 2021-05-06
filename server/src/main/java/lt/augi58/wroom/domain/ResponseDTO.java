package lt.augi58.wroom.domain;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

    private Boolean success;
    private String message;

    public ResponseDTO(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
