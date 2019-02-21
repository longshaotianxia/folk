package impl;

import dao.ITop10CategoryDAO;
import dao.ITop10SessionDAO;
import domain.Top10Session;
import jdbc.JDBCHelper;

/**
 * top10活跃session的DAO实现
 * Created by Administrator on 2018/10/19 0019.
 */
public class Top10SessionDAOImpl implements ITop10SessionDAO {

    @Override
    public void insert(Top10Session top10Session){
        String sql = "insert into top_session value(?,?,?,?)";

        Object[] params = new Object[]{top10Session.getTaskid(),
                  top10Session.getCategoryid(),
                  top10Session.getClickCount(),
                  top10Session.getSessionid()};
        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        jdbcHelper.executeUpdate( sql,params );

    }
}
