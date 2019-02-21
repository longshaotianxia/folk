package dao;

import domain.AdClickTrend;

import java.util.List;

/**
 * 广告点击趋势DAO接口
 * Created by Administrator on 2018/12/6 0006.
 */
public interface IAdClickTrendDAO {
    void updateBatch(List<AdClickTrend> adClickTrends);
}
