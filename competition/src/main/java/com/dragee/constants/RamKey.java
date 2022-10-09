package com.dragee.constants;

/**
 * @author tys on 12/10/20
 */
public interface RamKey {

    /*所有车辆 set*/
    String ALL_CAR = "wcc_allCar";
    /*当前在线车辆 string*/
    String ONLINE_CAR = "wcc_onlineCar";
    /*当前订阅的topic set*/
    String TOPIC_SUBS = "wcc_topicSubs";
    /*活跃时间 string*/
    String CAR_ACTIVE = "wcc_carActive";
    /*gps*/
    String GPS = "wcc_gps";
    /*task*/
    String TASK = "wcc_task";
    /*mileage*/
    String MILEAGE = "wcc_mileage";
    /*activeIns*/
    String ACTIVE_INS = "wcc_activeIns";
    /*作业区域*/
    String WORKSPACE_POINTS = "wcc_workspacePoints";
    /*是否在作业区域*/
    String IS_WORKSPACE = "wcc_isWorkSpace";
    /*作业关键点*/
    String KEY_POINT = "wcc_keyPoint";
    /*短信验证码*/
    String SMS_CODE_LOGIN = "wcc_smsCode_login";
    /*短信验证码*/
    String SMS_CODE_UPDATEPWD = "wcc_smsCode_updatePwd";
    /*短信验证码*/
    String SMS_CODE_BINDTEL = "wcc_smsCode_bindTel";
    /* 当前作业执行进度*/
    String CAR_WORK_PLAN = "wcc_carWorkPlan";
    /*一条指令的gps信息集合 */
    String LIST_GPS = "wcc_list_gps";
    /*指令开始*/
    String TASK_START = "wcc_task_start";
    /*步数*/
    String STEP_COUNT = "step_count";
    /*记录运输车录入的区域号和大鹏号*/
    String transport_point = "wcc_transport_point";
    /*巡检车可以写入数据key*/
    String person_monitor_write = "wcc_person_monitor_write";
}
