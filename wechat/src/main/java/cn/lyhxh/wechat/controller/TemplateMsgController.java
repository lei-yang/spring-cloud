package cn.lyhxh.wechat.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateIndustry;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Xiaohan Hu
 * Date: 2018/5/20 16:59
 */
@RestController
@RequestMapping("/wechat/template")
public class TemplateMsgController implements WxMpTemplateMsgService {

    @Autowired
    private WxMpService wxService;


    @Override
    @PostMapping("setIndustry")
    public boolean setIndustry(WxMpTemplateIndustry wxMpTemplateIndustry) throws WxErrorException {
        boolean flag = false;
        try {
            WxMpTemplateIndustry.Industry primaryIndustry = new WxMpTemplateIndustry.Industry("1");
            WxMpTemplateIndustry.Industry secondIndustry = new WxMpTemplateIndustry.Industry("2");

            WxMpTemplateIndustry templateIndustry = new WxMpTemplateIndustry();
            templateIndustry.setPrimaryIndustry(primaryIndustry);
            templateIndustry.setSecondIndustry(secondIndustry);
            flag = wxService.getTemplateMsgService().setIndustry(templateIndustry);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    @GetMapping("getIndustry")
    public WxMpTemplateIndustry getIndustry() throws WxErrorException {
        return wxService.getTemplateMsgService().getIndustry();
    }

    @Override
    @PostMapping("send")
    public String sendTemplateMsg(WxMpTemplateMessage wxMpTemplateMessage) throws WxErrorException {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setToUser("oPw5v1k_sC8jCi_JqqfdcJwu5y9w");
        templateMessage.setTemplateId("sB3S14Hf94wxdYOQLbJQX__rkNJoViG7Vq8yohjQLTI");

        WxMpTemplateData templateData = new WxMpTemplateData();
        templateData.setName("result");
        templateData.setValue("520节日快乐");

        List<WxMpTemplateData> templateDataList = new ArrayList<>();
        templateDataList.add(templateData);
        templateMessage.setData(templateDataList);

        wxService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        return null;
    }

    @Override
    @PostMapping("add")
    public String addTemplate(String s) {
        String str = "TM00015";
        try {
            str = wxService.getTemplateMsgService().addTemplate(s);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    @GetMapping("list")
    public List<WxMpTemplate> getAllPrivateTemplate() throws WxErrorException {
        List<WxMpTemplate> wxMpTemplateList = new ArrayList<>();
        try {
            wxService.getTemplateMsgService().getAllPrivateTemplate();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return wxMpTemplateList;
    }

    @Override
    public boolean delPrivateTemplate(String s) throws WxErrorException {
        return false;
    }
}
