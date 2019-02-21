package dao;

import domain.SessionAggrStat;

/**
 * session聚合统计模块DAO接口
 * Created by Administrator on 2018/10/11 0011.
 * @author Administrator
 */
public interface ISessionAggrStatDAO {
    /**
     * 插入session聚合统计结果
     * @param sessionAggrStat
     */
    void insert(SessionAggrStat sessionAggrStat);

}