package dao;

import domain.AreaTop3Product;

import java.util.List;

/**
 * 各区域top3热门商品DAO接口
 * Created by Administrator on 2018/11/19 0019.
 */
public interface IAreaTop3ProductDAO {
    void insertBatch(List<AreaTop3Product> areaTop3Products);
}
