package com.dragee.constants;

public enum Sms {

    LOGIN_VERIFICATION_CODE(" login","SMS_130815023"),
    REGISTER_VERIFICATION_CODE("bindTel","SMS_130815021"),
    PASSWORD_VERIFICATION_CODE("updatePwd","SMS_130815020")
    ;
    private String type;

    Sms(String type, String templateCode) {
        this.type = type;
        this.templateCode = templateCode;
    }

    private String templateCode;

    public String getTemplateCode() {
        return templateCode;
    }

    public String getType() {
        return type;
    }
}
