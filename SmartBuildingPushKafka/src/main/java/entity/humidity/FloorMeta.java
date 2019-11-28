package entity.humidity;

import com.alibaba.fastjson.JSONObject;

public class FloorMeta extends JSONObject {

    private String building;
    private String buildingFloor;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getBuildingFloor() {
        return buildingFloor;
    }

    public void setBuildingFloor(String buildingFloor) {
        this.buildingFloor = buildingFloor;
    }
}
