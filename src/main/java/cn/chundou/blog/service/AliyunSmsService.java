package cn.chundou.blog.service;

import com.aliyuncs.CommonResponse;
import com.aliyuncs.exceptions.ClientException;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AliyunSmsService {
    CommonResponse code(String mobile, String code) throws ClientException, JsonProcessingException;
}
