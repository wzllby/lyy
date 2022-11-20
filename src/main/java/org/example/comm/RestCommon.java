package org.example.comm;

public class RestCommon {
    private int code;

    private String descript;

    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public RestCommon(int code, String descript, String data) {
        this.code = code;
        this.descript = descript;
        this.data = data;
    }
}
