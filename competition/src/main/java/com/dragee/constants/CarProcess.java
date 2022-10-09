package com.dragee.constants;

/** 车状态
 * @author tys on 12/5/20
 */
public enum CarProcess {

    CONFIGCAR("configCar", "配置车"),
    OPERATIONCAR("OperationCar", "运营车"),
    WAITBIND("waitBind", "待绑定"),
    BINDOVER("bindOver", "已绑定")

    ;

    private String value;
    private String text;

    CarProcess(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public static String getText (String value) {
        for (CarProcess carStatus : values()) {
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
