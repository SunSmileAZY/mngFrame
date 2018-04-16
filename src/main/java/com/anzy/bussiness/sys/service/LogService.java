package com.anzy.bussiness.sys.service;


import com.anzy.bussiness.sys.entity.Log;
import com.anzy.bussiness.sys.entity.qo.LogQO;
import com.anzy.frame.base.service.BaseService;
import com.anzy.frame.utils.R;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author anzy
 * @since 2018-04-13
 */
@Service
public interface LogService extends BaseService<Log> {

    R listLogPage(LogQO logQO);

}
