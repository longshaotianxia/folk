package dao;

import domain.AdUserClickCount;

import java.util.List;

/**
 * 用户广告点击量DAO接口
 * Created by Administrator on 2018/11/21 0021.
 */
public interface IAdUserClickCountDAO {

    void updateBatch(List<AdUserClickCount> adUserClickCounts);
    int findClickCountByMultiKey(String date,long userid,long adid);
}
