package com.dragee.constants;

/**
 * 指令状态
 *
 * @author tys on 12/14/20
 */
public enum  InstructionStauts {

    NOSEND("nosend", "未发送"),
    WAITINGEXECUTE("waitingExecute", "等待执行"),
    EXECUTING("executing", "执行中"),
    OVER("over", "执行完成"),
    CANEL("cancel", "指令取消"),
    GOHOMING("goHoming", "返场中"),
    ARRIVEHOME("arriveHome", "到达返场点"),
    ARRIVEWORK("arriveWork", "到达续作点"),
    RETURNWORKING("returnWorking", "返回作业点"),
    INSERROR("insError", "指令异常")

    ;

    private String value;
    private String text;

    InstructionStauts(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public static String getText (String value) {
        for (InstructionStauts instructionStauts : values()) {
            if (instructionStauts.getValue().equals(value)) {
                return instructionStauts.getText();
            }
        }
        return "";
    }

    public static String[] getNoActiveStatus () {
        return new String[] {NOSEND.value,
                OVER.value,
                CANEL.value,
                INSERROR.value};
    }

    public static String[] getActiveStatus () {
        return new String[] {WAITINGEXECUTE.value,
                EXECUTING.value,
                GOHOMING.value,
                ARRIVEHOME.value,
                RETURNWORKING.value,
                ARRIVEWORK.value};
    }

    public static String[] getGoHomeStatus () {
        return new String[] {GOHOMING.value,
                ARRIVEHOME.value,
                RETURNWORKING.value,
                ARRIVEWORK.value};
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
