package dao;

import domain.SessionDetail;

/**
 * Session明细DAO接口
 * Created by Administrator on 2018/10/17 0017.
 */
public interface ISessionDetailDAO {

    /**
     * 插入一条session明细数据
     * @param sessionDetail
     */
    void insert(SessionDetail sessionDetail);

}
