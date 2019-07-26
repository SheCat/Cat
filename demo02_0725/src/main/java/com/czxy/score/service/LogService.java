package com.czxy.score.service;

import com.czxy.score.domain.User;

public interface LogService {
    void add(User user);

    void update(User user);

    void del(User user);
}
