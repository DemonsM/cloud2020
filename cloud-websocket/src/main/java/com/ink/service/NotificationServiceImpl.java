package com.ink.service;

import com.ink.domain.Notification;
import com.ink.mapper.NotificationMapper;
import com.ink.service.impl.NotificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Resource
    private NotificationMapper notificationMapper;

    @Override
    public int insertSelective(Notification record) {
        return notificationMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Notification record) {
        return notificationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateBatchSelective(List<Notification> list) {
        return notificationMapper.updateBatchSelective(list);
    }
}

