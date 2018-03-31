package com.anzy.bussiness.comm;

/**
 * easyUI对应的分页请求QO
 *
 * @author 当归
 * @version 2014-4-2
 */
public class DataGridQO {

    /**
     * 是否获取总数，默认：false
     */
    private boolean isGetTotal = false;
    /**
     * 当前页数,名字必须为page
     */
    private int page;
    /**
     * 每页大小,名字必须为rows
     */
    private int rows;
    /**
     * 排序字段
     */
    private String sort;
    /**
     * 排序规则
     */
    private String order;
    /**
     * 开始记录数
     */
    private int recordStart;
    /**
     * 终止记录数
     */
    private int recordEnd;
    /**
     * 总记录数
     */
    private long totalRecord;

    /**
     * 部门权限
     */
    public String dataAuth_D;
    /**
     * 用户权限
     */
    public String dataAuth_U;
    /**
     * 公共库用户名
     */
    public String dbUser;

    /**
     * 取得当前页数
     */
    public int getPage() {
        return page;
    }

    /**
     * 设置当前页数
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 取得每页大小
     */
    public int getRows() {
        return rows;
    }

    /**
     * 设置每页大小
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * 排序字段
     */
    public String getSort() {
        return sort;
    }

    /**
     * 排序字段
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 排序规则
     */
    public String getOrder() {
        return order;
    }

    /**
     * 排序规则
     */
    public void setOrder(String order) {
        this.order = order;
    }

    public int getRecordStart() {
        return recordStart;
    }

    public void setRecordStart(int recordStart) {
        this.recordStart = recordStart;
    }

    public int getRecordEnd() {
        return recordEnd;
    }

    public void setRecordEnd(int recordEnd) {
        this.recordEnd = recordEnd;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {

        this.totalRecord = totalRecord;

        if (Math.ceil(totalRecord / rows) < page) {
            this.setPage((int) Math.ceil(totalRecord / 1.0 / rows));
        }
        if (this.getPage() == 0) {
            this.setPage(1);
        }

        this.recordStart = page > 0 ? (page - 1) * rows : 0;

        this.recordEnd = recordStart + rows;
    }

    /**
     * @return 取得部门权限.
     */
    public String getDataAuth_D() {
        return dataAuth_D;
    }

    /**
     * @param 设置部门权限.
     */
    public void setDataAuth_D(String dataAuth_D) {
        this.dataAuth_D = dataAuth_D;
    }

    /**
     * @return 取得用户权限.
     */
    public String getDataAuth_U() {
        return dataAuth_U;
    }

    /**
     * @param 设置用户权限.
     */
    public void setDataAuth_U(String dataAuth_U) {
        this.dataAuth_U = dataAuth_U;
    }

    /**
     * 取得是否获取总数，默认：false
     */
    public boolean isGetTotal() {
        return isGetTotal;
    }

    /**
     * 设置是否获取总数，默认：false
     */
    public void setGetTotal(boolean isGetTotal) {
        this.isGetTotal = isGetTotal;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }
}
