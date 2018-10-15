package cn.lyhxh.wechat.dao.custom;

import java.util.List;
import java.util.Map;

/**
 * @Description: 自定义Mapper
 * @Author leiyang_39@163.com
 * @Date 2018/6/28 16:03
 * @Version V3.0
 */
public interface CustomMapper {

    /**
     * 自定义sql查询
     * @param sql
     * @return
     */
    List<Map> executeSql(String sql);

    /**
     * 自定义map查询
     * @param map
     * @return
     */
    List<Map> executeParamsSql(Map map);
}
