package domain;

/**
 * 各区域top3热门商品
 * Created by Administrator on 2018/11/19 0019.
 */
public class AreaTop3Product {
    private long taskid;
    private String area;
    private String areaLevel;
    private long productid;
    private String cityInfos;
    private String productStatus;

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public long getTaskid() {
        return taskid;
    }

    public void setTaskid(long taskid) {
        this.taskid = taskid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getCityInfos() {
        return cityInfos;
    }

    public void setCityInfos(String cityInfos) {
        this.cityInfos = cityInfos;
    }

    public long getClickCount() {
        return clickCount;
    }

    public void setClickCount(long clickCount) {
        this.clickCount = clickCount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getGetProductStatus() {
        return getProductStatus;
    }

    public void setGetProductStatus(String getProductStatus) {
        this.getProductStatus = getProductStatus;
    }

    private long clickCount;
    private String productName;
    private String getProductStatus;

}
