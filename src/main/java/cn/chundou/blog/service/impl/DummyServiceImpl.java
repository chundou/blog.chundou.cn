package cn.chundou.blog.service.impl;

import cn.chundou.blog.service.DummyService;
import org.springframework.stereotype.Service;

@Service
public class DummyServiceImpl implements DummyService {
    @Override
    public String dummy() {
        return "Dummy...";
    }
}
