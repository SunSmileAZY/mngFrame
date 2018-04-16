package com.anzy.bussiness.sys.service.impl;

import com.anzy.bussiness.sys.dao.LogDao;
import com.anzy.bussiness.sys.entity.Log;
import com.anzy.bussiness.sys.entity.qo.LogQO;
import com.anzy.bussiness.sys.service.LogService;
import com.anzy.frame.base.service.impl.BaseServiceImpl;
import com.anzy.frame.utils.R;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public R listLogPage(LogQO logQO){
        try {
            Page<Log> a = new Page<Log>(logQO.getPage(), logQO.getRows(),"log_dt");
            a.setAsc(false);
            Page<Log> logPage = selectPage(a,  new EntityWrapper<Log>()
                    .like("OPERATER", StringUtils.isBlank(logQO.getOperater()) ? "" : logQO.getOperater())
                    .like("system_type", StringUtils.isBlank(logQO.getSystemType()) ? "" : logQO.getSystemType()));
            return R.ok().put("rows", logPage.getRecords()).put("total", logPage.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error();
    }

}
