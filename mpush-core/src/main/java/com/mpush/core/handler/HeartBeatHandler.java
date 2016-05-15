package com.mpush.core.handler;

import com.mpush.api.MessageHandler;
import com.mpush.api.connection.Connection;
import com.mpush.api.protocol.Packet;
import com.mpush.log.LogType;
import com.mpush.log.LoggerManage;

/**
 * Created by ohun on 2015/12/22.
 */
public final class HeartBeatHandler implements MessageHandler {

    @Override
    public void handle(Packet packet, Connection connection) {
        connection.send(packet);//ping -> pong
        LoggerManage.log(LogType.HEARTBEAT, "response client heartbeat:{}, {}",
                connection.getChannel(), connection.getSessionContext().deviceId);
    }
}