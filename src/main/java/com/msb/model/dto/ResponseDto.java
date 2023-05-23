package com.msb.model.dto;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-22 20:44
 */
public class ResponseDto {

    // 推送状态：0-失败；1-成功
    int code;

    // 提示信息

    String msg;

    // 响应数据
    Object data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
