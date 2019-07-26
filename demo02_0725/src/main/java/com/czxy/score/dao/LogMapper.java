package com.czxy.score.dao;

import com.czxy.score.domain.Log;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface LogMapper extends Mapper<Log> {
}
