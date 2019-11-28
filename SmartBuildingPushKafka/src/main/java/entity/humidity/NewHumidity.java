package entity.humidity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 每个楼层的数据结构（去除无用的参数）
 */
public class NewHumidity {

    private Integer buildingFloor;
    //key为room value为对应room的data
    private List<Map<String, BigDecimal>> map;

    public List<Map<String, BigDecimal>> getMap() {
        return map;
    }

    public void setMap(List<Map<String, BigDecimal>> map) {
        this.map = map;
    }

    public Integer getBuildingFloor() {
        return buildingFloor;
    }

    public void setBuildingFloor(Integer buildingFloor) {
        this.buildingFloor = buildingFloor;
    }

    @Override
    public String toString() {
        return "NewHumidity{" +
                "buildingFloor=" + buildingFloor +
                ", map=" + map +
                '}';
    }
}
