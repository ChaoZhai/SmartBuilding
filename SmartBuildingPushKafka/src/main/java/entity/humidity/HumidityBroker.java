package entity.humidity;

import com.alibaba.fastjson.JSONObject;

public class HumidityBroker extends JSONObject {


    private String id;
    private BuildingMeta meta;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BuildingMeta getMeta() {
        return meta;
    }

    public void setMeta(BuildingMeta meta) {
        this.meta = meta;
    }
}
