package impl;

import dao.ISessionRandomExtractDAO;
import domain.SessionRandomExtract;
import jdbc.JDBCHelper;

/**
 * 随机抽取session的DAO实现
 * Created by Administrator on 2018/10/17 0017.
 */
public class SessionRandomExtractDAOImpl implements ISessionRandomExtractDAO {

    /**
     * 插入session随机抽取
     */
    public void insert(SessionRandomExtract sessionRandomExtract) {
        String sql = "insert into session_random_extract values(?,?,?,?,?)";

        Object[] params = new Object[]{sessionRandomExtract.getTaskid(),
                sessionRandomExtract.getSessionid(),
                sessionRandomExtract.getStartTime(),
                sessionRandomExtract.getSearchKeywords(),
                sessionRandomExtract.getClickCategoryIds()};

        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        jdbcHelper.executeUpdate(sql, params);
    }
}

