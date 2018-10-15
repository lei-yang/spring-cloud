package cn.lyhxh.wechat.handler;

import cn.lyhxh.wechat.builder.ImageBuilder;
import cn.lyhxh.wechat.builder.TextBuilder;
import cn.lyhxh.wechat.service.weather.WeathterService;
import cn.lyhxh.wechat.utils.JsonUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.builder.outxml.NewsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description: 消息处理
 * @Author leiyang_39@163.com
 * @Date 2018/6/8 13:56
 * @Version V1.0
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Autowired
    private WeathterService weathterService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(WxConsts.XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                    && weixinService.getKefuService().kfOnlineList()
                    .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser()).build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        // 图片消息
//        return new ImageBuilder().build(wxMessage.getMediaId(), wxMessage, weixinService);

        WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
        item.setTitle("黄焖鸡米饭");
        item.setDescription("中午吃黄焖鸡米饭");
        item.setPicUrl("http://www.kxdz2.com/images/banner.jpg");
        item.setUrl("http://www.kxdz2.com/");
        return new NewsBuilder().addArticle(item).fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser()).build();

        // 文本消息
//        String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);
//        String content = weathterService.getWeather(wxMessage.getContent());
//        return new TextBuilder().build(content, wxMessage, weixinService);
    }

}
