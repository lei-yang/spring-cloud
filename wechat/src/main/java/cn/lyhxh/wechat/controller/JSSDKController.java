package cn.lyhxh.wechat.controller;

import com.alibaba.fastjson.JSON;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Xiaohan Hu
 * Date: 2018/7/18 22:13
 */
@RestController
@RequestMapping("jssdk")
public class JSSDKController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WxMpService wxService;

    /**
     *
     * 同一个url仅需调用一次
     * @param url
     * @param modelMap
     * @return
     */
    @GetMapping("signature")
    public String jsapiSignature(@RequestParam String url, ModelMap modelMap) {
        if (StringUtils.isEmpty(url)) {
            return null;
        }
        try {
            logger.info("url:{}", url);
            WxJsapiSignature jsapiSignature = wxService.createJsapiSignature(url);
            logger.info("WxJsapiSignature:{}", JSON.toJSONString(jsapiSignature));
            modelMap.put("jsapiSignature", jsapiSignature);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "jssdk";
    }
    
}
