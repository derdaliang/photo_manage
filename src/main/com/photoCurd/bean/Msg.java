package photoCurd.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixuefeng
 * @date 2021-08-21 23:00
 * @description:返回类
 */
public class Msg {
    int code;
    String message;
    Map<String,Object> map=new HashMap<>();

    public Msg() {
    }

    public Msg(int code, String message, Map<String, Object> map) {
        this.code = code;
        this.message = message;
        this.map = map;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
    public static Msg success(){
        Msg msg=new Msg();
        msg.setCode(200);
        msg.setMessage("处理成功");
        return msg;
    }
    public static Msg fail(){
        Msg msg=new Msg();
        msg.setCode(400);
        msg.setMessage("处理失败");
        return msg;
    }
    public Msg add(String key,Object value){
        this.getMap().put(key,value);
        return this;
    }
}
