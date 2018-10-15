package cn.lyhxh.wechat.dao;

import cn.lyhxh.wechat.model.WxUserInfo;
import cn.lyhxh.wechat.model.WxUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxUserInfoMapper {
    int countByExample(WxUserInfoExample example);

    int deleteByExample(WxUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxUserInfo record);

    int insertSelective(WxUserInfo record);

    List<WxUserInfo> selectByExample(WxUserInfoExample example);

    WxUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxUserInfo record, @Param("example") WxUserInfoExample example);

    int updateByExample(@Param("record") WxUserInfo record, @Param("example") WxUserInfoExample example);

    int updateByPrimaryKeySelective(WxUserInfo record);

    int updateByPrimaryKey(WxUserInfo record);
}