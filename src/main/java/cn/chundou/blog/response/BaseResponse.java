package cn.chundou.blog.response;

import cn.chundou.blog.constant.CommonResponseEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BaseResponse {
    private Long status;
    private String message;
    private Object result;

    private BaseResponse() {
        this.status = 0L;
        this.message = "Success";
        this.result = null;
    }

    public static BaseResponse success() {
        return new BaseResponse();
    }

    public static BaseResponse success(String message) {
        BaseResponse response = new BaseResponse();
        response.message = message;
        return response;
    }

    public static BaseResponse success(Object result) {
        BaseResponse response = new BaseResponse();
        response.result = result;
        return response;
    }

    public static BaseResponse success(Object[] results) {
        Map<String, Object> myResult = new HashMap<>();
        myResult.put("data", results);

        BaseResponse response = new BaseResponse();
        response.result = myResult;
        return response;
    }

    public static BaseResponse success(String key, Object[] results) {
        Map<String, Object> myResult = new HashMap<>();
        myResult.put(key, results);

        BaseResponse response = new BaseResponse();
        response.result = myResult;
        return response;
    }

    public static BaseResponse failure(CommonResponseEnum responseEnum) {
        BaseResponse response = new BaseResponse();
        response.status = responseEnum.getStatus();
        response.message = responseEnum.getMessage();
        return response;
    }
}
