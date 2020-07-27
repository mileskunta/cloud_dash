package com.ezhupai.vo.sh122;

/**
 * Created by Administrator on 2018/8/26.
 */
public class ResponseVo {
    private String message;
    private String code;
    private ContentVo data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ContentVo getData() {
        return data;
    }

    public void setData(ContentVo data) {
        this.data = data;
    }
}
