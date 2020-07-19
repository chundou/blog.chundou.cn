package cn.chundou.blog.service.impl;

import cn.chundou.blog.constant.AliyunConstant;
import cn.chundou.blog.service.AliyunSmsService;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AliyunSmsServiceImpl implements AliyunSmsService {

    @Autowired
    @Qualifier(value = "smsClient")
    private IAcsClient client;

    @Override
    public CommonResponse code(String mobile, String code) throws ClientException, JsonProcessingException {

        // 扩展参数
        Map<String, String> params = new HashMap<>();
        params.put("code", code);

        // 构建JSON字符串
        ObjectMapper mapper = new ObjectMapper();
        String paramString = mapper.writeValueAsString(params);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");

        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", AliyunConstant.DEFAULT_SIGN_NAME);
        request.putQueryParameter("TemplateCode", AliyunConstant.TEMPLATE_CODE_VERIFY_CODE);
        request.putQueryParameter("TemplateParam", paramString);
        request.putQueryParameter("OutId", UUID.randomUUID().toString());
        return client.getCommonResponse(request);
    }
}
