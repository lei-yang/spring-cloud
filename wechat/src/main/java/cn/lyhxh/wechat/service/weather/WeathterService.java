package cn.lyhxh.wechat.service.weather;

/**
 * @Description: 天气服务
 * @Author leiyang_39@163.com
 * @Date 2018/6/8 17:21
 * @Version V1.0
 */
public interface WeathterService {

    /**
     * 根据城市获取天气信息
     *
     * @param city
     * @return
     */
    String getWeather(String city);
}
