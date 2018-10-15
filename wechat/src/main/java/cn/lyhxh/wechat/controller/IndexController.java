package cn.lyhxh.wechat.controller;

import com.alibaba.fastjson.JSON;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: Xiaohan Hu
 * Date: 2018/7/17 21:56
 */
@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WxMpService wxService;

    /**
     * 网页授权获取用户信息
     * @param code
     * @param modelMap
     * @return
     */
    @GetMapping("index")
    public String index(String code, ModelMap modelMap) {
        modelMap.put("say", "welcome");
        logger.info("code:{}", code);
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxService.oauth2getAccessToken(code);
            wxMpOAuth2AccessToken = wxService.oauth2refreshAccessToken(wxMpOAuth2AccessToken.getRefreshToken());
            WxMpUser userInfo = wxService.oauth2getUserInfo(wxMpOAuth2AccessToken, "zh_CN");
            logger.info("userInfo:{}", JSON.toJSONString(userInfo));

            modelMap.put("headimgurl", userInfo.getHeadImgUrl());
            modelMap.put("userInfo", userInfo);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    /**
     * freemarker使用
     *
     * @param modelMap
     * @return
     */
    @GetMapping("freemarker")
    public String freemarker(ModelMap modelMap) {
        modelMap.put("say", "welcome");
        WxMpUser userInfo = new WxMpUser();
        userInfo.setNickname("起航");
        userInfo.setSex(1);
        userInfo.setCountry("中国");
        userInfo.setProvince("浙江省");
        userInfo.setCity("杭州");
        userInfo.setHeadImgUrl("https://avatars1.githubusercontent.com/u/16114856?s=40&v=4");
        logger.info("userInfo:{}", JSON.toJSONString(userInfo));

        modelMap.put("headimgurl", userInfo.getHeadImgUrl());
        modelMap.put("userInfo", userInfo);
        return "hello";
    }

    @GetMapping("jssdk")
    public String jssdk() {

        return "jssdk";
    }

}
