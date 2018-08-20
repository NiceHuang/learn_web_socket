package cn.hnx.server;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by viruser on 2018/8/18.
 */
@ServerEndpoint(value = "/webSocketServer/{userName}")
@Component
public class WebSocketServer{
    private static final Set<WebSocketServer> connections = new CopyOnWriteArraySet<>();

    private String nickname;
    private Session session;
    private static Set<String> onlineUser = new HashSet<>();
    private static Set<String> offlineUser = new HashSet<>();
    private Map<String, Object> messages = new HashMap<>();


    private static String getDatetime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    @OnOpen
    public void start(@PathParam("userName") String userName, Session session) {
        this.nickname = userName;
        this.session = session;
        connections.add(this);
        onlineUser.add(nickname);
        if (offlineUser.contains(nickname)){
            offlineUser.remove(nickname);
        }
        messages.put("onlineUser", onlineUser);
        messages.put("offlineUser", offlineUser);
        String message = String.format("* %s %s", nickname, "加入聊天！");
        messages.put("message", message);
        broadcast(messages);
    }

    @OnClose
    public void end() {
        connections.remove(this);
        offlineUser.add(nickname);
        if (onlineUser.contains(nickname)){
            onlineUser.remove(nickname);
        }
        messages.put("onlineUser", onlineUser);
        messages.put("offlineUser", offlineUser);
        String message = String.format("* %s %s", nickname, "退出聊天！");
        messages.put("message", message);
        broadcast(messages);
    }

    @OnMessage
    public void pushMsg(String message) {
        message = "【" + this.nickname + "】" + getDatetime(new Date()) + " : " + message;
        messages.put("message", message);
        broadcast(messages);
    }

    @OnError
    public void onError(Throwable t) throws Throwable {

    }

    private static void broadcast(Object msg) {
        // 广播形式发送消息
        String meaasge = JSON.toJSONString(msg);
        for (WebSocketServer client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(meaasge);
                }
            } catch (Exception e) {
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    e.printStackTrace();
                }
                String message = String.format("* %s %s", client.nickname, "断开连接");
                broadcast(message);
            }
        }
    }
}
