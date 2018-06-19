package zhhaizy.zhhaizy.domain;


public class Result {

    private String message;//返回消息

    private Integer state;//返回状态

    private Object data;//传输数据

    public Result(String message, Integer state) {
        this.message = message;
        this.state = state;
    }

    public Result(String message, Integer state, Object data) {

        this.message = message;
        this.state = state;
        this.data = data;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
