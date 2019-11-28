package entity.humidity;

import com.alibaba.fastjson.JSONObject;

public class BuildingMeta extends JSONObject {

    private String buildingCore;
    private String buildingPlantRoom;


    public String getBuildingCore() {
        return buildingCore;
    }

    public void setBuildingCore(String buildingCore) {
        this.buildingCore = buildingCore;
    }

    public String getBuildingPlantRoom() {
        return buildingPlantRoom;
    }

    public void setBuildingPlantRoom(String buildingPlantRoom) {
        this.buildingPlantRoom = buildingPlantRoom;
    }
}
