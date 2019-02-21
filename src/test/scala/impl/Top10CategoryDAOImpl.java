package impl;

import dao.ITop10CategoryDAO;
import domain.Top10Category;
import jdbc.JDBCHelper;

/**
 * top10品类DAO实现
 * Created by Administrator on 2018/10/18 0018.
 */
public class Top10CategoryDAOImpl implements ITop10CategoryDAO {


   @Override
    public void insert(Top10Category category) {
        String sql = "insert into top10_category values(?,?,?,?,?)";

        Object[] params = new Object[]{category.getTaskid(),
                category.getClickCount(),
                category.getOrderCount(),
                category.getPayCount(),
                category.getClickCount()};

        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        jdbcHelper.executeUpdate(sql, params);
    }

}
