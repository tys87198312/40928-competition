package com.dragee.constants;

/** 车状态
 * @author tys on 12/5/20
 */
public enum  CarStatus {

    ONLINE("online", "已上线"),
    OFFLINE("offline", "未上线"),
    WORKING("working", "作业中"),
    ROUTING("routing", "路线生成中")

    ;

    private String value;
    private String text;

    CarStatus (String value, String text) {
        this.value = value;
        this.text = text;
    }

    public static String getText (String value) {
        for (CarStatus carStatus : values()) {
            if (carStatus.getValue().equals(value)) {
                return carStatus.getText();
            }
        }
        return "";
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
