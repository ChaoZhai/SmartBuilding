package entity.humidity;

import com.alibaba.fastjson.JSONObject;

public class HumidityBrokerage extends JSONObject {

    private HumidityBroker humidityBroker;
    private String id;
    private BuildingMeta buildingMeta;


    public HumidityBroker getHumidityBroker() {
        return humidityBroker;
    }

    public void setHumidityBroker(HumidityBroker humidityBroker) {
        this.humidityBroker = humidityBroker;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BuildingMeta getBuildingMeta() {
        return buildingMeta;
    }

    public void setBuildingMeta(BuildingMeta buildingMeta) {
        this.buildingMeta = buildingMeta;
    }
}
