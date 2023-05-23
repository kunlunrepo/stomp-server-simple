package com.msb.model.dto;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-23 10:48
 */
public class ChannelDto {

    private String channelId;

    private String channelName;


    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }


    @Override
    public String toString() {
        return "ChannelDto{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                '}';
    }
}
