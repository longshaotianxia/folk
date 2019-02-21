package dao;

import domain.AdBlacklist;

import java.util.List;

/**
 * 广告黑名单接口
 * Created by Administrator on 2018/11/23 0023.
 */
public interface IAdBlacklistDAO {
    void insertBatch(List<AdBlacklist> adBlacklists);

    /**
     * 查询所有广告黑名单用户
     * @return
     */
    List<AdBlacklist> findAll();
}
