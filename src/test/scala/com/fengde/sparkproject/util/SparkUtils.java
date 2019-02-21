package com.fengde.sparkproject.util;

import com.alibaba.fastjson.JSONObject;
import conf.ConfigurationManager;
import constants.Constants;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;
import test.MockData;

/**
 * Spark工具类
 * Created by Administrator on 2018/11/13 0013.
 */
public class SparkUtils {
    /**
     * 根据当前是否本地测试的配置
     * @param conf
     */
    public static void setMaster(SparkConf conf){
       boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
       if(local){
           conf.setMaster("local");
       }
    }
    public static SQLContext getSQLContext(SparkContext sc) {
        boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
        if(local){
            return new SQLContext(sc);

        }else {
            return new HiveContext(sc);
        }
    }
    /**
     * 生产模拟数据
     * 如果spark.local配置设置为true侧生成模拟数据，否则不生产
     *
     */
    public static void mockData(JavaSparkContext sc, SQLContext sqlContext){
        boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
        if(local){
            MockData.mock(sc,sqlContext);
        }
    }
    public static JavaRDD<Row> getActionRDDByDateRange(
            SQLContext sqlContext, JSONObject taskParam) {
        String startDate = ParamUtils.getParam(taskParam, Constants.PARAM_START_DATE);
        String endDate = ParamUtils.getParam(taskParam, Constants.PARAM_END_DATE);

        String sql =
                "select * "
                        + "from user_visit_action "
                        + "where date>='" + startDate + "' "
                        + "and date<='" + endDate + "'";

        DataFrame actionDF = sqlContext.sql(sql);

        return actionDF.javaRDD();
    }


}
