package entity.humidity;

import java.math.BigDecimal;

/**
 * @ClassName RoomData
 * @Description: TODO
 * @Author 超
 * @Date 2019/10/1
 * @Version V1.0
 **/
public class RoomData {
    private String roomNo;
    private BigDecimal value;


    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
