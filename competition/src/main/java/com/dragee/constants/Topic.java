package com.dragee.constants;

import com.dragee.common.P;

/**
 * @author tys on 11/17/20
 */
public enum Topic {
    DEMO("demo", 1),
    DEMO_APOLLO_GPS("apollo/gps", 1),
    /*fms*/
    // 心跳
    FMS_HEART_CARID("fms/heart", 0), // 心跳
    FMS_CAR_INDERT("fms/car/indert", 1), // 车辆上线 自己发布自己订阅
    FMS_CAR_DEL("fms/car/del", 1), // 车辆下线 自己发布自己订阅
    FARM_SENSOR_FARMID("farm/sensor", 1),
    FMS_CARSTATUSCHANGE("fms/carStatusChange", 1), // 车辆状态修改
    FMS_REFRESHCAMERA_CARID("fms/refreshcamera", 1), // 刷新摄像头
    FMS_ARMSTOP("fms/armstop", 1), // 机械臂停止
    FMS_ARMINIT("fms/arminit", 1), // 机械臂初始化
    FMS_ARMSTART("fms/armstart", 1), // 机械臂开启
    FMS_PATH_LICENSE("fms/path", 1), // 发送路线
    FMS_REGION_LICENSE("fms/region", 1), // 发送区域
    APOLLO_PATH_LICENSE("apollo/path", 1), // 接受路线返回
    FMS_INSTRUCTION_SEND_UID("fms/instruction/send", 1), // 发送给前端 用于刷新右侧指令列表
    FMS_INSTRUCTION_STATUS_LICENSE("fms/instruction/status", 1), // 发送给前端 指令状态变化
    APOLLO_MSG_LICENSE("apollo/msg", 1), // 车端异常信息
    APOLLO_GPS_LICENSE("apollo/gps", 1), // 车端gps
    APOLLO_MILEAGE_LICENSE("apollo/mileage", 1), // 接收车短的里程累加
    FMS_MILEAGE_LICENSE("fms/mileage", 1), // 接收车短的里程累加
    FMS_TOTALMILEAGE_LICENSE("fms/totalMileage", 1), // 总里程数
    FMS_INSTRUCTION_ADD_LICENSE("fms/instruction/add", 1), // 最新的作业执行页面 刷新右侧指令
    FMS_GREENHOUSENUMBER_LICENSE("fms/greenhousenumber", 1), // 大鹏号校验
    FMS_STARTSLAM_LICENSE("fms/startSlam", 1), // 开启slam

    /*apollo*/
    APOLLO_PROGRESS_LICENSE("apollo/progress", 1), // 监控作业进度
    APOLLO_INSTRUCTION_STATUS_LICENSE("apollo/instruction/status", 1), // 接收车端作业完成指令 释放车辆并改变指令状态
    APOLLO_RESPONSE_LICENSE_OPERATE("apollo/response", 1), // 接收车端作业完成指令 释放车辆并改变指令状态
    APOLLO_HEART_CARID("apollo/heart", 1), // 车端心跳
    APOLLO_MILEAGE_CARID("apollo/mileage", 1), // 里程计
    APOLLO_MSG_CARID("apollo/msg", 1), // 里程计
    APOLLO_INFLECTIONPOINT_LICENSE("apollo/inflectionpoint", 1),
    APOLLO_WORKSTATUS_LICENSE("apollo/workstatus", 1),

    // 运输车部分
    APOLLO_HMI_LICENSE("apollo/hmi", 1), // 运输车主topic

    APOLLO_PERSONMONITOR_LICENSE("apollo/personMonitor", 1), // 巡检车检测到人


    APOLLO_ARMSTOP("apollo/armstop", 1), // 机械臂停止返回
    APOLLO_ARMINIT("apollo/arminit", 1), // 机械臂初始化返回
    APOLLO_ARMSTART("apollo/armstart", 1), // 机械臂开启返回
    /*app*/
    APP_COMMAND_CARID("app/command", 1), // 手机端指令
    /*dtu*/
    DTU_SENSOR_FARMID("dtu/sensor", 1), // 物联网传感器
    /*作业执行相关*/
    FMS_REQUEST_LICENSE("fms/request", 1),//检测启动停止发送给车端

    APOLLO_HOMEKEY_LICENSE("apollo/homeKey", 1), // 云端车端发送的 home建
    APOLLO_STATUS_LICENSE("apollo/status", 1), // 云端车端发送的 home建

    APOLLO_RUNARGUMENT_LICENSE("apollo/runArgument", 1), // 车辆运行参数

    /*通知相关*/
    FMS_NOTICE("fms/message",1),

    //*******************************************返厂相关topic***********************************************//
    FMS_CONFIG_LICENSE("fms/config", 1), // 修改配置文件
    FMS_HOMEPATH_LICESE("fms/homePath", 1),// 与path同步发, 只是前端订阅

    FMS_SCHEDULE_LICENSE("fms/schedule", 1), // 一键启动进度条

    FMS_CURRENT_PROGRESS("fms/instruction/progress",1)  // 作业进度的topic 通知前端
    /*fms/schedule/sim_car1*/
    ;

    // 真正的topic
    private String topic;
    // qos 消息级别
    private int qos;
    // 初始topic做增量使用
    private String fixed;

    Topic(String topic, int qos) {
        this.topic = topic;
        this.fixed = topic;
        this.qos = qos;
    }

    public String getTopic() {
        return topic;
    }

    public int getQos() {
        return qos;
    }

    /**
     * 增量topic
     *
     * @param param
     * @return
     */
    public Topic addPath(String param) {
        this.topic = fixed + "/" + param;
        return this;
    }

    /**
     * 打印topic 并返回当前对象
     *
     * @return
     */
    public Topic show() {
        P.purple(this.topic);
        return this;
    }
}