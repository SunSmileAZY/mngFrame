package com.anzy.bussiness.sys.entity.qo;

import com.anzy.bussiness.comm.DataGridQO;

/**
 * Created by anzy on 2018/4/13.
 */
public class LogQO extends DataGridQO {

    private String operater;
    private String systemType;

    public String getOperater() {
        return operater;
    }
    public void setOperater(String operater) {
        this.operater = operater;
    }
    public String getSystemType() {
        return systemType;
    }
    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }
}
