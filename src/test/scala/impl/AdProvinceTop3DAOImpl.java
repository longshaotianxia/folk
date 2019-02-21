package impl;

import dao.IAdProvinceTop3DAO;
import domain.AdProvinceTop3;
import jdbc.JDBCHelper;
import scala.tools.cmd.gen.AnyVals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/6 0006.
 */
public class AdProvinceTop3DAOImpl implements IAdProvinceTop3DAO {
    @Override
    public void updateBatch(List<AdProvinceTop3> adProvinceTop3s) {
        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        List<String> dateProvinces = new ArrayList<String>();
        for(AdProvinceTop3 adProvinceTop3:adProvinceTop3s){
            String date = adProvinceTop3.getDate();
            String province = adProvinceTop3.getProvince();
            String key = date + "_" + province;

            if (!dateProvinces.contains(key)){
                dateProvinces.add(key);
            }
            //根据去重后的date和province,进行批量删除操作
            String deleteSQL = "DELETE FROM ad_province_top3 WHERE date=? AND province=?";
            List<Object[]> deleteParmsList = new ArrayList<Object[]>();
            for (String dateProvince:dateProvinces){
                String[] dateProviceSplited = dateProvince.split("_");
                date = dateProviceSplited[0];
                province = dateProviceSplited[1];

                Object[] params = new Object[]{date,province};
                deleteParmsList.add(params);
            }
            jdbcHelper.executeBatch(deleteSQL,deleteParmsList);
        }

        String insertSQL = "INSERT INTO ad_proince_top3 VALUES(?,?,?,?)";

        List<Object[]> insertParamsList = new ArrayList<Object[]>();
        for (AdProvinceTop3 adProvinceTop3 : adProvinceTop3s){
            Object[] params = new Object[]{adProvinceTop3.getDate(),
            adProvinceTop3.getAdid(),
            adProvinceTop3.getClickCount()};

            insertParamsList.add(params);

        }
        jdbcHelper.executeBatch(insertSQL, insertParamsList);
    }
}
