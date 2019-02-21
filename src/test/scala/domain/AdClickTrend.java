package domain;

/**
 * 广告点击趋势
 * Created by Administrator on 2018/12/6 0006.
 */
public class AdClickTrend {
    private String date;
    private String houre;
    private String minute;
    private long adid;
    private long clickCount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHoure() {
        return houre;
    }

    public void setHoure(String houre) {
        this.houre = houre;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public long getAdid() {
        return adid;
    }

    public void setAdid(long adid) {
        this.adid = adid;
    }

    public long getClickCount() {
        return clickCount;
    }

    public void setClickCount(long clickCount) {
        this.clickCount = clickCount;
    }
}
