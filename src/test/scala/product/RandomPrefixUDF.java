package product;

import org.apache.spark.sql.api.java.UDF2;

import java.util.Random;

/**
 * Created by Administrator on 2018/11/19 0019.
 */
public class RandomPrefixUDF implements UDF2<String, Integer, String> {

    private static final long serialVersionUID = 1L;

    @Override
    public String call(String val, Integer num) throws Exception {
        Random random = new Random();
        int randNum = random.nextInt(10);
        return randNum + "_" + val;
    }
}
