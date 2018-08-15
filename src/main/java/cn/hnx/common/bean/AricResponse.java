package cn.hnx.common.bean;

/**
 * Created by viruser on 2018/8/15.
 */
public class AricResponse {

    private String responseMessage;

    public AricResponse() {
    }

    public AricResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
