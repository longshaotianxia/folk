package impl;

import dao.IAdClickTrendDAO;
import domain.AdClickTrend;
import jdbc.JDBCHelper;
import model.AdClickTrendQueryResult;
import scala.tools.cmd.gen.AnyVals;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/6 0006.
 */
public class AdClickTrendDAOimpl implements IAdClickTrendDAO {
    @Override
    public void udateBatch(List<AdClickTrend> adClickTrends) {
        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        List<AdClickTrend> updateAdClickTrends = new ArrayList<AdClickTrend>();
        List<AdClickTrend> insertAdClickTrends = new ArrayList<AdClickTrend>();

        String selectSQL = "SELECT count(*)"
                 + "FROM ad_click_trend"
                 + "WHERE date=?"
                 + "AND hour=?"
                 + "AND minute=?"
                 + "AND ad_id=?";
        for (AdClickTrend adClickTrend : adClickTrends){
            final AdClickTrendQueryResult queryResult = new AdClickTrendQueryResult();
            Object[] params = new Object[]{adClickTrend.getDate(),
            adClickTrend.getHoure(),
            adClickTrend.getMinute(),
            adClickTrend.getAdid()};

            jdbcHelper.executeQuery(selectSQL, params, new JDBCHelper.QueryCallback() {
                @Override
                public void process(ResultSet rs) throws Exception {
                    if (rs.next()){
                        int count = rs.getInt(1);
                        queryResult.setCount(count);
                    }
                }
            });
            int count = queryResult.getCount();
            if (count > 0){
                updateAdClickTrends.add(adClickTrend);
            }else {
                insertAdClickTrends.add(adClickTrend);
            }

        }
        //批量更新
        String updateSQL = "UPDATE ad_click_trned SET click_count=?"
                + "WHERE date=?"
                + "AND hour=?"
                + "AND minute=?"
                + "AND ad_id=?";
        List<Object[]> updateParamsList = new ArrayList<Object[]>();
        for (AdClickTrend adClickTrend : updateAdClickTrends){
            Object[] params = new Object[]{adClickTrend.getClickCount(),
            adClickTrend.getDate(),
            adClickTrend.getHoure(),
            adClickTrend.getMinute(),
            adClickTrend.getAdid()};
            updateParamsList.add(params);
        }
        jdbcHelper.executeBatch(updateSQL, updateParamsList);

        //批量更新
      String insertSQL = "INSERT INTO ad_click_trend VALUES(?,?,?,?,?)";
      List<Object[]> insertParamsList = new ArrayList<Object[]>();
      for (AdClickTrend adClickTrend : insertAdClickTrends){
          Object[] params = new Object[]{adClickTrend.getDate(),
          adClickTrend.getHoure(),
          adClickTrend.getMinute(),
          adClickTrend.getAdid(),
          adClickTrend.getClickCount()};

          insertParamsList.add(params);
      }
      jdbcHelper.executeBatch(updateSQL, updateParamsList);


    }
}
