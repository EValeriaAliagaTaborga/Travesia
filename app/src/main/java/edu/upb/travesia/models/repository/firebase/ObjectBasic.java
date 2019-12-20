package edu.upb.travesia.models.repository.firebase;

public class ObjectBasic {

    private String obj;
    private int number;

    public ObjectBasic(String obj, int number) {
        this.obj = obj;
        this.number = number;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
