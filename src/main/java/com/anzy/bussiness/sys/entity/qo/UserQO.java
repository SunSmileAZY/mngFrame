package com.anzy.bussiness.sys.entity.qo;

import com.anzy.bussiness.comm.DataGridQO;

/**
 * Created by anzy on 2018/3/31.
 */
public class UserQO extends DataGridQO{

    private String username;
    private String email;
    private String loginAccount;

    public String getLoginAccount() {
        return loginAccount;
    }
    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
