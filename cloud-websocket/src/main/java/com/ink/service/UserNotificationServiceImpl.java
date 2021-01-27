package com.ink.service;

import com.ink.domain.UserNotification;
import com.ink.mapper.UserNotificationMapper;
import com.ink.service.impl.UserNotificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {

    @Resource
    private UserNotificationMapper userNotificationMapper;

    @Override
    public int insertSelective(UserNotification record) {
        return userNotificationMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(UserNotification record) {
        return userNotificationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateBatchSelective(List<UserNotification> list) {
        return userNotificationMapper.updateBatchSelective(list);
    }
}

