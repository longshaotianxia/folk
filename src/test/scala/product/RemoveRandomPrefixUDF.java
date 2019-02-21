package product;

import org.apache.spark.sql.api.java.UDF1;

/**
 * Created by Administrator on 2018/11/19 0019.
 */
public class RemoveRandomPrefixUDF implements UDF1<String, String> {

    private static final long serialVersionUID = 1L;

    @Override
    public String call(String val) throws Exception {
        String[] valSplited = val.split("_");
        return valSplited[1];
    }
}
