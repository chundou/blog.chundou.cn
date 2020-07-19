package cn.chundou.blog.controller.api;

import cn.chundou.blog.constant.CommonResponseEnum;
import cn.chundou.blog.request.SmsCodeRequest;
import cn.chundou.blog.response.BaseResponse;
import cn.chundou.blog.service.AliyunSmsService;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.exceptions.ClientException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "apiSmsController")
@RequestMapping(value = "api/sms")
public class SmsController {

    @Autowired
    private AliyunSmsService aliyunSmsService;

    @PostMapping(value = "code")
    public BaseResponse send(@Validated @RequestBody SmsCodeRequest request) {
        try {
            CommonResponse response = aliyunSmsService.code(request.getPhone(), request.getCode());
            if (response.getHttpResponse().isSuccess()) return BaseResponse.success();
            return BaseResponse.failure(CommonResponseEnum.UNKNOWN_ERROR);
        } catch (ClientException | JsonProcessingException e) {
            e.printStackTrace();
            return BaseResponse.failure(CommonResponseEnum.UNKNOWN_ERROR);
        }
    }
}
