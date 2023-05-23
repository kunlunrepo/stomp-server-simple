package com.msb.controller;

import com.msb.model.dto.ChannelDto;
import com.msb.model.dto.MultiMsgDto;
import com.msb.model.dto.ResponseDto;
import com.msb.model.dto.SingleMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-22 20:39
 */
@Controller
public class StompController {

    private static final Logger log = LoggerFactory.getLogger(StompController.class);

    // 发送消息的模板类
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // 所有频道推送
    @MessageMapping("/client-channel")
    @SendTo("/server-send/channel") // /server-send-multi必须在代理里面
    public List<ChannelDto> sendChannel() {
        List<ChannelDto> channelDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ChannelDto channelDto = new ChannelDto();
            channelDto.setChannelId("channel#"+i);
            channelDto.setChannelName("频道"+i);
            channelDtoList.add(channelDto);
        }

        // 返回至发送方
        log.info("【send-channel】 --- 返回至发送方消息：{}", channelDtoList);
        return channelDtoList;
    }

    // 单频道 接收请求和推送响应
    @MessageMapping("/client-send-single")
    public ResponseDto sendSingle(SingleMsgDto singleMsgDto) {
        log.info("【send-single】--- 接收到消息：{}", singleMsgDto);
        // 获取请求参数

        // 保存信息
        singleMsgDto.setSendTime(LocalDateTime.now());

        // 组装响应参数
        ResponseDto response = new ResponseDto();
        response.setCode(1);
        response.setMsg("消息推送成功");
        SingleMsgDto msgDto = new SingleMsgDto();
        BeanUtils.copyProperties(singleMsgDto, msgDto);
        response.setData(msgDto);

        // 推送至接收方
        this.simpMessagingTemplate.convertAndSendToUser(msgDto.getReceiptId(), "/", response);
        log.info("【send-single】 --- 推送至接收方消息：{}", response);

        // 返回至发送方
        log.info("【send-single】 --- 返回至发送方消息：{}", response);
        return response;
    }

    // 多频道 接收请求和推送响应
    @MessageMapping("/client-send-multi")
    @SendTo("/server-send-multi/response") // /server-send-multi必须在代理里面
    public ResponseDto sendMulti(MultiMsgDto multiMsgDto) {
        log.info("【send-multi】--- 接收到消息：{}", multiMsgDto);
        // 获取请求参数

        // 保存信息
        multiMsgDto.setSendTime(LocalDateTime.now());

        // 组装响应参数
        ResponseDto response = new ResponseDto();
        response.setCode(1);
        response.setMsg("消息推送成功");
        MultiMsgDto msgDto = new MultiMsgDto();
        BeanUtils.copyProperties(multiMsgDto, msgDto);
        response.setData(msgDto);

        // 返回至发送方
        log.info("【send-multi】 --- 返回至发送方消息：{}", response);
        return response;
    }

}
