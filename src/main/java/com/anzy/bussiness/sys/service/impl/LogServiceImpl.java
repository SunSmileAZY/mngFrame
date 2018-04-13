package com.anzy.bussiness.sys.service.impl;

import com.anzy.bussiness.sys.dao.LogDao;
import com.anzy.bussiness.sys.entity.Log;
import com.anzy.bussiness.sys.service.LogService;
import com.anzy.frame.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anzy
 * @since 2018-04-13
 */
@Service
public class LogServiceImpl extends BaseServiceImpl<LogDao, Log> implements LogService {

}
