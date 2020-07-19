package cn.chundou.blog.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliyunSmsConfig {

    @Value("${ALIYUN_SMS_REGION_ID}")
    private String regionId;

    @Value("${ALIYUN_SMS_ACCESS_KEY_ID}")
    private String accessKeyId;

    @Value("${ALIYUN_SMS_ACCESS_SECRET}")
    private String accessSecret;

    @Bean(value = "smsClient")
    public IAcsClient smsClient() {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessSecret);
        return new DefaultAcsClient(profile);
    }

}
