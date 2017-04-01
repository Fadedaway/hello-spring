package me.jovi.hellospring.entity;

/**
 * Created by joyce on 2017/4/1.
 */
public class ReqResult<T> {

    private boolean success;

    private T data;

    public static <Q> ReqResult<Q> success(Q data){
        ReqResult<Q> reqResult = new ReqResult<Q>();
        reqResult.setSuccess(true);
        reqResult.setData(data);
        return reqResult;
    }

    public static <Q> ReqResult<Q> failure(Q data){
        ReqResult<Q> reqResult = new ReqResult<Q>();
        reqResult.setData(data);
        reqResult.setSuccess(false);
        return reqResult;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
