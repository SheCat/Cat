package com.czxy.score.service;

import com.czxy.score.dao.LogMapper;
import com.czxy.score.domain.Log;
import com.czxy.score.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public void add(User user) {
        Log log = new Log(null,user.getId(),user.getUsername(),"add",new Date());
        logMapper.insert(log);
    }

    @Override
    public void update(User user) {
        Log log = new Log(null,user.getId(),user.getUsername(),"update",new Date());
        logMapper.insert(log);
    }

    @Override
    public void del(User user) {
        Log log = new Log(null,user.getId(),user.getUsername(),"del",new Date());
        logMapper.insert(log);
    }
}
