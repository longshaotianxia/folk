package dao;

import domain.SessionRandomExtract;

/**
 * session随机抽取模块DAO接口
 * Created by Administrator on 2018/10/17 0017.
 */
public interface ISessionRandomExtractDAO {
    /**
     * 插入session随机抽取
     */
    void insert(SessionRandomExtract sessionRandomExtract);
}
