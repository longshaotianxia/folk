package dao;

import domain.AdStat;

import java.util.List;

/**
 * 广告实时统计DAO接口
 * Created by Administrator on 2018/11/26 0026.
 */
public interface IAdStatDAO {
    void updateBatch(List<AdStat> adStats);

}
