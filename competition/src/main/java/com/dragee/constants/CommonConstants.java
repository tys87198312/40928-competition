package com.dragee.constants;

/**
 * 通用常量类
 */
public interface CommonConstants {

    /*分页*/
    String LIMIT = "rowsPerPage";
    String START = "page";
    int LIMIT_SIZE = 10;
    int START_SIZE = 0;
    String initPassword = "123456";


    String SUC = "success";
    /*图层*/
    // 图层文件上传目录
    String LAYER_DIR = "/layer";
    String CAR_IMAGE_DIR = "/carimage";
    String APK_DIR = "/apk";
    String USER_AVATAR = "/avatar";
    String ROOT_DIR = "/api/cloudControl/file";
    // 图层格式
    String LAYER_TYPE_JSON = "geojson";
    String LAYER_TYPE_PNGJPG = "png/jpg";
    String LAYER_TYPE_LineString = "LineString"; // MultiLineString LineString
    String LAYER_TYPE_MultiLineString = "MultiLineString"; // MultiLineString LineString
    String LAYER_TYPE_POINT = "Point";


    /*拓扑相关表*/
    String TOPO_FORMAT = "t_%s_topo";
    String POINT_FORMAT = "t_%s_pointway";
    String TRANSPORT_POINT_FORMAT = "t_%s_transportpoint";

    /*道路级别定义*/
    double LEVEL_TURNAROUND = 10.0;
    double LEVEL_GOTRAIGHT = 1.0;

    /*车状态*/
    String CAR_STATUS_ONLINE = "online"; // 上线状态
    String CAR_STATUS_OFFLINE = "offline"; // 未上线状态
    String CAR_STATUS_WORKING = "working"; //
    String CAR_STATUS_ROUTING = "routing";

    /*指令类型*/
    String INSTRUCTION_TYPE_PLAN = "plan";
    String INSTRUCTION_TYPE_TEMP = "temp";

    /*车辆操作*/
    String OPT_CHECK = "check";
    String OPT_START = "start";
    String OPT_STOP = "stop";
    String OPT_STATUS = "status";

    /*触发返场阈值*/
    Integer MIN_WATER = 10;
    Integer MIN_BATTERY = 10;
    Integer MIN_OIL = 10;

    /*任务类型*/
    String TASK_ADD_WATER = "add_water";
    String TASK_ADD_BATTERY = "add_battery";
    String TASK_ADD_OIL = "add_oil";
    String TASK_RETURN_WORK_POINT = "return_work_point";
    String TASK_CONTINUE_WORK = "continue_work";




    /*心跳相关*/
    long CAR_ACTIVE_TIME = 10000;
    long CAR_OFFLINE_CHECKTIME = 4000; // 下线统一检测时间
    long CAR_SENDHEART_TIME = 1000; // 发送心跳间隔

    /*响应时间*/
    long TIMOUT_SEND_PATH = 20;
    long TIMOUT_CHECK = 30;
    long TIMOUT_START = 10;
    long TIMOUT_STOP = 10;
    long TIMOUT_STATUS = 10;

    Integer HAVE_SENT = 1;
    Integer NOT_SEND = 0;

    /*步数值*/
    Integer STEP_COUNT = 1;

}
