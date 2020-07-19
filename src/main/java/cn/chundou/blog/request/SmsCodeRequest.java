package cn.chundou.blog.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SmsCodeRequest {

    @NotNull(message = "手机不可为空")
    @Length(min = 11, max = 11, message = "手机号码长度不正确")
    private String phone;

    @NotNull(message = "验证码不能为空")
    @Length(min = 4, max = 8)
    private String code;
}
