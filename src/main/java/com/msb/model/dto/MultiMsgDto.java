package com.msb.model.dto;

import java.time.LocalDateTime;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-22 20:50
 */
public class MultiMsgDto {

    // 发送方编号
    private String sendId;

    // 发送方名称
    private String sendName;

    // 发送内容
    private String sendMsg;

    // 发送时间
    private LocalDateTime sendTime;

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(String sendMsg) {
        this.sendMsg = sendMsg;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "SingleMsgDto{" +
                "sendId='" + sendId + '\'' +
                ", sendName='" + sendName + '\'' +
                ", sendMsg='" + sendMsg + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
