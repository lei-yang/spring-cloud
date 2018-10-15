package cn.lyhxh.wechat.service.weather;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 天气实现类
 * @Author leiyang_39@163.com
 * @Date 2018/6/8 17:21
 * @Version V1.0
 */
@Service
public class WeathterServiceImpl implements WeathterService {

    @Value("${amap.weather.key}")
    private String wheatherKey;

    @Override
    public String getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        JSONObject weatherJson = restTemplate.getForObject("http://restapi.amap.com/v3/weather/weatherInfo?key="+wheatherKey+"&city=" + city, JSONObject.class);
        if (HttpStatus.OK.getReasonPhrase().equalsIgnoreCase(weatherJson.getString("info"))) {
            JSONArray weatherArr = weatherJson.getJSONArray("lives");
            if (weatherArr.size() > 0) {
                JSONObject weather = weatherArr.getJSONObject(0);

                return "城市:" + weather.getString("city") + ";天气:" + weather.getString("weather") + ";温度:" + weather.getString("temperature");
            }
        }
        return "查询天气失败";
    }
}
