package com.dragee.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 业务异常 5xx 前端直接展示给用户  其他的前端打印
 * @author tys on 11/2/20
 */
@Getter
@AllArgsConstructor
public enum BusinessErrorType {

    EXCEPTION(500, "未知异常,请联系管理员"),

    /*业务 901 - 999*/
    INVALID_PARAMS(501, "参数录入错误"),
    FILE_ERROR_JSON(506, "样式和文件类型不匹配"),
    FILE_NOTSUPPORT_TYPE(507, "不支持的文件类型"),
    FILE_NOT_EXISTS(507, "文件不存在"),
    FILE_UPLOAD_ERROR(507, "文件上传失败"),
    FILE_READ_FAILURE(507, "读取解析文件失败"),
    LICENSE_EXISTED(501, "车牌已存在, 请重新录入"),
    ROLES_EXISTED(502, "角色已存在, 请重新录入"),
    EXIST_WAITINGEXCUTING(508, "车辆存在待执行指令，请稍后发送"),
    PLAN_ERROR(508, "作业计划未规划或规划错误, 请重新规划"),
    CAR_NOONLINE(509, "车辆未上线, 操作失败"),
    ONLY_DEL_NOSEND_INSTRUCTION(509, "只能删除未发送的指令"),
    FUTURE_TIMEOUT(510, "操作超时"),
    SEND_INSTRUCTION_FAILE(511, "发送指令失败"),
    CAR_ALREADY_BIND(512, "车辆已绑定"),
    SERVER_ERROR(513, "远程服务异常"),
    SERVER_INNER_ERROR(514, "远程服务内部异常"),
    CAR_WORKAREA_NOT_EXISTS(515,"该车辆不存在作业记录"),

    NO_RECORDS(902, "不存在的记录"),
    ERROR_JSON(903, "json格式错误"),


    ;
    private int code;
    private String msg;

}
