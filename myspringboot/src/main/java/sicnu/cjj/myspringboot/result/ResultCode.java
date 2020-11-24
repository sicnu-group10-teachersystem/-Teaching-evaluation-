package sicnu.cjj.myspringboot.result;


/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200, "sucess"),//成功
    FAIL(400, "失败"),//失败
    ;

    private Integer code;
    private String msg;

    ResultCode(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
