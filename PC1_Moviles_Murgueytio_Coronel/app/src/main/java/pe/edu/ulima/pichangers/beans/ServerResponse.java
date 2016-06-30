package pe.edu.ulima.pichangers.beans;

public class ServerResponse {
    private String msg;

    public ServerResponse(String msg) {
        this.msg = msg;
    }

    public ServerResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
