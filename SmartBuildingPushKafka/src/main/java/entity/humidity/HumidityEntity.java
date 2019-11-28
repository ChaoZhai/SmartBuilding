package entity.humidity;

import com.alibaba.fastjson.JSONObject;

public class HumidityEntity extends JSONObject {

    private String name;
    private FloorMeta meta;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FloorMeta getMeta() {
        return meta;
    }

    public void setMeta(FloorMeta meta) {
        this.meta = meta;
    }
}
