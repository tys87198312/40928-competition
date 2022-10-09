package com.dragee.constants;

/**
 * @author tys on 2/4/21
 */
public enum Msg {
    CHECK_SUC("check_suc", "检测成功", "info"),
    START_SUC("start_suc", "启动成功", "info"),
    CHECK_OUTTIME("check_outTime", "检测超时", "error"),
    START_OUTTIME("start_outTime", "启动超时", "error"),
    STOP_OUTTIME("stop_outTime", "停止超时", "error"),
    STOP_SUC("stop_suc", "停止成功", "info"),
    CHECK_FAIL("check_fail", "检测失败", "error"),
    START_FAIL("start_fail", "启动失败", "error"),
    STOP_FAIL("stop_fail", "停止失败", "error"),
    HAS_INS("has_ins", "存在正在执行的路线", "warning"),
    SEND_PATH_FAIL("send_path_fail", "发送路线失败", "error"),
    SEND_PATH_SUC("send_path_suc", "发送路线成功", "info"),
    WORK_FINISH("work_finish", "到达终点,作业完成", "info"),
    ARRIVE_WORK_POINT("arrive_work_point", "到达续作点", "info"),
    ARRIVE_HOME_POINT("arrive_home_point", "到达返场点", "info"),
    READY_GO_HOME("ready_go_home", "准备返场", "info"),
    GO_HOMING("go_homing", "返场中", "info"),
    GO_WORK_POINT("go_work_point", "返回续作点中", "info"),
    CAR_OFFLINE("carOffline", "车辆下线", "error"),
    CAR_ONLINE("carOnline", "车辆上线", "info")
    ;
    private String msgType;
    private String msgContent;
    private String msgLevel;


    Msg(String msgType, String msgContent, String msgLevel) {
        this.msgType = msgType;
        this.msgContent = msgContent;
        this.msgLevel = msgLevel;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public String getMsgLevel() {
        return msgLevel;
    }


}
