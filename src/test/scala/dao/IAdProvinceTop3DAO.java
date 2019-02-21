package dao;

import domain.AdProvinceTop3;

import java.util.List;

/**
 * 各省top3热门广告DAO接口
 * Created by Administrator on 2018/12/6 0006.
 */
public interface IAdProvinceTop3DAO {
    void updateBatch(List<AdProvinceTop3> adProvinceTop3s);
}
